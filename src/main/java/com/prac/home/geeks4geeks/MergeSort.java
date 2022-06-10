package com.prac.home.geeks4geeks;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{3,5,8,2,1})));
    }
    public static int[] mergeSort(int[] array) {
        merge(array);
        return array;
    }

    public static int[] merge(int[] array) {
        int n = array.length;
        if (n<2) return array;

        int midIdx = (n)/2;
        int[] left = new int[midIdx];
        int[] right = new int[n-midIdx];
        for (int i=0; i< midIdx; i++){
            left[i]= array[i];
        }
        for (int i=midIdx; i< array.length; i++){
            right[i-midIdx]= array[i];
        }
        merge(left);
        merge(right);

        return sort(array, left,right,midIdx, array.length-midIdx);
    }

    public static int[] sort(int[] array, int[] left, int[] right, int leftIdx, int rightIdx) {

        int i=0, j=0, k=0;

        while (i < leftIdx && j<rightIdx){
            if (left[i]< right[j]){
                array[k]= left[i];
                i++; k++;
            }else {
                array[k]= right[j];
                j++; k++;
            }
        }
        while (i < leftIdx ){
            array[k]= left[i];
            i++; k++;
        }

        while ( j<rightIdx){
            array[k]= right[j];
            j++; k++;
        }
        return array;
    }
}






























