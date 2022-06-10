package com.prac.home.datastructures.dynamicprog;

/**
 * recursion  is good when small number ...but in case of 50th ... its is taking hell lot of time ...that is the problem
 * so dynamic prog
 */

public class FebonacciSeries {

    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(50));
    }

    public static int fib(int n){
        if(n<=2) return 1;

        return fib(n-1) + fib(n-2);
    }
}
