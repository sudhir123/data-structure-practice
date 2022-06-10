package com.prac.home.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * any number is sum of last to numbers. first number is 0 and next is 1 and for 0 and 1 -> its 1.
 * rest any number greater than 1 is the sum of last two numbers
 */
public class NthFibonacci {
    // this is O(2^n) more dangerous than n^2 and space O(n)
    /*public static int getNthFib(int n) {
        if (n==1 ) return 0;
        if (n==2) return 1;
        return getNthFib(n-1)+ getNthFib(n-2);
    }*/

    // # solution2 with memory O(n) time and space
    /*public static int getNthFib(int n) {
        Map<Integer, Integer> memoryMap = new HashMap<>();
        memoryMap.put(1,0);
        memoryMap.put(2,1);
        return fibonacciWithMemory(n, memoryMap);
    }
    static int fibonacciWithMemory(int n, Map<Integer, Integer> memoryMap){
        if (memoryMap.get(n)!=null) {
            return memoryMap.get(n);
        }else {
            memoryMap.put(n, (fibonacciWithMemory(n-1, memoryMap)+ fibonacciWithMemory(n-2, memoryMap)));
        }
        return memoryMap.get(n);
    }*/

    // solution3 best O(n) and o(1)
    public static int getNthFib(int n) {
        int thirdLast=0, secondLast=1;
        if (n==1) return thirdLast;
        if (n==2) return secondLast;
        for (int i=3; i<=n ; i++){
            int temp =secondLast;
            secondLast=secondLast+thirdLast;
            thirdLast=temp;
        }
        return secondLast;
    }

    public static void main(String[] args) {
        System.out.println(getNthFib(7));
    }
}
























