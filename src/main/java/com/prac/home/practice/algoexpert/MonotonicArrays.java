package com.prac.home.practice.algoexpert;

public class MonotonicArrays {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 0}));
    }
    public static boolean isMonotonic(int[] array) {
        boolean nonIncreasing=true; boolean nonDecreasing=true;
        for (int i=1; i< array.length; i++) {
            if (array[i]<array[i-1]){
                nonDecreasing=false;
            }
            if (array[i] > array[i-1]){
                nonIncreasing=false;
            }
        }
        return nonIncreasing || nonDecreasing;
    }
}
