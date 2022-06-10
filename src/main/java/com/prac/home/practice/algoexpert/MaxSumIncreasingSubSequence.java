package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * like increasing sub seq where we have to find array. here we need to find sum. O(N^2) is basic way. But lets try with increasing subseq nlogn
 * that binarysearch way. and latter calculate sum.. very complex way of doing it.
 */
public class MaxSumIncreasingSubSequence {
    public static void main(String[] args) {
        System.out.println(maxSumIncreasingSubsequence(new int[]{10, 70, 20, 30, 50, 11, 30}));
    }

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.
        List<List<Integer>> result =new ArrayList<>();

        // this is basic solution
        //meth1(array, result);
        // better solution is nlogn , learned from longestIncreasingSequence. Binary Search. very complex one
        meth2(array, result);

        return result;
    }

    static void meth2(int[] array, List<List<Integer>> result){
        int[] indices= new int[array.length];
        int[] seq = new int[array.length];
        Arrays.fill(indices, -1);
        int length=0;
        for (int i=0; i< array.length; i++){
            int targetNum= array[i];
            int newLength = bst(array, 1,length, targetNum, indices );
            seq[i]= indices[newLength-1];
            indices[newLength]= i;
            length= Math.max(newLength, length);
        }
        List<Integer> r= buildSeq(seq,array, indices[length]);
    }

    static int bst(int[] array, int start, int end, int targetNum, int[] indices){
        if (start> end) return start;
        int midIdx = (start+end)/2;
        if (array[indices[midIdx]] <= targetNum){
            return bst(array, midIdx+1, end, targetNum, indices);

        }else {
            return bst( array, start, midIdx-1, targetNum, indices);
        }
    }

    static void meth1(int[] array, List<List<Integer>> result){
        int[] length= new int[array.length];
        int[] seq= new int[array.length];
        Arrays.fill(seq,-1 );
        length[0]= array[0];

        for (int i=1; i< array.length; i++){

            for (int j=0; j<i; j++){

                if (array[i]> array[j]){
                    if (length[i] < length[j]+ array[i]){
                        length[i]= length[j]+ array[i];
                        seq[i]=j;
                    }
                }
            }
        }
        int maxSum =Integer.MIN_VALUE;
        int maxSumIdx= -1;
        for (int i=0; i < length.length; i++){
            if (maxSum < length[i]){
                maxSum= length[i];
                maxSumIdx= i;
            }
        }

        result.add(Arrays.asList(maxSum));
        result.add(buildSeq(seq, array, maxSumIdx));
    }

    static List<Integer>  buildSeq(int[] seq, int[] array, int maxIdx){
        List<Integer> seqList = new ArrayList<>();
        while (maxIdx!=-1){
            seqList.add(array[maxIdx]);
            maxIdx= seq[maxIdx];
        }
        Collections.reverse(seqList);
        return seqList;
    }


}

