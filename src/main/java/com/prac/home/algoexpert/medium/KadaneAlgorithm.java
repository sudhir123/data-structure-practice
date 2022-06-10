package com.prac.home.algoexpert.medium;
/**
 * given an array find the max sum possible from adjacent numbers. earlier we have generated from non adjacent.
 * 13-NOV-2021
 */
public class KadaneAlgorithm {

    //O(n) time and O(1) space
    public static int kadanesAlgorithm(int[] a) {
        int maxSumSoFar =a[0];
        int intrimMax= a[0];
        for (int i=1; i< a.length; i++){
            intrimMax= Math.max(a[i], intrimMax+a[i]);
            maxSumSoFar= Math.max(maxSumSoFar, intrimMax);
        }
        return maxSumSoFar;
    }
    public static void main(String[] args) {// 3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4
        System.out.println(kadanesAlgorithm(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
