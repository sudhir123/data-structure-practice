package com.prac.home.practice.algoexpert;

public class KadaneAlgo {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(kadanesAlgorithm(arr));
    }
    public static int kadanesAlgorithm(int[] array) {
        int maxResult =array[0];
        int maxSoFar= array[0];
        for (int i=1; i< array.length; i++){
            maxSoFar= Math.max(array[i], maxSoFar+ array[i]);
            maxResult= Math.max(maxResult, maxSoFar);
        }
        return maxResult;
    }
}
