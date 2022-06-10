package com.prac.home.datastructures.array.sorting;


import java.util.Arrays;

// fast algo
//  for understanding split ... check for logarithmic time
// then we will se merge routine
// if problems large ...break the prob in small
// small solve and merge solution
// single element , we dont need to solve. recursive Algorithem
public class MergeSort {

    public static void main(String[] args) {
        int[] arr= new int[]{2,3,3,1,9,5,6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Algo --> merge sort
     * parameter begin end of list , low and high
     * if low is less then h -> this means list has more than 1 element , we will find mid
     * now we have two list .. same recursion on left and right.
     * At end we need merge also Merge is another task
     */

    public static int[] mergeSort(int[] a) {
        int n = a.length;
        if (n < 2) {
            return a;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l);
        mergeSort(r);

        return merge(a, l, r, mid, n - mid);
    }

    public static int[] merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
        return a;
    }

}



























