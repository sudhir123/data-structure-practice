package com.prac.home.algorithms;

import java.util.Arrays;

/**
 * pick any element from pivot and swaps values such that less value elements appears left from pivot.
 * recursion
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {7,8,6,9,1,2,4,3,5};
        while(quickSort(arr,0)){
            Arrays.stream(arr).forEach(System.out::print);
        }
    }
    public static boolean quickSort(int[] arr, int startIndex){
        System.out.println(startIndex);

        if (startIndex+1>= arr.length) return false;

        if(arr[startIndex]> arr[startIndex+1]){
            int temp = arr[startIndex];
            arr[startIndex]= arr[startIndex+1];
            arr[startIndex+1]= temp;
        }
        quickSort(arr,++startIndex);
        return true;
    }
}
