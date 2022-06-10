package com.prac.home.algoexpert.easy;
/**
 * search target element in sorted array using binary search. Time O(log n) and space O(1). Normal search is O(n) and logN is better
 * "Binary Search" the elements MUST BE sorted. and algo is to use middle element and then move right or left.
 */
public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        return search(array,0,array.length-1, target);
    }
    // O(logn) time and space
    /*static int search(int[] array, int start , int end , int target){
        if (start>end) return -1;
        int mid = (start+end)/2;
        if (array[mid]==target) return mid;
        else if(array[mid]> target){
            return search(array,start,mid-1, target);
        }else {
            return search(array, mid+1, end,target);
        }
    }*/
    static int search(int[] array, int start , int end , int target){
        while (start<=end){
            int mid = (start+end)/2;
            if (array[mid]==target) return mid;
            else if(array[mid]> target){
                end= mid-1;
            }else {
                start= mid+1;
            }
        }
        return -1;
    }
    // another time O(log n) but time is O(1)

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
    }
}
