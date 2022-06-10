package com.prac.home.practice.algoexpert;

import java.util.*;

//# mythinking ..this will be based on maximum increasing sum in array.
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35}));
    }
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        //return meth1(array);

        return meth2(array);
    }
    // Nlog(N) using binary search
    static List<Integer> meth2(int[] a){
        int[] indecies = new int[a.length];
        int[] seq= new int[a.length];
        Arrays.fill(indecies, -1);
        indecies[0]=0;
        Arrays.fill(seq, -1);
        int length=0;

        for (int i=0; i < a.length; i++){
            int num = a[i];
            int indSize = indecies.length;
            // BST
            int newLength = bst(a, 1, length, num, indecies);
            indecies[newLength]= i;
            length= Math.max(length, newLength);
        }
        return null;
    }
    public static int bst(int[] array,int start, int end, int target, int[] indecies) {
        if (start> end) return start;
        int mid= (start+end)/2;
        if(array[indecies[mid]] > target){
            return bst(array, start, mid-1, target, indecies);
        }else {
            return bst(array, mid+1, end, target, indecies);
        }
    }

    // first method is medium level difficulty and in this we go by O(N^2) we need to track increasing seq length and also we need to track
    // last element's index , which get added to the seq
    static List<Integer> meth1(int[] a){
        int[] length= new int[a.length];
        int[] seq= new int[a.length];

        Arrays.fill(length, 1);
        Arrays.fill(seq, -1);
        for (int i=1;i < a.length; i ++ ){

            for (int j=0; j <i; j++){

                if (a[i]> a[j]  && length[i] < length[j]+1 ){
                    length[i]=  length[j]+1;
                    seq[i]= j;
                }
            }
        }
        int maxIdx=-1; int maxNum = Integer.MIN_VALUE;
        for (int j=0; j <a.length; j++){
            if (length[j] > maxNum){
                maxNum= length[j];
                maxIdx= j;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(a[maxIdx]);
        while (maxIdx!=-1 && seq[maxIdx]!=-1){
            result.add(0, a[seq[maxIdx]]);
            maxIdx= seq[maxIdx];
        }
        return result;
    }
}
