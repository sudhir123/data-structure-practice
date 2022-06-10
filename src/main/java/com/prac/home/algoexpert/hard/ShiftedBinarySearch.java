package com.prac.home.algoexpert.hard;

/**
 * function takes in sorted array of distinct integers as well as target integer. Sorted array is basically shifted with some rotation
 * e. 123 -> 312 .. shifted by 1. We need find the target integer using binary search.
 * Binary search normally applies to sorted array. compares the element with middle element and move right and left. O(log n).
 */
public class ShiftedBinarySearch {
    public static int shiftedBinarySearch(int[] array, int target) {
        return search(array, target, 0, array.length-1);
    }

    //#mythinking trying with recursion
    static int search(int[] array , int target, int left, int right){
        if (left> right) return -1;

        int mindIdx = (left+right)/2;
        int potentialSearch= array[mindIdx] ;
        int leftNum = array[left];
        int rightNum = array[right];

        if (target==potentialSearch)
            return mindIdx;
        else if (leftNum<=potentialSearch) {
            if (target < potentialSearch && target >= leftNum) {
                return search(array, target, left, mindIdx - 1);
            } else {
                return search(array, target, mindIdx + 1, right);
            }
        }else {
            if (target > potentialSearch && target<=rightNum){
                return search(array, target, mindIdx + 1, right);
            }else {
                return search(array, target, left, mindIdx - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(shiftedBinarySearch(new int[]{71, 72, 73, 0, 1, 21, 33, 37, 45, 61},73 ));
    }
}
