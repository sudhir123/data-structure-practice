package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * function that takes array/ list of integers as input representing a stack. Sort stack recursively and resturn it.
 * Don't create new one.stack will have push -> element at end of list. Pop -> pop element from end of list. peek will show
 * element. No other operation. YOnly work with last element. Accesssing all other elements is not allowed.
 */
public class SortStack {
    // 1) recursive 2) only push and pop needs to be used
    public List<Integer> sortStack(List<Integer> stack) {
        if (stack.isEmpty()) return new ArrayList<>();
        for(int i =0; i <stack.size(); i++) {
            Integer lastInt = popAndCompare(stack, pop(stack));
            push(stack, lastInt);
        }
        return stack;
    }

    Integer popAndCompare(List<Integer> list, Integer lastElement){
        if (list.isEmpty()) return lastElement;

        int elementRet= popAndCompare(list, pop(list));

        if (elementRet > lastElement ){
            push(list,lastElement );
            return elementRet;
        }else {
            push(list,elementRet );
            return lastElement;
        }
    }

    void push(List<Integer> list, Integer element){
        list.add(element);
    }

    Integer pop(List<Integer> list){
        return list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        SortStack s= new SortStack();
        List<Integer> lst= Arrays.asList(-5,2,-2,4,3 ,1);
        List<Integer>  stack= new ArrayList<>(lst);
        System.out.println(s.sortStack(stack));
    }
}
