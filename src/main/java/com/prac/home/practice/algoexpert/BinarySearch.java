package com.prac.home.practice.algoexpert;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        Arrays.sort(array);
        return bst(array,0, array.length-1, target );
    }

    public static int bst(int[] array,int start, int end, int target) {
        if (start> end) return -1;
        int mid= (start+end)/2;
        if (array[mid]==target){
            return mid;
        }else if(array[mid] > target){
            return bst(array, start, mid-1, target);
        }else {
            return bst(array, mid+1, end, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
    }
}
