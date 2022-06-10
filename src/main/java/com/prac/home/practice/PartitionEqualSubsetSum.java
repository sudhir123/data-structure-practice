package com.prac.home.practice;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartition(new int[]{23,13,11,7,6,5,5}));
        //System.out.println(p.canPartition(new int[]{1, 5, 3}));

    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        for (int i=0; i <nums.length; i++){
            sum+=nums[i];
        }
        if (sum%2 !=0) return false;

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
        return matrix[matrix.length-1][matrix[0].length-1]==sum/2;
    }
}
