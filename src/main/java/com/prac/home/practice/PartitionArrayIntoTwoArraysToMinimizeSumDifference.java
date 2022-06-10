package com.prac.home.practice;

import java.util.Arrays;

/**
 * You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.
 *
 * Return the minimum possible absolute difference.
 */
public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public static void main(String[] args) {
        PartitionArrayIntoTwoArraysToMinimizeSumDifference p = new PartitionArrayIntoTwoArraysToMinimizeSumDifference();
        System.out.println(p.minimumDifference(new int[]{2,-1,0,4,-2,-9}));
    }
    public int minimumDifference(int[] nums) {
        int sum=0;
        Arrays.sort(nums);

        for (int i=0; i <nums.length; i++){
            sum+=nums[i];
        }

        int[][] matrix = new int[nums.length+1][(sum/2)+1];
        for (int row=1; row< matrix.length; row++){
            int currentNum = nums[row-1];
            for (int col=1; col< matrix[0].length; col++){
                if (currentNum > col){
                    matrix[row][col]= matrix[row-1][col];
                }else {
                    matrix[row][col]= Math.max(currentNum, Math.max(matrix[row-1][col],matrix[row-1][col-currentNum]+currentNum));
                }
            }
        }
        int maxMatrixSum= matrix[matrix.length-1][matrix[0].length-1];
        int remainingSum = sum - maxMatrixSum;
        return Math.abs(remainingSum-maxMatrixSum);
    }
}
