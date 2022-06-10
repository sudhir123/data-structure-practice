package com.prac.home.algoexpert.hard;

import java.util.*;

/**
 * #array
 * every element is max k number away from its right position. Sort the array better then nlogn.
 */
public class SortKSortedArray {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(mergeSort(new int[]{8, 5, 2, 9, 5, 6, 3})));
        SortKSortedArray s = new SortKSortedArray();
        System.out.println(Arrays.toString(s.sortKSortedArray(new int[]{1, 2, 3, 4, 5, 6, 1},8)));
    }
    // so far the best solution using MinHeap.
    // create arraylist og k+1 elements from all the elements of array and pass it to create MinHeap.
    //now min heap has some sorting mach which will keep min element on top from the k element.
    // now remove this element and add one more element k+1 +1th position. This way we  will remove min and add one in minimum time
    public int[] sortKSortedArray(int[] array, int k) {
        List<Integer> list =new ArrayList<>();
        for (int i=0; i <Math.min(k+1, array.length); i++) {
            list.add(array[i]);
        }
        int[] result = new int[array.length];
        int j=0;
        MinHeapKSortingArray m = new MinHeapKSortingArray(list);
        for (int i =k+1; i < array.length; i++){
            result[j++]=m.remove();
            m.insert(array[i]);
        }
        while (!list.isEmpty()){
            result[j++]=m.remove();
        }
        return result;
    }


    static class MinHeapKSortingArray{
        List<Integer> heap ;
        MinHeapKSortingArray(List<Integer> list){
            heap= buildHeap(list);
        }

        public List<Integer> buildHeap(List<Integer> array){

            for (int firstParentIdx = (array.size()-2)/2; firstParentIdx >=0; firstParentIdx--){
                siftDown(array, firstParentIdx);
            }
            return array;
        }
        public void siftDown(List<Integer> array, int currentIdx){
            int child1Idx = (2*currentIdx)+1;
            while (child1Idx < array.size() ){
                int child2Idx = (2*currentIdx)+2 < array.size() ?(2*currentIdx)+2 :-1;
                int swapIdx;
                if (child2Idx!=-1 && array.get(child2Idx)< array.get(child1Idx)){
                    swapIdx= child2Idx;
                }else {
                    swapIdx= child1Idx;
                }
                if (array.get(currentIdx)> array.get(swapIdx)){
                    swap(array, swapIdx, currentIdx);
                    currentIdx= swapIdx;
                    child1Idx= (2*currentIdx)+1;
                }else {
                    break;
                }
            }
        }
        public void siftUp(int currentIdx){
            int parentIdx = (currentIdx-1)/2 ;
            while (parentIdx>=0 && heap.get(currentIdx)< heap.get(parentIdx)){
                swap(heap, parentIdx, currentIdx);
                currentIdx= parentIdx;
                parentIdx= (currentIdx-1)/2;
            }
        }

        public void swap(List<Integer> heap, Integer idx1, Integer idx2){
            int temp = heap.get(idx2);
            heap.set(idx2, heap.get(idx1));
            heap.set(idx1, temp);
        }

        public void insert(Integer num){
            heap.add(num);
            siftUp(heap.size()-1);
        }
        public int remove(){
            swap(heap, 0, heap.size()-1);
            int val = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            siftDown(heap, 0);
            return val;
        }
    }

    // actual problem this solution is also not , it worked but best is when we use heap
    /*public int[] sortKSortedArray(int[] array, int k) {
        for (int i=0; i< array.length-k+1; i++){
            partialSort(array, i, k);
        }
        return array;
    }*/
    public void partialSort(int[] array, int start, int k){
        Arrays.sort(array, start, start+k);
    }

    // lets try with merge sort first for practice which is nlogn
    public static int[] mergeSort(int[] array) {
        return sort(array);
    }

    static int[] sort(int[] array){
        if (array.length<2) return array;
        int length = array.length;
        int midIdx = length/2;
        int[] left= new int[midIdx];
        for (int i=0; i < midIdx; i++){
            left[i]= array[i];
        }
        int[] right = new int[length-midIdx];
        for (int i=midIdx; i< length; i++){
            right[i-midIdx]= array[i];
        }

        sort(left);
        sort(right);

        return merge(array, left, right);

    }

    static int[] merge(int[] a, int[] l, int[] r){
        int leftLength = l.length;
        int rightLength = r.length;
        int i=0, j=0, k=0;
        while (i< leftLength && j<rightLength){
            if (l[i]<=r[j]){
                a[k++]= l[i++];
            }else {
                a[k++]= r[j++];
            }
        }
        while (i< leftLength){
            a[k++]=l[i++];
        }
        while (j<rightLength){
            a[k++]= r[j++];
        }
        return a;
    }


}
