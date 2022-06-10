package com.prac.home.practice;
/**
 * Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum
 * and return its sum.
 */
public class KadaneAlgorithm {
    public static void main(String[] args) {
        KadaneAlgorithm k = new KadaneAlgorithm();
        //System.out.println(k.maxSubArraySum(new int[]{1,2,3,-2,5},5 ));
        System.out.println(k.maxSubArraySum(new int[]{-2, 1, -3 ,4, -1, 2 ,1, -5 ,4},9 ));
    }
    long maxSubArraySum(int arr[], int n) {
        int runningSum=arr[0];
        int maxSum= arr[0];
        for (int i=1; i<arr.length; i++){
            //runningSum= Math.max()
        }

        return -1;
    }
}
