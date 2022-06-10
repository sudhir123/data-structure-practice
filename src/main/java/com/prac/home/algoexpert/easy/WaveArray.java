package com.prac.home.algoexpert.easy;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

public class WaveArray {

    public static void convertToWave(int arr[], int n){
        int i=0, j=1;
        for (; j< arr.length; ){
            int temp = arr[i];
            arr[i]= arr[j];
            arr[j]=temp;
            i=j+1;
            j=i+1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        convertToWave(new int[]{1,2,3,4,5,6},6);
    }
}
