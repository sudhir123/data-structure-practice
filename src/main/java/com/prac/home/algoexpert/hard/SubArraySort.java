package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #Array
 * given an input array, in which if we sord the sub array , the whole array would be sorted. Return the start and end  indeces of sub array
 */
public class SubArraySort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subarraySort(new int[]{1,2})));
    }


    public static int[] subarraySort(int[] array) {
        int minOutOfOder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;
        for (int i=0 ; i <array.length; i ++){
            int num = array[i];
            if (isOutOfOrder(i, num, array)){
                minOutOfOder= Integer.min(minOutOfOder,num);
                maxOutOfOrder= Integer.max(maxOutOfOrder, num);
            }
        }
        if (minOutOfOder==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        int subArraySmallIdx=0;
        while (minOutOfOder > array[subArraySmallIdx]){
            subArraySmallIdx++;
        }

        int subArrayLargeIdx= array.length-1;
        while (maxOutOfOrder < array[subArrayLargeIdx]){
            subArrayLargeIdx--;
        }
        return new int[]{subArraySmallIdx, subArrayLargeIdx};
    }

    static boolean isOutOfOrder(int idx, int number , int[] array){
        if (idx==0){
            return number > array[idx+1];
        }else if (idx== array.length-1){
            return number < array[idx-1];
        }else {
            return array[idx-1]> number || number> array[idx+1];
        }
    }

}



























