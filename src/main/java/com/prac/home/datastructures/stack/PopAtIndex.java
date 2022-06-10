package com.prac.home.datastructures.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * stack can be implemented using arrays and can be constructed using LinkedList maintaining two pointer top and bottom.
 * Add new stack if current reaches it capacity
 */
public class PopAtIndex {

    int capacity;
    List<Stack> stacks= new ArrayList<>();

    PopAtIndex(int capacity){
        this.capacity=capacity;
    }

    Stack getLastStack(){
        return stacks.get(stacks.size()-1);
    }

    void push(int i){
        // push will always be in last stack
        Stack stack= getLastStack();
        if(stack.isFull()){
            stack= new Stack(capacity);
            stack.push(i);
            stacks.add(stack);
        }else {
            stack.push(i);
        }
    }

    int pop(){
        Stack stack= getLastStack();
        int val = stack.pop();
        if (stack.isEmpty()){
            stacks.remove(stack.size-1);
        }
        return val;
    }
    /*boolean isFull(){

    }
    boolean isEmpty(){

    }*/
    int popAtIndex(int index) {
      return   leftShift(index, true);
    }
  // recursion
    int leftShift(int index, boolean removeFromTop){
        // this index is of stack
        Stack stack = stacks.get(index);
        int val=0;
        if (removeFromTop) val = stack.pop();
        else val = stack.removeBottom();
        // now shifting
        if(stack.isEmpty()){
            stacks.remove(index);
        }else if(stacks.size()-1 > index){
           int v = leftShift(index+1, false);
           stack.push(v);
        }
        //
        return val;
    }

    public static void main(String[] args) {

    }
    // this is stack with doubly linked list
    class Stack{

        class Node{
            int data;
            Node above;
            Node below;
            Node(int data){
                this.data=data;
            }
        }

        Node top, bottom;
        int size, capacity=0;
        Stack(int capacity){
            this.capacity=capacity;
        }

        public boolean isFull() { return capacity == size; }

        void join(Node above, Node below){
            if(below!=null) below.above=above;
            if(above!=null) above.below=below;
        }

        boolean push(int i){
            if(size>=capacity) {
                return false;
            }
            size++;
            Node t = new Node(i);
            if (size==1) {
                bottom=t;
            }
            join(t, top);
            top=t;
            return true;
        }
        int pop(){
            Node n = top;
            top= top.below;
            size--;
            return n.data;
        }
        public boolean isEmpty() {
            return size==0;
        }

        int removeBottom(){
            Node n = bottom;
            bottom= bottom.above;
            if(bottom.below!=null) bottom.below=null;
            size--;
            return n.data;
        }
    }
}




















