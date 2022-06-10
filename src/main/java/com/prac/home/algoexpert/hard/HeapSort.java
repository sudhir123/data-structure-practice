package com.prac.home.algoexpert.hard;

import java.util.Arrays;
import java.util.List;

/**
 * algo works based on max heap. and than take max value and replace with last index , which is its correct position. so we contineue sorting thsi
 * way and whole array is sorted. steps 1) is to create max heap out of the array.
 * we cannot take min heap as there is no room for replacement and making sorting works.
 */
public class HeapSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(heapSort(
                new int[]{8, 5, 2, 9, 5, 6, 3}
        )));
    }
    public static int[] heapSort(int[] array) {
        buildHeap(array);
        for (int end=array.length-1; end>0; end--){
            swap(0, end, array);
            siftDown(array,0, end-1);
        }
        return array;
    }

    // create max heap out of an array
    public static int[] buildHeap(int[] array){
        int firstParentIdx = (array.length-2)/2;
        for (int currentIdx= firstParentIdx; currentIdx>=0; currentIdx--){
            siftDown(array, currentIdx, array.length-1);
        }
        return array;
    }

    public static void siftDown(int[] heap,int parentIdx, int end ){
        int childOneIdx = (2*parentIdx)+1;
        while (childOneIdx<=end){
            int childTwoIdx = (2*parentIdx)+2 <= end? (2*parentIdx)+2: -1;
            int swapIdx ;
            if (childTwoIdx!=-1 && heap[childOneIdx] < heap[childTwoIdx]){
                swapIdx= childTwoIdx;
            }else {
                swapIdx= childOneIdx;
            }

            if (heap[swapIdx]> heap[parentIdx]){
                swap(swapIdx, parentIdx, heap);
                parentIdx=swapIdx;
                childOneIdx= (2*parentIdx)+1;
            }else {
                return;
            }
        }
    }

    public static void swap(int i, int j, int[] heap){
        int temp = heap[i];
        heap[i]= heap[j];
        heap[j]= temp;
    }

}


























