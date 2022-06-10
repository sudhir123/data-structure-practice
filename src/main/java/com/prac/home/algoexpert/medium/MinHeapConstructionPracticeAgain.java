package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * from input array. build method like insert, extractMin, shiftUp and down and peek
 */
public class MinHeapConstructionPracticeAgain {
    static class MinHeap {
        List<Integer> heap = new ArrayList<>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            List<Integer> list = new ArrayList<Integer>();
            for (Integer next: array
                 ) {
                insert(next);
            }
            return list;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {

            int leftIdx = (2*currentIdx)+1;
            while (leftIdx<=endIdx){
                int rightIdx=   ((2*currentIdx) +2) <=endIdx ?  ((2*currentIdx) +2): -1;
                int swapIdx;
                if (rightIdx!=-1 && heap.get(leftIdx)> heap.get(rightIdx))
                    swapIdx= rightIdx;
                else
                    swapIdx= leftIdx;

                if (heap.get(currentIdx)> heap.get(swapIdx)){
                    swap(heap, currentIdx,swapIdx);
                    currentIdx=swapIdx;
                    leftIdx = (2*currentIdx)+1;
                }else {
                    return;
                }
            }

        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            Integer parentIdx = (currentIdx-1 )/2;
            while (heap.get(parentIdx)> heap.get(currentIdx)){
                swap(heap, parentIdx, currentIdx);
                currentIdx= parentIdx;
                parentIdx= (currentIdx-1 )/2;
            }
        }

        public void swap(List<Integer> heap, Integer idx1, Integer idx2){
            Integer val = heap.get(idx1);
            heap.set(idx1, heap.get(idx2));
            heap.set(idx2,val );
        }

        public int peek() {
            // Write your code here.
            return -1;
        }

        public int remove() {
            // Write your code here.
            return -1;
        }

        public void insert(int value) {
            heap.add(value);
        }
            // Write your code here.
        }


    public static void main(String[] args) {
        int[] a= {48,12,24,7,8,-5,24,391,24,56,2,6,8,41} ;
        //MinHeapConstructionPracticeAgain.MinHeap m= new MinHeap(a);
        System.out.println(Arrays.toString(a));

    }
}


























