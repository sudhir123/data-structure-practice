package com.prac.home.algoexpert.easy;

import java.util.Arrays;

/**
 * function that taken in an array and return sorted version.
 * BubbleSort --> simple and good for learning. iterate multiple times , each time do swap. We will do it in same array not external other array
 * in this algo, in first iteration itself we see that that last index will be the largest number means at its correct position.
 * /
 */
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{8, 5, 2, 9, 5, 6, 3})));
    }
    public static int[] bubbleSort(int[] array) {
        boolean swap=true;
        int count=0;
        while (swap){
            System.out.println(count++);
            swap=false;
            for (int i=1; i <array.length; i++){
                if (array[i-1] > array[i]){
                    swap=true;
                    int temp =array[i];
                    array[i]= array[i-1];
                    array[i-1]= temp;
                }
            }
        }
        return array;
    }
}
