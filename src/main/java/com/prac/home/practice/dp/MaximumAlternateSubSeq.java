package com.prac.home.practice.dp;

import java.util.*;

public class MaximumAlternateSubSeq {
    public static void main(String[] args) {
        //System.out.println(longestIncreasingSubSeq(new int[]{4,10,4,3,8,9}));
        System.out.println(maxAlternatingSum(new int[]{5,6,7,8}));
    }
    static long maxAlternatingSum(int[] nums) {
        int sumEven=0;
        int sumOdd=0;
        for (int i=nums.length-1; i>=0; i--){
            int tempEven = Math.max(sumOdd + nums[i], sumEven);
            int tempOdd = Math.max(sumEven - nums[i], sumOdd);
            sumEven= tempEven;
            sumOdd= tempOdd;
        }
        return sumEven;
    }

    static int maxAlternateSum(int[] array,  int currentIdx, boolean bol){
        if (currentIdx== array.length-1) return 0;
        int total= bol==true? array[currentIdx]:-1*array[currentIdx];
        return  Math.max(
                total+maxAlternateSum(array,  currentIdx+1,!bol),
                maxAlternateSum(array, currentIdx+1,bol));
    }
    static int longestIncreasingSubSeq(int[] array){
        return sequence(array, 0);
    }

    static int sequence(int[] array, int n){
        if (n==array.length-1) return 1;
        int length=0;
        if (array[n] < array[n+1]){
            length+= Math.max(1,1+sequence(array, n+1));
        }else {
            length+=sequence(array, n+1);
        }
        return length;
    }
}
