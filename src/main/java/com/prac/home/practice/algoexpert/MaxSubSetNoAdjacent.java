package com.prac.home.practice.algoexpert;

public class MaxSubSetNoAdjacent {
    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{4, 3, 5, 200, 5, 3}));
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length==0) return 0;
        if (array.length==1) return array[1];
        if (array.length==2) return Math.max(array[0], array[1]);
        int[] result = new int[array.length];
        result[0]=array[0];
        result[1]=Math.max(array[0],array[1]);
        for (int i=2; i< array.length; i++){
            result[i]= Math.max(result[i-1], array[i]+ result[i-2]);
        }
        return result[result.length-1];
    }
}
