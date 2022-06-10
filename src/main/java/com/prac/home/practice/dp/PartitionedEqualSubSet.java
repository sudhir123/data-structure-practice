package com.prac.home.practice.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionedEqualSubSet {
    public static void main(String[] args) {
        PartitionedEqualSubSet p = new PartitionedEqualSubSet();
        System.out.println(p.canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
    }

    // equal sum means exactly half
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int expectedSum = sum / 2;
        Map<Integer, Boolean> map = new HashMap<>();
        return canPartition(nums, 0, expectedSum, map);
    }

    public boolean canPartition(int[] arr, int currentIdx, int expectedSum, Map<Integer, Boolean> map) {
        if (currentIdx >= arr.length) return false;
        if (map.containsKey(currentIdx)){
            return map.get(currentIdx);
        }
        if (expectedSum == 0) return true;
        if (canPartition(arr, currentIdx + 1, expectedSum - arr[currentIdx], map)
                || canPartition(arr, currentIdx + 1, expectedSum, map)
        ) {
            map.put(currentIdx, true);
            return map.get(currentIdx);
        }
        return false;
    }

    /*public boolean canPartition(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;

        int[][] matrix = new int[nums.length + 1][(sum / 2) + 1];
        for (int row = 1; row < matrix.length; row++) {
            int currentNum = nums[row - 1];
            for (int col = 1; col < matrix[0].length; col++) {
                if (currentNum > col) {
                    matrix[row][col] = matrix[row - 1][col];
                } else {
                    matrix[row][col] = Math.max(currentNum, Math.max(matrix[row - 1][col], matrix[row - 1][col - currentNum] + currentNum));
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1] == sum / 2;
    }*/
}
