package com.prac.home.practice.algoexpert;

import java.util.Arrays;

public class TwoNumberSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10)));
    }
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int left=0;
        int right = array.length-1;
        while (left<right){
            int current = array[left]+ array[right];
            if (current==targetSum){
                return new int[]{array[left], array[right]};
            }else if (current<targetSum){
                left++;
            }else {
                right--;
            }
        }
        return new int[0];
    }
}
