package com.prac.home.datastructures.stack;

import java.util.Stack;

/**
 * let try with single stack
 */
public class QueueViaStacks {

    Stack<Integer> newStack= new Stack<>();
    Stack<Integer> oldStack = new Stack<>();

    void add(int i){
        newStack.push(i);
    }

    Integer peek(){
        if(oldStack.isEmpty()){
            while (!newStack.isEmpty()){
                oldStack.push(newStack.pop());
            }
        }
        return oldStack.pop();
    }

    public static void main(String[] args) {
        QueueViaStacks queue= new QueueViaStacks();
        queue.add(1); queue.add(2); queue.add(3); queue.add(4); queue.add(5);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());


    }
}






















