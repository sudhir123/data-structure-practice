package com.prac.home.practice;

/**
 * strictly non decreasing or strictly non increasing.
 */
public class MonotonicArray {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new
                int[]{-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -8, -9, -10, -11}));
    }
    public static boolean isMonotonic(int[] array) {
        boolean increasing =false, positives=false;
        if (array.length<=1) return true;

        if (array[0]>= array[1]){
            increasing=true;
        }
        if (array[0]>=0) {
            positives=true;
        }
        for (int i=0; i< array.length; i++){
            if (increasing && positives){
                if (array[i] <array[i+1]){
                    return false;
                }
            }else {
                if (array[i] >array[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
