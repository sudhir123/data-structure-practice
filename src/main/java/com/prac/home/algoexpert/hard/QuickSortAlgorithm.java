package com.prac.home.algoexpert.hard;

import java.util.Arrays;

/**
 *
 */
public class QuickSortAlgorithm {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{1, 3, 2})));
    }
    public static int[] quickSort(int[] array) {
        search(array, 0, array.length-1);
        return array;
    }

    public static void search(int[] array, int start, int end){
        if (start>=end) return ;

        int pivot= start;
        int left= start+1;
        int right= end;

        while (left<= right){
            if (array[left]>=array[pivot] && array[right]<=array[pivot]){
                swap(left, right, array);
            }
            if (array[left]<=array[pivot]){
                left+=1;
            }
            if (array[right]>= array[pivot]){
                right-=1;
            }
        }
        swap(pivot, right, array);

        boolean leftArrayIsSmaller= ((right-1)-start) < end-(right+1);

        if (leftArrayIsSmaller){
            search(array,start, right-1);
            search(array, right+1, end);
        }else {
            search(array, right+1, end);
            search(array,start, right-1);

        }

    }
    static void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i]= array[j];
        array[j]= temp;
    }
}
