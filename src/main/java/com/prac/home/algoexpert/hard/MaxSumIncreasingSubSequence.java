package com.prac.home.algoexpert.hard;

import java.util.*;

/**
 * #Array
 * function takes an array and returns greatest sum that can be generated from strictly increasing sub sequence, as well as array of numbers.
 */
public class MaxSumIncreasingSubSequence {
    // any such problem apply dynamic programming. solve small sums and generate big one. For saving smaller sum , we need another array
    // of same length. time ->O(n^2)
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] result= array.clone();
        int[] sequence= new int[array.length];
        Arrays.fill(sequence, Integer.MIN_VALUE);
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i=0; i <array.length; i++){
            List<Integer> temp = new ArrayList<>();
            list.add(temp);
        }

        for (int i=0; i < array.length; i++){

            if (i==0){
                result[i]= array[i];
            }else {

                populateResult(array, result, i, sequence);

            }

        }
        int largestValue =Integer.MIN_VALUE, index=-1;
        for (int i =0; i < result.length; i++){
            if (result[i]> largestValue){
                largestValue= result[i];
                index= i;
            }
        }
        List<Integer> seqList= new ArrayList<>();
        while (index!=Integer.MIN_VALUE){
            seqList.add(array[index]);
            index= sequence[index];
        }

        Collections.reverse(seqList);
        ArrayList<List<Integer>> a= new ArrayList<List<Integer>>();
        a.add(Arrays.asList(largestValue)); // Example max sum
        a.add(seqList); // Example max sequence
        return a;
    }

    static void populateResult(int[] array, int[] result, int currentIdx, int[] sequence ){
        int i=0;
        while (i< currentIdx){
            if (array[currentIdx]> array[i]){
                if (result[currentIdx] < array[currentIdx]+ result[i]){
                    sequence[currentIdx]= i;
                }
                result[currentIdx]= Math.max(result[currentIdx], array[currentIdx]+ result[i]);
            }else {
                result[currentIdx]= Math.max(array[currentIdx], result[currentIdx]);
            }
            i++;
        }
    }
    public static void main(String[] args) {
        System.out.println(maxSumIncreasingSubsequence(new int[]{-1, 1}));//10, 70, 20, 30, 50, 11, 30
    }
}





































