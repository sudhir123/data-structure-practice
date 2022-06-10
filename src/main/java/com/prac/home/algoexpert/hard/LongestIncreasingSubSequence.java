package com.prac.home.algoexpert.hard;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35}));
    }
    public static ArrayList<Integer> longestIncreasingSubsequence(int[] array) {
        //return method1( array);
        return method2(array);
    }
    // better O(nlogn ) implementation. when logn comes in picture , u can think of binary search.
    public static ArrayList<Integer> method2(int[] array) {
        //  we have taken length +1 because in bst we take middle elemnt and
        // middle element of size 1 is 0. but middle of size 2 is 1 ..so will start from 1.
        // it will also store indexes but in bst order. Our target is to find the element gretest al all
        // element present at idxes in bst bbut smaller than current elemnt in array
        int[] indices = new int[array.length];
        int[] sequence = new int[array.length];
        Arrays.fill(indices, -1);
        int length =0;
        for (int i=0; i < array.length; i++){
            int num = array[i];
            int newLength = binarySearch(1,length, indices, array, num );
            // new length is next index number when we add another greter element. so its totally perfect to have it as new length.
            sequence[i]= indices[newLength-1];
            indices[newLength]= i;
            length= Math.max(length, newLength);
        }
        ArrayList<Integer> result = buildSeq(array, sequence, indices[length]);
        Collections.reverse(result);
        return result;
    }

    static ArrayList<Integer> buildSeq(int[] array, int[] seq, int currentIdx){
        ArrayList<Integer> result = new ArrayList<>();
        while (currentIdx!=-1){
            result.add(array[currentIdx]);
            currentIdx= seq[currentIdx];
        }
           return result;
    }

    static int  binarySearch(int start, int end, int[] indices, int[] array, int num){
        if (start>end) return start;
        int mid = (start + end)/2;
        if (array[indices[mid]] < num){
            start= mid+1;
        }else {
            end= mid-1;
        }
        return binarySearch(start, end, indices, array, num);
    }

    // O(n^2 ) implementation
    public static ArrayList<Integer> method1(int[] array) {
        int[] result = new int[array.length];
        int[]  sequence = new int[array.length];
        ArrayList<Integer> resultFinal = new ArrayList<>();
        Arrays.fill(sequence, -1);
        int maxCount=Integer.MIN_VALUE;
        int maxIdx =-1;
        for (int i=0; i< array.length; i++){

            for (int j=0; j<i; j++){
                if (array[j] < array[i] && result[i] < result[j]+1){
                    result[i]= result[j]+1;
                    sequence[i]=j;
                }
            }
        }
        for (int i=0; i < result.length; i++){
            if (maxCount< result[i]){
                maxCount= result[i];
                maxIdx=i;
            }
        }

        int i=maxIdx;
        resultFinal.add(array[i]);
        while (sequence[i]!=-1){
            resultFinal.add(array[sequence[i]]);
            i= sequence[i];
        }
        Collections.reverse(resultFinal);
        return resultFinal;
    }
   /* public static List<Integer> longestIncreasingSubsequence(int[] array) {
        List<Integer> result = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();


        for (int i=0; i < array.length; i++){
            result.add(1);
            sequence.add(-1);
        }
        for (int i=0; i< array.length; i++){

            for (int j=0; j<i; j++){
                if (array[j] < array[i] && result.get(i) < result.get(j)+1){
                    result.set(i , result.get(j)+1);
                    sequence.set(i, j);
                }
            }
        }

        return result;
    }*/
}
