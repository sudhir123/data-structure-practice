package com.prac.home.datastructures.stack;

import java.util.Stack;

/**
 * returns the minimum element. Needed to O(1). First solution to maintain the variable minVal and while pushing an element
 * we will check with the existing minValue. Problem with this solution is lets say 10, 11, 1 in stack. Min is 1 ,
 * all good but what if we pop 1 from stack and now min is supposed to be 10.
 * best is to maintain another stack for min
 */
public class MinimumElement {

    SingleArraySingleStack s ;
    SingleArraySingleStack minStack;
    MinimumElement(SingleArraySingleStack stack, SingleArraySingleStack minStack){
        this.s=stack;
        this.minStack=minStack;
    }

    int minElement() throws Exception {
        return minStack.peek(0);
    }

     void push(int i) throws Exception {
        if(!s.ifFull(0)){
            s.push(0, i);
            if(minStack.ifEmpty(0)|| (minStack.peek(0)>i) ) {
                minStack.push(0, i);
            }
        }
    }

    int pop() throws Exception {
        int popVal=0;
        if(!s.ifEmpty(0)){
            popVal= s.pop(0);
            if(popVal==minStack.peek(0)){
                minStack.pop(0);
            }
        }
        return popVal ;
    }

    public static void main(String[] args) throws Exception {
        MinimumElement m= new MinimumElement(new SingleArraySingleStack(5),new SingleArraySingleStack(5));
        m.push(10);
        m.push(11);
        m.push(12);
        m.push(13);
        m.push(1);
        System.out.println(m.minElement());
        System.out.println("pop :- "+m.pop());
        System.out.println(m.minElement());
    }
}
