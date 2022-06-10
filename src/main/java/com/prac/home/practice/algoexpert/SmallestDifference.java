package com.prac.home.practice.algoexpert;

import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17})));
    }
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int[] smallest= new int[]{};
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int oneIdx= 0;
        int twoIdx =0;
        int smallestDiff = Integer.MAX_VALUE;
        while (oneIdx< arrayOne.length && twoIdx< arrayTwo.length){
            if (smallestDiff> Math.abs(arrayOne[oneIdx]-arrayTwo[twoIdx])){
                smallestDiff= Math.min(smallestDiff, Math.abs(arrayOne[oneIdx]-arrayTwo[twoIdx]));
                smallest= new int[]{arrayOne[oneIdx], arrayTwo[twoIdx]};
            }
            if (arrayOne[oneIdx] <arrayTwo[twoIdx] ){
                oneIdx++;
            }
            else {
                twoIdx++;
            }
        }
        return smallest;
    }
}
