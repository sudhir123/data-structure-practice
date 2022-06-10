package com.prac.home.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubSeq {
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35}));
    }
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        int[] indicesResult = new int[array.length+1];
        Arrays.fill(indicesResult, -1);
        int[] seq= new int[array.length+1];
        int endIdx=0;
        for (int i=1; i < array.length; i++){
            int newEndIdx= bst(array, indicesResult, 1, endIdx, array[i]);
            indicesResult[newEndIdx]= i;
            endIdx= Math.max(endIdx, newEndIdx);
        }
        return new ArrayList<>();
    }

    static int bst(int[] array, int[] result , int start, int end, int num){
        if (start> end) return start;
        int midIdx = (start+end)/2;
        if (array[result[midIdx]]>num  ){
           return bst(array, result, start,midIdx-1, num);
        }else {
           return bst(array, result,midIdx+1, end, num);
        }
    }
}
