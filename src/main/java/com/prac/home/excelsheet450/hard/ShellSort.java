package com.prac.home.excelsheet450.hard;

import java.util.Arrays;

/**
 * modification over insertion sort
 */
public class ShellSort {
    public static void main(String[] args) {
        selectionSort(new int[]{5,2,8,1,3,9,4});

    }
    static void selectionSort(int[] array){
        int n = array.length;
        int gap = n/2;
        for (int i=0; i<= gap ; i++, gap--){
            int k=i, j=gap;

            while (j< n) {
                if (array[k] > array[j]) {
                    swap(array, k, j);
                }
                k++; j++;
            }

        }
        System.out.println(Arrays.toString(array));
    }
    static void swap(int[] arra, int i, int j){
        int temp= arra[i];
        arra[i]= arra[j];
        arra[j]= temp;
    }
}
