package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class SortStack {
    public static void main(String[] args) {
        SortStack s = new SortStack();
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(-5);stack.add(2);stack.add(-2);stack.add(4);stack.add(3);stack.add(1);
        System.out.println(s.sortStack(stack));
    }
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {

        for (int i=stack.size()-1; i >=0 ; i--){
            int last= popAndCompare(stack, pop(stack));
            append(stack, last);
        }
        return stack;
    }

    public Integer popAndCompare(ArrayList<Integer> stack, int lastElement) {
        if (stack.isEmpty()) return lastElement;

        int returnedValue= popAndCompare(stack, pop(stack));
        if (returnedValue> lastElement){
            append(stack, lastElement);
            return returnedValue;
        }else {
            append(stack, returnedValue);
            return lastElement;
        }
    }

    public void append(List<Integer> stack, Integer value){
        stack.add(value);
    }

    public Integer pop(List<Integer> stack){
        return stack.remove(stack.size()-1);
    }
}
