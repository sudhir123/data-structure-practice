package com.prac.home.algoexpert.medium;

import java.util.Arrays;

/**
 *
 */
public class ArrayOfProducts {
    // #mythinking time and space O(N)
    /*public int[] arrayOfProducts(int[] array) {
        int product=1; int zeroCounter=0;
        for (int i =0; i< array.length; i ++){
            if (array[i]==0) {
                zeroCounter++; continue;
            }
            product=product*array[i];
        }
        if (zeroCounter>1) {
            return new int[array.length];
        }else if (zeroCounter==1){
            for (int i = 0; i < array.length; i++) {
                if (array[i]==0){
                    array[i]=product;
                }else {
                    array[i] = 0;
                }
            }
        }else {
            for (int i = 0; i < array.length; i++) {
                array[i] = product / array[i];
            }
        }
        return array;
    }*/

    // another way
    public static int[] arrayOfProducts(int[] array) {
        int[] product= new int[array.length];

        int leftRunningProduct=1;
        for (int i =0; i < array.length; i ++){
            product[i]=leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct =1;
        for (int i = array.length-1; i>=0; i--){
            product[i] *= rightRunningProduct;
            rightRunningProduct *= array[i];
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfProducts(new int[]{5, 1, 4, 2})));
    }
}

















