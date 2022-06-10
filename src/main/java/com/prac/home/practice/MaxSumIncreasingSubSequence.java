package com.prac.home.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * #Array
 * function takes an array and returns greatest sum that can be generated from strictly increasing sub sequence, as well as array of numbers.
 */
public class MaxSumIncreasingSubSequence {
    // any such problem apply dynamic programming. solve small sums and generate big one. For saving smaller sum , we need another array
    // of same length. time ->O(n^2)
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] sum= new int[array.length];
        Arrays.fill(sum, Integer.MIN_VALUE);
        int[] seq= new int[array.length];
        Arrays.fill(seq, Integer.MIN_VALUE);
        List<List<Integer>> result =new ArrayList<>();
        sum[0]=array[0];
        for (int index=1; index< array.length; index++){
            for (int i=0; i< index ; i++){
                if (array[i]< array[index]){
                    sum[index]= Math.max(sum[index],sum[i]+array[index] );
                    seq[index]= i;
                }
            }
        }

        int maxSum =Integer.MIN_VALUE; int maxSumIdx=-1;
        for (int i=0; i < sum.length; i++){
            if (maxSum< sum[i]){
                maxSum= sum[i];
                maxSumIdx= i;
            }
        }

        result.add(Arrays.asList(maxSum));
        List<Integer> l= new ArrayList<>();
        while (maxSumIdx!=Integer.MIN_VALUE){
            l.add(array[maxSumIdx]);
            maxSumIdx= seq[maxSumIdx];
        }Collections.reverse(l);
        result.add(l);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSumIncreasingSubsequence(new int[]{10, 70, 20, 30, 50, 11, 30}));//
    }
}





































