package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNUmberSum {
    public static void main(String[] args) {
        System.out.println(threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6},0));
    }
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result =  new ArrayList<>();
        for (int i=0; i< array.length;i++){
            int target= targetSum-array[i];
            findTwoNumber(array,i, target,array[i],result);
        }
        return result;
    }

    static List<Integer[]>  findTwoNumber(int[]array,int idx, int target, int firstNum, List<Integer[]>result){
        int left=idx+1;
        int right = array.length-1;
        while (left<right){
            int current = array[left]+ array[right];
            if (current==target){
                result.add(new Integer[]{firstNum, array[left],array[right] });
                left++; right--;
            }else if (current<target){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }
}
