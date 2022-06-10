package com.prac.home.practice;

import java.util.Arrays;

/**
 * function takes array and returns max sum of non adjacent elements in an array.
 * 12-NOV-2021
 */
public class MaxSubSetSumNoAdjacent {
    //use dynamic prog --> save smaller sums and get to big one.
    // at index 0 maximum sum we could generate is value at 0 index
    // at index 1 --> max sum would be either value at 0 and value 1 ... because they adjacent, we cannot add them.
    // at index 2 -> we cannot add this value to value at 1 ... but we can do that with value at 0. only thing meeds to be
    // checked is at this index it should be maxumm sum so far. so waht it could the value at 1 or value at 0 + value at 2.
    // than value at three again would vlue at 3 _ value at 1 or maximum sum we saved at value at 2.
    public static int maxSubsetSumNoAdjacent(int[] array) {
        System.out.println(Arrays.toString(array));
        int[] result = new int[array.length];
        // base work
        result[0]= array[0];
        result[1]= array[1];

        for (int i=2; i < array.length; i ++){
            result[i]= Math.max(result[i-1], result[i-2]+array[i]);
        }
        System.out.println(Arrays.toString(result));
        return result[result.length-1];
    }

    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{75, 105, 120, 75, 90, 135}));
    }
}
