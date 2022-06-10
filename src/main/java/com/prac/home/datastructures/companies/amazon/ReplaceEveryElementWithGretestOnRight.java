package com.prac.home.datastructures.companies.amazon;

import java.util.Arrays;

/**
 * Replace every element with the greatest element on right side
 */
public class ReplaceEveryElementWithGretestOnRight {
    public static int[] replaceWithGreatest(int[] array){
        int greatest=array[array.length-1];
        for (int i=array.length-2 ; i>=0; i--){
            if (array[i]>greatest){
                int temp= array[i];
                array[i]=greatest;
                greatest=temp;
            }else {
                array[i]=greatest;
            }
        }
        array[array.length-1]=-1;
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceWithGreatest(new int[]{16, 17, 4, 3, 5, 2})));
    }
}
