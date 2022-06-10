package com.prac.home.practice.algoexpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12,6 })));
    }
    public static int[] largestRange(int[] array) {
        int[] result =new int[0];
        int longestRange=0;
        Map<Integer, Boolean> map=new HashMap<>();
        for (int i=0; i< array.length; i++){
            map.put(array[i], false);
        }
        for (int i=0; i< array.length; i++) {
            int num = array[i];
            while (map.get(num) == false) {
                int left = num - 1;
                int right = num + 1;
                int currentLength=1;
                while (map.containsKey(left) && map.get(left) == false) {
                    map.put(left, true);
                    left = left - 1;
                    currentLength++;
                }
                while (map.containsKey(right) && map.get(right) == false) {
                    map.put(right, true);
                    right = right + 1;
                    currentLength++;
                }
                map.put(num, true);
                if (longestRange< currentLength){
                    longestRange= currentLength;
                    result= new int[]{left+1, right-1};
                }
            }
        }
        return result;
    }
}
