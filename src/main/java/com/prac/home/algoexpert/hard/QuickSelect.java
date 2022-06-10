package com.prac.home.algoexpert.hard;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * using quick sort , select the third smallest element in linear time complexity.
 * Quick Sort works on the principle of selecting pivot(any) and then traverse the elements by two pointers left adn right and
 * keep left eleemnts smaller then pivot and right greater than pivot. at the end replace with right.
 */
public class QuickSelect {
    public static void main(String[] args) {
        System.out.println(quickSelect(new int[]{8, 5, 2, 9, 7, 6, 3}, 3));
    }
    public static int quickSelect(int[] array, int k) {
        select(array,0, array.length-1,k);
        //System.out.println(Arrays.toString(array));
        return array[k-1];
    }

    public static void select(int[] array, int start, int end, int k){
        if (start>=end) return;

        int leftIdx = start+1;
        int rightId = end;
        int pivotIdx =start;

        while (leftIdx<=rightId){
            if (array[leftIdx]>=array[pivotIdx] && array[rightId]<= array[pivotIdx]){
                swap(leftIdx, rightId, array);
            }
            if (array[leftIdx]<=array[pivotIdx]){
                leftIdx+=1;
            }
            if (array[rightId]>=array[pivotIdx]){
                rightId-=1;
            }
        }
        swap(pivotIdx, rightId, array);
        if (k<=rightId){
            //System.out.println("kth value is less than right idx");
            select(array, start, rightId-1,k);
        }else {
            //System.out.println("kth value is greater than right idx");
            select(array, rightId+1, end, k);
        }
    }

    static void swap(int i, int j , int[]array){
        int temp = array[i];
        array[i] = array[j];
        array[j]= temp;
    }
}


























