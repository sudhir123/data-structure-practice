package com.prac.home.excelsheet450.hard;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        MergeWithoutExtraSpace m= new MergeWithoutExtraSpace();
        m.merge(
                new int[]{1, 1, 2, 2, 2 ,3,4 ,5, 5 ,6, 7, 7 ,10 ,12, 14, 15, 16, 17, 17, 18, 19, 19 },
                new int[]{3},
                22,
                1 );
        //m.merge(new int[]{10, 12 }, new int[]{5, 18, 20},2, 3 );
    }
    public void merge(int arr1[], int arr2[], int n, int m) {
        int i=0; int j=0;
        while (i < n && j< m){
            if (arr1[i] > arr2[j]){
                swap(arr1, arr2, i, j);
                if (j+1 < m &&  arr2[j]> arr2[j+1]){
                    swap(arr2, arr2, j, j+1);
                }
            }
            i++;
        }
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public void swap(int[] arr1, int[] arr2, int i, int j){
        int temp = arr1[i];
        arr1[i]= arr2[j];
        arr2[j]= temp;
    }
}
