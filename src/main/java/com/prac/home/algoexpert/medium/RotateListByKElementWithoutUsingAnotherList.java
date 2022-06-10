package com.prac.home.algoexpert.medium;

import java.util.Arrays;

/**
 * trick is without using another list/array
 */
public class RotateListByKElementWithoutUsingAnotherList {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate2(new int[]{1,2,3,4}, 2)));
    }
    public static int[] rotate(int[] array, int k){
        System.out.println(k);
        k = k%array.length;
        System.out.println(k);
        for (int i =0; i <k; i++){
            int temp =Integer.MIN_VALUE;
            for (int j=0; j< array.length; j++){
                if (j==0){
                    temp= array[j+1];
                    array[j+1]= array[j];
                }else if (j==array.length-1){
                    array[0]=temp;
                }else {
                    int temp2= array[j+1];
                    array[j+1]= temp;
                    temp= temp2;
                }
            }
        }
        return array;
    }
    public static int[] rotate2(int[] array, int k){
        k = k%array.length;
        int currentRotations=0;
        int currentIdx=0;
        int temp = array[currentIdx];
        while (currentRotations< k*array.length){
            currentIdx= calculateIdx(currentIdx, k, array.length);
            System.out.println("new calculatedIdx ="+ currentIdx );
            int temp2= array[currentIdx];
            array[currentIdx]= temp;
            temp= temp2;
            currentRotations++;
        }
        return array;
    }
    static int calculateIdx(int currentIdx, int rotations, int arrayLength){
        int expectedIdx= currentIdx+ rotations;
        if (expectedIdx > arrayLength-1){
            expectedIdx= expectedIdx-arrayLength;
        }
        return expectedIdx;
    }
}
