package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 =new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 =new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 =new ListNode(2, new ListNode(6));
        //ListNode[] lists= {l1, l2, l3};
        ListNode[] lists= {};
        MergeKSortedLists m = new MergeKSortedLists();
        m.mergeKLists(lists);

    }
    //#leetciode. lets try with min heap
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // second way by merging two list and keep on doing with next list
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length<1) return null;
        ListNode result = lists[0];
        for (int i=1; i< lists.length; i++){
            result= sortAndMerge(result, lists[i]);
        }
        return result;
    }

    public ListNode sortAndMerge(ListNode head1, ListNode head2){
        List<Integer> resultList = new ArrayList<>();
        while (head1!=null && head2!=null){
            if (head1.val <= head2.val){
                resultList.add(head1.val);
                head1= head1.next;
            }else {
                resultList.add(head2.val);
                head2= head2.next;
            }
        }
        while (head1!=null){
            resultList.add(head1.val);
            head1= head1.next;
        }
        while (head2!=null){
            resultList.add(head2.val);
            head2= head2.next;
        }
        ListNode resultHead= new ListNode(resultList.get(0));
        ListNode current =resultHead;
        for (int i=1; i< resultList.size(); i++){
            current.next= new ListNode(resultList.get(i));
            current= current.next;
        }
        return resultHead;
    }

    // one way my Min HEap
    /*public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> array = new ArrayList<>();
        for (ListNode listNode: lists
             ) {
            while (listNode!=null){
                array.add(listNode.val);
                listNode= listNode.next;
            }
        }
        MinHeap m = new MinHeap(array);
        ListNode current=null;ListNode head=current;

        while (!m.isEmpty()){
            current= new ListNode(m.remove());
            current= current.next;
        }
        return head;
    }*/

    static class  MinHeap{
        List<Integer> heap;
        MinHeap( List<Integer> array){
            heap= buildHeap(array);
        }
        public boolean isEmpty(){
            return heap.isEmpty();
        }

        public static List<Integer> buildHeap(List<Integer> array){
            int firstParentIdx = (array.size()/2) -1;
            for (int parentIdx =firstParentIdx; parentIdx>=0; parentIdx--){
                siftDown(array, parentIdx);
            }
            return array;
        }

        public static void siftDown(List<Integer> array, int parentIdx){
            int childOneIdx= (2*parentIdx)+1;
            while (childOneIdx< array.size()){
                int childTwoIdx = (2*parentIdx)+2 < array.size()? (2*parentIdx)+2:-1;
                int swapIdx ;
                if (childTwoIdx!=-1 && array.get(childTwoIdx)<array.get(childOneIdx)){
                    swapIdx= childTwoIdx;
                }else {
                    swapIdx= childOneIdx;
                }

                if (array.get(parentIdx) > array.get(swapIdx)) {
                    swap(parentIdx, swapIdx, array);
                    parentIdx= swapIdx;
                    childOneIdx= (2*parentIdx)+1;
                }else {
                    break;
                }
            }
        }
        public Integer remove(){
            swap(0, heap.size()-1, heap);
            int ele = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            siftDown(heap,0);
            return ele;
        }
    }
    public static void swap(int i, int j , List<Integer> array){
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    //# algo expert
    // one way is to use MinHeap and add all elements in an array and create minheap out of it and keep on removing element and add to list
    // another way is to create list to track the pointers of every list in Mianlist.
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {


        // Write your code here.
        List<Integer> mer= new ArrayList<>();
        for (List<Integer> a:
                arrays) {
            mer.addAll(a);
        }
        Collections.sort(mer);
        return mer;
    }
}





















