package com.prac.home.tests;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergerSort(new int[]{2,4,6,8}, new int[]{1,3,5,7})));
    }
    //
    static int[] mergerSort (int[] arr1, int[] arr2){
        int[] result = new int[arr1.length+arr2.length];
        int i=0; int j=0; int k=0;
        while (i< arr1.length && j< arr2.length){
            if (arr1[i]< arr2[j]){
                result[k]= arr1[i];
                i++; k++;
            }else {
                result[k]= arr2[j];
                j++; k++;
            }
        }

        while (i< arr1.length){
            result[k]= arr1[i];
            i++; k++;
        }
        while (j< arr2.length){
            result[k]= arr2[j];
            j++; k++;
        }
        return  result;
    }
}

