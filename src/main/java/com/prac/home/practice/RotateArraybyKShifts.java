package com.prac.home.practice;

import java.util.Arrays;

public class RotateArraybyKShifts {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shiftElementsForwardByK(new int[]{1,2,3,4,}, 4)));
    }
    static int[] shiftElementsForwardByK(int[] array , int k ){
        int length = array.length;
        int[] copy = new int[array.length];
        for (int i=0; i < length; i++ ){
            int nextIdx = i+k;
            if (nextIdx>= length){
                nextIdx= nextIdx%length;
            }
            copy[nextIdx]= array[i];
        }
        return copy;
    }

    static int[] shiftElementsBackWardByK(int[] array , int k ){
        int length = array.length;
        int[] copy = new int[array.length];
        for (int i=0; i < length; i++ ){
            int nextIdx = i+k;
            if (nextIdx>= length){
                nextIdx= nextIdx%length;
            }
            copy[nextIdx]= array[i];
        }
        return copy;
    }
}
