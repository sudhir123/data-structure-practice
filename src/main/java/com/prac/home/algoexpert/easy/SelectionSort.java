package com.prac.home.algoexpert.easy;

import java.util.Arrays;

/**
 * check for the smallest number in the list and replace it with incremented pointer starting from 0
 */
public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{8, 5, 2, 9, 5, 6, 3})));
    }
    public static int[] selectionSort(int[] array) {

        for (int i=0; i < array.length-1; i ++){
            int smallestnumIdx = smallestNumberIdx(array, i+1);
            if (array[i] > array[smallestnumIdx]){
                int temp= array[i];
                array[i]= array[smallestnumIdx];
                array[smallestnumIdx]= temp;
            }
        }
        return array;
    }

    static int smallestNumberIdx(int[] array, int startIdx){
        int smallestIdx=-1, smallestNum=Integer.MAX_VALUE;
        for (int i=startIdx; i < array.length; i++){
            if (smallestNum > array[i]){
                smallestNum= array[i];
                smallestIdx=i;
            }
        }
        return smallestIdx;
    }
}
