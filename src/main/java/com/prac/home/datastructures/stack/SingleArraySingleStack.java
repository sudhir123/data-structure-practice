package com.prac.home.datastructures.stack;

import java.util.Arrays;
import java.util.concurrent.Executors;

public class SingleArraySingleStack {
    Integer[] arr; int[] offset; int stackSize=5;
    SingleArraySingleStack(int numberOfStacks){
        arr= new Integer[stackSize];
        offset= new int[numberOfStacks];
    }
    void push(int stackNumber, int i) throws Exception {
        if(ifFull(stackNumber)) throw new Exception("Stack # "+stackNumber+" Is Full");
        offset[stackNumber]++;
        arr[topOffset(stackNumber)]=i;

    }
    boolean ifFull(int stackNumber){ // 0 in case of single
        return offset[stackNumber]==stackSize;
    }
    boolean ifEmpty(int stackNumber){
        return offset[stackNumber]==0;
    }
    int topOffset(int stackNumber){
        return offset[stackNumber]-1;
    }
    public Integer pop(int stackNumber) throws Exception {
        if(ifEmpty(stackNumber)) throw new Exception("STack #"+ stackNumber+" Is Empty");
        Integer topIndex=  topOffset(stackNumber);
        int value = arr[topIndex];
        arr[topIndex]=null;
        offset[stackNumber]--;
        return value;
    }
    public int peek(int stackNumber) throws Exception {
        if(ifEmpty(stackNumber)) throw new Exception("STack Is Empty");
        return arr[topOffset(stackNumber)];
    }

    public static void main(String[] args) throws Exception {
        SingleArraySingleStack s= new SingleArraySingleStack(1);
        s.push(0,1);
        s.push(0,2);
        s.push(0,3);
        s.push(0,4);
        s.push(0,5);
        System.out.println(s.pop(0));
        System.out.println(s.pop(0));
        System.out.println(s.pop(0));
        System.out.println(s.pop(0));
        System.out.println(s.pop(0));

        Arrays.stream(s.arr).forEach(System.out::println);

        s.push(0,5);
        System.out.println(s.pop(0));

    }
}
