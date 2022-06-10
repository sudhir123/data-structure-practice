package com.prac.home.geeks4geeks;

import java.util.Arrays;

public class LongestIncreasingSubSeq {
    public static void main(String[] args) {
        System.out.println(longestSubsequence(11, new int[]{5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35}));
    }
    // two ways only length. in nlogn
    static int longestSubsequence(int size, int a[]){
        int[] indices = new int[size+1];
        //Arrays.fill(indices, -1);
        int length=1;
        int[] seq = new int[size+1];
        for (int i=1; i< a.length+1; i++){
            int num = a[i-1];
            int newLength= bst(a, indices, 1, length, num);
            indices[newLength]= i-1;
            length= Math.max(length, newLength);
        }
        return length;
    }

    static int bst(int[] array, int[] indices , int start, int end, int num){
        if (start> end) return start;
        int midIdx = (start+end)/2;
        if (array[indices[midIdx]]< num){
            start= midIdx+1;
        }else {
            end= midIdx-1;
        }
        return bst(array, indices, start, end, num);
    }
}
