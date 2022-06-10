package com.prac.home.practice.algoexpert;

import java.util.Arrays;

public class ArrayOfProducts {
    public static void main(String[] args) {
        ArrayOfProducts a= new ArrayOfProducts();
        System.out.println(Arrays.toString(a.arrayOfProducts(new int[]{5, 1, 4, 2})));
    }
    public int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        left[0]= 1; right[array.length-1]=1;
        for (int i=1; i<array.length; i++ ){
            left[i]= array[i-1]*left[i-1];
        }

        System.out.println(Arrays.toString(left));
        for (int i=array.length-2; i>=0; i--){
            right[i]= array[i+1]* right[i+1];
        }
        System.out.println(Arrays.toString(right));
        for (int i=0; i<array.length; i++ ){
            result[i]= left[i]*right[i];
        }
        return result;
    }

}
