package com.prac.home.algoexpert.hard;

import java.util.Arrays;

/**
 * funtion takes in sorted array and using binary search find the range of indecies in which the target numbe ris contained.
 *
 */
public class SearchForRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchForRange(new int[]{0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73}, 45)));
    }
    public static int[] searchForRange(int[] array, int target) {
        // Write your code here.
        int[] result = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        searchRange(array, target, 0, array.length - 1, result);
        if (result[0] == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return result;
    }

    static void searchRange (int[] array, int target, int start, int end, int[] result){
        if (start> end) return;
        int midIdx= (start+end)/2;
        int potentialSearch = array[midIdx];

        if (target==potentialSearch){
            result[0]=Math.min(result[0],midIdx);
            result[1]=  Math.max(result[1],midIdx);
            searchRange(array, target, start, midIdx-1, result);
            searchRange(array, target, midIdx+1, end, result);
        }else if (target<potentialSearch){
            searchRange(array, target, start, midIdx-1, result);
        }else {
            searchRange(array, target, midIdx+1, end, result);
        }
    }
}
