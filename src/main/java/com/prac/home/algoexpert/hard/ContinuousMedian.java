package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ContinuousMedian {
    public static void main(String[] args) {
        ContinuousMedianHandler c =new ContinuousMedianHandler();
        c.insert(5);
        //System.out.println(c.median);
        c.insert(10);
        //System.out.println(c.median);
        c.insert(100);
        c.insert(200);
        c.insert(6);
        System.out.println(c.median);
        c.insert(13);
        System.out.println(c.median);
    }
    static class Heap{
        List<Integer> heap= new ArrayList<>();
        BiFunction<Integer, Integer, Boolean> comparisonFunc;
        int length;

        public Heap(BiFunction<Integer, Integer, Boolean> comparisonFunc, List<Integer> array){
            this.comparisonFunc=comparisonFunc;
            this.heap=buildHeap(array);
            this.length= heap.size();
        }
        public List<Integer> buildHeap(List<Integer> array) {
            for (int currentIdx = (array.size()-2)/2; currentIdx>=0; currentIdx--){
                siftDown(currentIdx,array.size()-1, array);
            }
            return array;
        }
        public void siftDown(int currentIdx, int endIdx, List<Integer>heap){
            int childOneIdx = (2*currentIdx)+1;
            while (childOneIdx<= endIdx ) {
                int childTwoIdx = (2 * currentIdx) + 2 <= endIdx ? (2 * currentIdx) + 2 : -1;
                int swapIdx;
                if (childTwoIdx != -1) {
                    if (comparisonFunc.apply(heap.get(childTwoIdx), heap.get(childOneIdx))){
                        swapIdx = childTwoIdx;
                    } else {
                        swapIdx = childOneIdx;
                    }
                }else {
                    swapIdx = childOneIdx;
                }
                if (comparisonFunc.apply(heap.get(swapIdx), heap.get(currentIdx))){
                    swap(currentIdx, swapIdx,heap);
                    currentIdx= swapIdx;
                    childOneIdx= (2*currentIdx)+1;
                }else {
                    return;
                }
            }
        }
        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (parentIdx >= 0) {
                if (comparisonFunc.apply(heap.get(currentIdx), heap.get(parentIdx))) {
                    swap(currentIdx, parentIdx, heap);
                    currentIdx = parentIdx;
                    parentIdx = (currentIdx - 1) / 2;
                }else {
                    return;
                }
            }
        }
        public void insert(int number){
            heap.add(number);
            length++;
            siftUp(heap.size()-1, heap);
        }
        public int remove(){
            swap(0, heap.size()-1, heap);
            int val = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            length--;
            siftDown(0,heap.size()-1,heap);
            return val;
        }

        public int peek(){
            return heap.get(0);
        }
        public void swap(int id1, int id2, List<Integer> heap){
            int temp = heap.get(id1);
            heap.set(id1, heap.get(id2));
            heap.set(id2, temp);
        }

        public static Boolean MAX_HEAP_FUNC(Integer a, Integer b){
            return a>b;
        }

        public static Boolean MIN_HEAP_FUNC(Integer a, Integer b){
            return a<b;
        }
    }


    static class ContinuousMedianHandler {
        double median = 0;
        Heap greater=new Heap(Heap::MIN_HEAP_FUNC, new ArrayList<>());
        Heap lower = new Heap(Heap::MAX_HEAP_FUNC, new ArrayList<>());

        public void insert(int number) {
            if (lower.length==0|| number < lower.peek()){
                lower.insert(number);
            }else {
                greater.insert(number);
            }
            rebalanced();
            updateMedian();
        }

        public void rebalanced(){
            if (lower.length-greater.length==2){
                greater.insert(lower.remove());
            }else if (greater.length- lower.length==2){
                lower.insert(greater.remove());
            }
        }
        public void updateMedian(){
            if ( lower.length==greater.length ){
                median= ((double)lower.peek()+(double)greater.peek())/2;
            }else{
                if (lower.length > greater.length){
                    median= lower.peek();
                }else {
                    median= greater.peek();
                }
            }
        }

        public double getMedian() {
            return median;
        }
    }
}
