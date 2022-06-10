package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * from input array. build method like insert, extractMin, shiftUp and down and peek
 */
public class MinHeapConstruction {
    static class Node{
        int data; Node left, right;
        Node(int data){
            this.data= data;
        }
    }
    static Node root;

    static class MinHeap {
        List<Integer> heap = new ArrayList<>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            //root = buildTreeFromArray(array, 0);

            for (int currentIdx = (array.size()-2)/2; currentIdx>=0; currentIdx--){
                siftDown(currentIdx, array.size()-1, array);
            }
            return array;
        }

        public Node buildTreeFromArray(List<Integer> array, int idx){
            if (idx> array.size()-1){
                return null;
            }
            Node current= new Node(array.get(idx));
            current.left = buildTreeFromArray(array, (2 *idx)+1);
            current.right= buildTreeFromArray(array,(2 *idx)+2) ;
            return current;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIdx = (2*currentIdx)+1;
            while (childOneIdx<=endIdx){
                int childTwoIdx = (2*currentIdx)+2 <= endIdx ? (2*currentIdx)+2:-1;
                int swapIdx;
                if (childTwoIdx!=-1 && heap.get(childTwoIdx)<heap.get( childOneIdx )){
                    swapIdx= childTwoIdx;
                }else {
                    swapIdx=childOneIdx;
                }
                if (heap.get(currentIdx)> heap.get(swapIdx)){
                    int temp = heap.get(currentIdx);
                    heap.set(currentIdx, heap.get(swapIdx));
                    heap.set(swapIdx, temp);
                    currentIdx= swapIdx;
                    childOneIdx= (2*currentIdx)+1;
                }else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx-1)/2;
            while (currentIdx>=0 && heap.get(parentIdx) > heap.get(currentIdx)) {
                int temp = heap.get(parentIdx);
                heap.set(parentIdx, heap.get(currentIdx));
                heap.set(currentIdx, temp);
                currentIdx= parentIdx;
                parentIdx= (currentIdx-1)/2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            int minVal = heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            siftDown(0, heap.size()-1, heap);
            return minVal;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size()-1, heap);
        }
    }
    public static void main(String[] args) {
        Integer[] a= {48,12,24,7,8,-5,24,391,24,56,2,6,8,41} ;
        MinHeap m = new MinHeap(Arrays.asList(a));
        //int[] a= {1,2,3,4,5,6,7,8,9} ;

        //m.sift(a,0);
        System.out.println(m.heap);
        /*System.out.println("root > "+ m.root.data);
        System.out.println("root left > "+ m.root.left.data);
        System.out.println("root right > "+ m.root.right.data);
        System.out.println("root left > left >"+ m.root.left.left.data);
        System.out.println("root left > right >"+ m.root.left.right.data);
        System.out.println("root right > left > "+ m.root.right.left.data);
        System.out.println("root right > right > "+ m.root.right.right.data);*/
    }
}
