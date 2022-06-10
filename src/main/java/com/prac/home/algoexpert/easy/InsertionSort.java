package com.prac.home.algoexpert.easy;

import java.util.Arrays;

/**
 * function to return sortd array using insertion sort. This is opp to bubble sort. Time complexity is same O(n^2)
 * here in this algo we pick number from start and check with all number on left.
 */
public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{8, 5, 2, 9, 5, 6, 3})));
    }
    public static int[] insertionSort(int[] array) {
        for (int i =0; i < array.length-1; i++){
            for (int j=i+1; j >0; j--){
                if (array[j]< array[j-1]){
                    int temp = array[j];
                    array[j]= array[j-1];
                    array[j-1]=temp;
                }
            }
        }
        return array;
    }
}
