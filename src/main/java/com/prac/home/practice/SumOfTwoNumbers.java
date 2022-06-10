package com.prac.home.practice;

import java.util.*;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        SumOfTwoNumbers s= new SumOfTwoNumbers();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2,7,11,15}, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map= new HashMap<>();
        for (int idx=0; idx< numbers.length; idx++){
            if (map.containsKey(numbers[idx])){
                return new int[]{map.get(numbers[idx])+1, idx+1};
            }else {
                map.put(target-numbers[idx], idx);
            }
        }
        return new int[]{-1,-1};
    }
}
