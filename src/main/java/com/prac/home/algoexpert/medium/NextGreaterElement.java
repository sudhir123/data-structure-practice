package com.prac.home.algoexpert.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * consider given array is a circular array, and we need to replace each idx with next greter element. if not possible add -1.
 * given its a circular loop. we may think of run the loop twice in such cases. but as move to next element ... our index will be out
 * so to manage that we will use mod operator
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] array) {
        int[] a = new int[array.length];
        Arrays.fill(a, -1);
        Stack<Integer> stack= new Stack<>();
        for (int i =0; i < array.length*2; i ++){
            int circularIdx= i% array.length;
            while (stack.size()>0 && array[stack.peek()] < array[circularIdx]){
                a[stack.pop()]= array[circularIdx];
            }
            stack.push(circularIdx);
        }
        return a;
    }

    public static void main(String[] args) {
        NextGreaterElement n = new NextGreaterElement();
        System.out.println(Arrays.toString(n.nextGreaterElement(new int[]{0, 1, 2, 3, 4})));
    }
}
