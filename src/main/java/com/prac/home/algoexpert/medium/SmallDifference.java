package com.prac.home.algoexpert.medium;

import java.util.Arrays;

public class SmallDifference {

    static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int potentialDiff= Integer.MAX_VALUE;
        int[] pair = new int[2];
        for( int oneIdx =0, twoIdx=0;oneIdx < arrayOne.length && twoIdx< arrayTwo.length;) {
            if (potentialDiff > Math.abs(arrayOne[oneIdx] - arrayTwo[twoIdx])) {
                potentialDiff = Math.abs(arrayOne[oneIdx] - arrayTwo[twoIdx]);
                pair[0]= arrayOne[oneIdx];
                pair[1]= arrayTwo[twoIdx];
            }
            if (arrayOne[oneIdx] < arrayTwo[twoIdx]) {
                oneIdx++;
            } else {
                twoIdx++;
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestDifference(new int[]{-1,5,10,20,28,3}, new int[]{26,134, 135, 15,17 })));
    }
}
