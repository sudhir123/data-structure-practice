package com.prac.home.practice.algoexpert;

import java.util.*;

public class FourSumProblem {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6},10 )));
        //System.out.println(threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0));
        System.out.println(fourNumberSum(new int[]{7, 6, 4, -1, 1, 2},16 ));
    }

    // lets do it with the approach save one number and calculate rest with three number sum problem.
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        for (int i=0; i < array.length;i++){
            findThreeNUmberSum(array, targetSum-array[i], i, result);
        }
        return result;
    }

    static void findThreeNUmberSum(int[]array, int target, int fistIdx, List<Integer[]> result){
        for (int secondIdx=fistIdx+1; secondIdx< array.length; secondIdx++){
            int leftIdx =secondIdx+1;
            int rightIdx = array.length-1;
            while (leftIdx< rightIdx){
                int sum = array[secondIdx] + array[leftIdx]+ array[rightIdx];
                if (sum==target){
                    Integer[] arr= new Integer[]{array[fistIdx], array[secondIdx], array[leftIdx], array[rightIdx]};
                    result.add(arr);
                    leftIdx++;
                }else if (sum< target){
                    leftIdx++;
                }else {
                    rightIdx--;
                }
            }
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        for (int i=0; i< array.length; i++){
            int num =array[i];
            int leftIdx =i+1;
            int rightIdx = array.length-1;
            while (leftIdx< rightIdx){
                int sum = num + array[leftIdx] + array[rightIdx];
                if (targetSum == sum) {
                    result.add( new Integer[]{num, array[leftIdx], array[rightIdx]});
                    leftIdx++;
                    rightIdx--;
                }else if (sum < targetSum){
                    leftIdx++;
                }else {
                    rightIdx--;
                }
            }
        }
        return result;
    }
    public static Integer[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Integer> pairs =new HashMap<>();
        for (int i=0; i < array.length; i++){
            int num = array[i];
            if (pairs.containsKey(targetSum-num)){
                return new Integer[]{num, targetSum-num};
            }else {
                pairs.put(num, targetSum-num);
            }
        }
        return new Integer[0];
    }
}
