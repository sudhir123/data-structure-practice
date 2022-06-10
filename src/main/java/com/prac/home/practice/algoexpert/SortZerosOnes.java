package com.prac.home.practice.algoexpert;

import java.util.Arrays;

public class SortZerosOnes {
    public static void main(String[] args) {
        SortZerosOnes s = new SortZerosOnes();
        s.sortColors(new int[]{1,2,2,0,1,2});
    }
    // 0,1,2 , using only swap and in linear time complexity with one pass.
    public void sortColors(int[] nums) {
        int firstIdx=0, secondIdx=0, thirdIdx = nums.length-1;
        while (secondIdx<=thirdIdx ){

            if (nums[secondIdx]==0 ){
                swap(nums, firstIdx, secondIdx);
                firstIdx++; secondIdx++;
            }else if (nums[secondIdx]==1 ){
                secondIdx++;
            }else {
                swap(nums, thirdIdx, secondIdx);
                thirdIdx--;
            }

        }
        System.out.println(Arrays.toString(nums));
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}
