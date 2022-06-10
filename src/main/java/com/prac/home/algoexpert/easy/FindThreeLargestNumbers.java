package com.prac.home.algoexpert.easy;
/**
 * function to return array of three largest number on given an i/p of unsorted array
*/
public class FindThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {
        int largest=Integer.MIN_VALUE, secLargest=Integer.MIN_VALUE, thirdLargest=Integer.MIN_VALUE;
        for (int i=0; i <array.length; i ++){
            int current= array[i];
            if (current>=largest){
                thirdLargest=secLargest;
                secLargest=largest;
                largest=current;
            }else if (current>=secLargest){
                thirdLargest=secLargest;
                secLargest=current;
            }else if (current>=thirdLargest){
                thirdLargest=current;
            }
        }
        return new int[]{thirdLargest, secLargest,largest};
    }
}
