package com.prac.home.practice;

import java.util.Arrays;

/**
 * Given an array arr[] of size N where every element is in the range from 0 to n-1. Rearrange the given array so that arr[i] becomes arr[arr[i]].
 * arr[] = {1,0}
 * arr[arr[0]] = arr[1] = 0.
 * arr[arr[1]] = arr[0] = 1.
 */
public class RearrangeAnArrayWithO1ExtraSpace {
    public static void main(String[] args) {
        RearrangeAnArrayWithO1ExtraSpace r= new RearrangeAnArrayWithO1ExtraSpace();
        long[] arr = new long[]{1,0};
        System.out.println(Arrays.toString(arr));
        arrange(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void arrange(long arr[], int n){
        for (int i=0; i < n; i++){
            arr[i]= arr[i]+ (arr[(int)arr[i]]%n)*n;
        }
        for (int i=0; i < n; i++){
            arr[i]= arr[i]/n;
        }
    }
}
