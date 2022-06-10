package com.prac.home.practice;

import java.util.*;

public class ThreeNumberSum {
    public static void main(String[] args) {

    }
    // best ways , which will maintain the order also
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        for (int i =0; i < array.length; i++){
            int currentElement = array[i];
            int left= i+1;
            int right = array.length-1;
            while (left< right){
                int currentSum = currentElement+ array[left]+array[right];

                if (currentSum== targetSum){
                    result.add(new Integer[]{currentElement, array[left],array[right]});
                    left++;
                    right--;
                } else if ( currentSum < targetSum) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }


    //#myway
    // not so good .. as order is not maintained
    // time complexity n^2 but space is O(n)
    /*public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        // Write your code here.
        List<Integer[]> result = new ArrayList<>();
        for (int i=0; i < array.length; i++){
            int target = targetSum- array[i];
            twoNumberSum(array, i, target, result);
        }
        return result;
    }*/
    static void twoNumberSum(int[]array, int start, int target, List<Integer[]> result){
        Map<Integer, Integer> map= new HashMap<>();
        for (int i=start+1; i< array.length; i++){
            if (map.containsKey(array[i])){
                result.add(new Integer[]{target, map.get(array[i]), array[i]});
            }else {
                map.put(target - array[i], array[i]);
            }
        }
    }
}
