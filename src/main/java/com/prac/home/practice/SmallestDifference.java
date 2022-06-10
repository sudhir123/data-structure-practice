package com.prac.home.practice;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * two integer array been given and we need to find the two numbers ,one from each array, with smallest difference. Return array.
 */
public class SmallestDifference {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17})));
    }
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[2];
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int fistIdx=0; int secondIdx=0;
        int minDiff= Integer.MAX_VALUE;
        while (fistIdx<arrayOne.length && secondIdx< arrayTwo.length){
            if (minDiff > Math.abs( arrayOne[fistIdx] - arrayTwo[secondIdx])){
                minDiff= Math.abs( arrayOne[fistIdx] - arrayTwo[secondIdx]);
                result[0]= arrayOne[fistIdx]; result[1]= arrayTwo[secondIdx];
            }
            if (arrayOne[fistIdx] >arrayTwo[secondIdx]){
                secondIdx++;
            }else {
                fistIdx++;
            }

        }
        return result;
    }
}
