package com.prac.home.algoexpert.medium;
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
        // there is always to generate a formula out of calculation. Sum of previous so far calculated.
        if (array.length==0) return 0;
        int[] sumArray = new int[array.length];
        for (int i =0; i <array.length; i++){
            if (i==0 )  sumArray[i]= array[i];
            else if (i ==1) sumArray[i]= Math.max(sumArray[i-1], array[i]);
            else
            sumArray[i]= Math.max(sumArray[i-1], (sumArray[i-2]+array[i]));
        }
        return sumArray[sumArray.length-1];
    }

    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{4, 3, 5, 200, 5, 3}));
    }
}
