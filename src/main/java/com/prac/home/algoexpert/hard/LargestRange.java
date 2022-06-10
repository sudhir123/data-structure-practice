package com.prac.home.algoexpert.hard;

import java.util.*;

/**
 * #Array
 * function to take input array and returns array of length 2 , representing the largest range of integers
 */
public class LargestRange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(largestRange(new int[]{1})));
    }
    public static int[] largestRange(int[] array) {
        if (array.length<2) return new int[]{array[0], array[0]};
        Set<Integer> set= new HashSet<>();
        for (int i =0; i < array.length; i++){
            set.add(array[i]);
        }
        List<int[]> rangeList= new ArrayList<>();
        for (int i =0; i < array.length; i++){
            int num = array[i];
            if(!inRange(num , rangeList)){
                int lowerRange= findLowerRangeNumber(num, set);
                int higherRange= findHigherRangeNumber(num, set);
                rangeList.add(new int[]{lowerRange, higherRange});
            }
        }
        int[] maximumRange= new int[2];
        for (int[] range: rangeList
        ) {
            int maximumRangePossible= maximumRange[1] -maximumRange[0];
            int currentRange= range[1]-range[0];
            if (maximumRangePossible < currentRange){
                maximumRange= range;
            }
        }
        return maximumRange;
    }

    static boolean inRange(int num, List<int[]> rangeList){
        for (int[] range: rangeList
             ) {
            if (num>=range[0] && num <=range[1]) return true;
        }
        return false;
    }
    static int findLowerRangeNumber(int num, Set<Integer>set){
        int lowerRange= num;
        while (set.contains(num)){
            lowerRange=num;
            num--;
        }
        return lowerRange;
    }
    static int findHigherRangeNumber(int num, Set<Integer>set){
        int higherRange= num;
        while (set.contains(num)){
            higherRange=num;
            num++;
        }
        return higherRange;
    }
}
