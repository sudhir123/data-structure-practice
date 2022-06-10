package com.prac.home.algoexpert.easy;

import java.util.Arrays;
import java.util.Map;

/**
 * returns array but in ascending order
 */
public class SortedSquaredArray {

    // O(n) time and O(n) space -- amazin solution
    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] a2 = new int[array.length];
        int smallerPointer = 0;
        int largerPointer = array.length-1;
        for (int storagePointer =array.length-1; storagePointer >0 ; storagePointer--) {
            if (Math.abs(array[smallerPointer])> Math.abs(array[largerPointer])){
                a2[storagePointer]= array[smallerPointer]*array[smallerPointer];
                smallerPointer++;
            }else {
                a2[storagePointer]=array[largerPointer]*array[largerPointer];
                largerPointer--;
            }
        }
        return a2;
    }
    /*
    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] a2 = new int[array.length];
        for (int i =0; i < array.length; i++) {
            a2[i]= array[i]*array[i];
        }
        Arrays.sort(a2); O(n log n )
        return a2;
    }
    */

    public static void main(String[] args) {
        SortedSquaredArray s = new SortedSquaredArray();
        System.out.println(Arrays.toString(s.sortedSquaredArray(new int[]{-10, -9, 0, 5, 6,7,8})));
    }
}
