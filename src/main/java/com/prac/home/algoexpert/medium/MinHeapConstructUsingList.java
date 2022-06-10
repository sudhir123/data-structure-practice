package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Properties of heap, its a binary data structure . Its complete at every node except the last node which is only left to right
 * Min or Max heap , where at every node min value is is min or max from child node.
 * from input array. build method like insert, extractMin, shiftUp and down and peek
 */
public class MinHeapConstructUsingList {

    List<Integer> a= Arrays.asList(48,12,24,7,8,-5,24,391,24,56,2,6,8,41) ; // first index is 0
    List<Integer> b = new ArrayList<>(a);
    public static void main(String[] args) {
        MinHeapConstructUsingList m = new MinHeapConstructUsingList();
        m.buildHeap(m.b);
        System.out.println(m.b);
        m.insert(76);
        System.out.println("Peek "+m.peek());
        System.out.println(m.b);
        System.out.println("Removed- "+m.remove());
        System.out.println(m.b);
        System.out.println("Peek "+m.peek());
        System.out.println("Removed- "+m.remove());
        System.out.println("Peek "+m.peek());
        m.insert(87);
        System.out.println(m.b);

    }
    List<Integer> buildHeap(List<Integer> array){
        //root= buildTreeFormula(array, 0, array.size()-1);
        int parentIdx= ((array.size()-2)/2) ;
        for (int currentIdx=parentIdx; currentIdx>=0; currentIdx--){
           // System.out.println(currentIdx+" - "+ array.get(currentIdx));
            siftDown(currentIdx, array.size()-1, array);
        }
        return array;
    }
    void siftDown(int currentIdx, int endIdx,List<Integer> array){
        int childOneIdx= (2*currentIdx)+1;
        int childTwoIdx= (2*currentIdx)+2;
        if ( childOneIdx <= endIdx &&   childTwoIdx<= endIdx){
            int swapIdx = array.get(childOneIdx) < array.get(childTwoIdx) ?childOneIdx :childTwoIdx;
            if (array.get(currentIdx) > array.get(swapIdx)) {
                swap(array, currentIdx, swapIdx);
                siftDown( swapIdx, endIdx, array);
            }
        }else if ( (childOneIdx  <= endIdx ) && (array.get(childOneIdx)  < array.get(currentIdx))){
            swap(array, currentIdx, childOneIdx);
            siftDown( childOneIdx, endIdx, array);
        }else if (childTwoIdx  <= endIdx  &&(array.get(childTwoIdx)  < array.get(currentIdx))){
            swap(array, currentIdx, childTwoIdx);
            siftDown( childTwoIdx, endIdx, array);
        }
        return;
    }

    public void siftUp(int currentIdx , List<Integer> heap){
        int parentIdx = (currentIdx-1)/2;
        while (currentIdx >0 && heap.get(currentIdx)<heap.get(parentIdx)){
            swap(heap, parentIdx, currentIdx);
            currentIdx= parentIdx;
            parentIdx= (currentIdx-1)/2;
        }
    }

    // when you do insert you only move that element in upward direction, because it will added at rightmost and bottommost
    public void insert(int value) {
        b.add(value); // add at right most and call parent. this value is (2*i)+2 right most
        siftUp(b.size()-1, b);

    }
    public int peek() {
        // Write your code here.
        return b.get(0);
    }
    public int remove() {
            swap(b,0, b.size()-1);
            int minValue =b.get(b.size()-1);
            b.remove(b.size()-1);
            siftDown(0,b.size()-1, b);
            return minValue;
    }

    void swap(List<Integer> arr, int idx1 , int idx2){
        int temp=  arr.get(idx1) ;
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, temp);
    }


    static class Node{
        int data; Node right, left;
        Node(int data){this.data=data;}
    }
    Node root;
    // to build tree we can use middle element technic or formula i > root and 2*i+1 left and +2 right
    // middle element
    Node buildTreeMidElement(List<Integer> arr, int start, int end){
        if (start>end) return null;
        int mid = (start+end)/2 ;
        Node n = new Node(arr.get(mid));
        n.left= buildTreeMidElement(arr, start, mid-1);
        n.right= buildTreeMidElement(arr, mid+1, end);
        return n;
    }
    // formula i > root and 2*i+1 left and +2 right
    Node buildTreeFormula(List<Integer> arr, int i, int end){
        if (i>end) return null;
        Node n = new Node(arr.get(i));
        n.left= buildTreeFormula(arr, (2*i)+1,end);
        n.right= buildTreeFormula(arr, (2*i)+2, end);
        return n;
    }
}
