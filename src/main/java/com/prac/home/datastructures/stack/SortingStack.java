package com.prac.home.datastructures.stack;

import java.util.Stack;

/**
 * Sorting
 */
public class SortingStack {

    Stack<Integer> stack= new Stack();
    Stack<Integer> additionalStack= new Stack();

    void add(Integer i){
        if(stack.isEmpty()){
            stack.push(i);
        }else {
            while (!stack.isEmpty() && stack.peek() > i){
                additionalStack.push(stack.pop());
            }
            stack.push(i);
            while (!additionalStack.isEmpty()){
                stack.push(additionalStack.pop());
            }
        }
    }

    Integer pop(){
        return stack.pop();
    }

    public static void main(String[] args) {
        SortingStack st= new SortingStack();
        st.add(5); st.add(1); st.add(2); st.add(4);
        while (!st.stack.isEmpty())
            System.out.println(st.pop());
    }
}
