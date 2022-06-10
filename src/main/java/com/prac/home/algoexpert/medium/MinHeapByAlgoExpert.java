package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * from input array. build method like insert, extractMin, shiftUp and down and peek
 */
public class MinHeapByAlgoExpert {
    static class Minheap{
        List<Integer> heap = new ArrayList<>();

        public Minheap(List<Integer> array){
            heap= buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array ){
            int firstParentIdx = (array.size()-2)/2;
            for (int currentIdx = firstParentIdx; currentIdx>=0; currentIdx--){
                siftDwn(currentIdx, array.size()-1, array);
            }
            return array;
        }

        public void siftDwn(int currIdx, int end, List<Integer> heap){
            int childOneIdx = (2*currIdx)+1;
            while (childOneIdx <= end){
                int childTwoIdx = ((2*currIdx) +2) <=end ?  ((2*currIdx) +2): -1;
                int swapIdx ;
                if (childTwoIdx !=-1 && heap.get(childTwoIdx)< heap.get(childOneIdx)){
                    swapIdx= childTwoIdx;
                }else {
                    swapIdx= childOneIdx;
                }
                if (heap.get(currIdx)> heap.get(swapIdx)){
                    swap(currIdx, swapIdx, heap);
                    currIdx= swapIdx;
                    childOneIdx= (2*currIdx)+1;
                }else{
                    return;
                }
            }

        }

        public void swap(int currIdx, int swapIdx , List<Integer> heap){
            int temp = heap.get(swapIdx);
            heap.set(swapIdx, heap.get(currIdx));
            heap.set(currIdx, temp);
        }
    }

    

    public static void main(String[] args) {
        List<Integer> a= Arrays.asList(48,12,24,7,8,-5,24,391,24,56,2,6,8,41) ; // first index is 0
        List<Integer> b = new ArrayList<>(a);
        Minheap m = new Minheap(a);
        System.out.println(m.heap);
    }
}
