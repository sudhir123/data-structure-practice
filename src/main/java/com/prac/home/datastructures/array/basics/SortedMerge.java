package com.prac.home.datastructures.array.basics;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge
 * B into A in sorted order. Merge Sorted Arrays.
 */
public class SortedMerge {
    /*  Cracking the coding solution for two Arrays. A and B. A has enough space to accommodate B, but basically keeping
        A as sorted. Lets do two arrays first, and  cracking the coding ... question a1 has enough space.
     */
    // with creating new array when a1 has enough space to accommodate a2
    int[] mergeTwoSortedArrays(int[] a1, int[] a2){
        int a1LastElementPointer = a1.length-1 ;
        while (a1[a1LastElementPointer]==0 ){
            a1LastElementPointer--;
        }
        int a2LastElementPointer = a2.length-1 ;
        while (a2[a2LastElementPointer]!=0 ){
            a2LastElementPointer--;
        }
        for (int storagePointer =a1.length-1;storagePointer>=0; storagePointer--){

            if (a1LastElementPointer>-1 && a1[a1LastElementPointer]>a2[a2LastElementPointer]){
                a1[storagePointer]= a1[a1LastElementPointer];
                a1LastElementPointer--;
            }else {
                a1[storagePointer]= a2[a2LastElementPointer];
                a2LastElementPointer--;
            }
        }
        return a1;
    }


    public static List<Integer> mergeSortedLists(List<Integer> l1, List<Integer>l2) {
        List<Integer> l3= new ArrayList<>();
        int i =0, j =0 , l1Large=l1.size()-1, l2Large = l2.size()-1;

        for (; i <l1.size() && j< l2.size();){
            if (l1.get(i) > l2.get(j)){
                l3.add(l2.get(j));
                j++;

            }else{
                l3.add(l1.get(i));
                i++;
            }
        }
        while (i<=l1Large){
            l3.add(l1.get(i));
            i++;
        }
        while (j<=l2Large){
            l3.add(l2.get(j));
            j++;
        }
        return l3;
    }
    //solution is not so good , because first time we traversed two arrays and merged to one in O(n)
    // in second loop , we again going to all newly created array elements , which are basically above one
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // Write your code here.
        List<Integer> mergedList = null;
        Iterator<List<Integer>> it = arrays.iterator();
        while (it.hasNext()){
            if (mergedList==null){
                mergedList= mergeSortedLists(it.next(), it.next());
            }else {
                mergedList= mergeSortedLists(mergedList, it.next());
            }
        }
        if (mergedList!=null) return mergedList;
        return new ArrayList<>();
    }


    // better solution could be .. merge all element and run arrays.sort()
    public static List<Integer> mergeSortedArraysSolution2(List<List<Integer>> arrays) {
        List<Integer> mer= new ArrayList<>();
        for (List<Integer> a:
                arrays) {
            mer.addAll(a);
        }
        Collections.sort(mer);
        return mer;
    }

    // Algo expert solution 3
    @Data@AllArgsConstructor
    static class Item{
        Integer index;
        Integer data;
    }
    public static List<Integer> mergeSortedArraysSolution3(List<List<Integer>> arrays) {
        List<Integer> sortedList = new ArrayList<>();
        // basically this will track index of array in list. 0th list will be tracked at arrayIdxList.getIndex(0).
        List<Integer> listsIndex = new ArrayList<>(Collections.nCopies(arrays.size(), 0));

        // basically comparing 0th element of every list
        while (true) {
            List<Item> smallestElement  = new ArrayList<>();
            // first time only 0th values of every array will be stored
            for (int arrayIndex = 0; arrayIndex < arrays.size(); arrayIndex++) {
                List<Integer> listFromArray = arrays.get(arrayIndex);
                Integer indexValueForTheList = listsIndex.get(arrayIndex);
                if (indexValueForTheList==listFromArray.size()) continue;
                Integer elementAtIndex = listFromArray.get(indexValueForTheList);
                smallestElement.add(new Item(arrayIndex, elementAtIndex));
            }
            // out of loop index incremented on for the array for which smallest value is calculated
            // find Minimum value
            if (smallestElement.size()==0) {
                break;
            }
            Item s= getMinimumItem(smallestElement);
            sortedList.add(s.data);
            System.out.println(s.getIndex());
            listsIndex.set(s.getIndex(), listsIndex.get(s.getIndex())+1);
            // and than increment the arrayIndex for that array.
        }
        return sortedList;
    }
    static Item getMinimumItem(List<Item> ls){
        int pointer =0;
        for (int i =1; i <ls.size(); i++){
            if (ls.get(pointer).data > ls.get(i).data) pointer= i;
        }
        return ls.get(pointer);
    }

//     Solution 4 Algo Expert using MaxMin Heap ... lets doo Min Heap Question
    public static List<Integer> mergeSortedArraysSolution4(List<List<Integer>> arrays) {
        List<Integer> sortedList = new ArrayList<>();
        List<ItemMinHeap> smallest = new ArrayList<>();
        for (int arrayIdx = 0; arrayIdx <arrays.size(); arrayIdx++){
            smallest.add(new ItemMinHeap(arrayIdx, 0,arrays.get(arrayIdx).get(0) ) );
        }
        MinHeap m= new MinHeap(smallest);
        while (!m.heap.isEmpty()){
            ItemMinHeap smallestItem = m.remove();
            sortedList.add(smallestItem.data);
            if (smallestItem.elementIdx== arrays.get(smallestItem.arrayIdx).size()-1) continue;
            m.insert(
                    new ItemMinHeap(smallestItem.getArrayIdx(),
                            smallestItem.getElementIdx()+1,
                            arrays.get(smallestItem.getArrayIdx()).get(smallestItem.getElementIdx()+1))
            );
        }
        return sortedList;
    }
    @Data@AllArgsConstructor
    static class ItemMinHeap{
        Integer arrayIdx;
        Integer elementIdx;
        Integer data;
    }
    static class MinHeap{
        List<ItemMinHeap> heap =new ArrayList<>();
        MinHeap(List<ItemMinHeap> array){
           heap = buildHeap(array);
        }
        List<ItemMinHeap> buildHeap(List<ItemMinHeap> list){
            int firstParentIdx = (list.size()-2)/2;
            for (int currentIdx = firstParentIdx; currentIdx>=0; currentIdx--){
                siftDown(list, currentIdx, list.size()-1);
            }
            return list;
        }

        void siftDown(List<ItemMinHeap> list, int currentIdx, int endIdx){
            int childOneIdx = (2 * currentIdx)+1;
            while (childOneIdx <= endIdx){
                int childTwoIdx = (2 * currentIdx)+2 <= endIdx ? (2 * currentIdx)+2 : -1;
                int swapIdx;
                if (childTwoIdx!=-1 && list.get(childTwoIdx).data < list.get(childOneIdx).data){
                    swapIdx= childTwoIdx;
                }else {
                    swapIdx= childOneIdx;
                }
                if (list.get(swapIdx).data < list.get(currentIdx).data){
                    swap(list, swapIdx, currentIdx);
                    currentIdx=  childOneIdx;
                    childOneIdx= (2 * currentIdx)+1;
                }else {
                    return;
                }
            }
        }

        void swap(List<ItemMinHeap> list , int idx1, int idx2){
            ItemMinHeap temp = list.get(idx1);
            list.set(idx1, list.get(idx2));
            list.set(idx2, temp);
        }

        void siftUp(List<ItemMinHeap> list, int currentIdx){
            int parentIdx = (currentIdx-1)/2 ;
            while (currentIdx >0 && (list.get(currentIdx).data < list.get(parentIdx).data)){
                swap(list, parentIdx, currentIdx);
                currentIdx= parentIdx;
                parentIdx= (currentIdx-1)/2 ;
            }
        }
        void insert(ItemMinHeap item){
            heap.add(item);
            siftUp(heap, heap.size()-1);
        }

       public ItemMinHeap remove(){
            swap(heap, 0, heap.size()-1);
            ItemMinHeap minItem = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            siftDown(heap,0,heap.size()-1);
            return minItem;
        }
    }


    public static void main(String[] args) {
        SortedMerge s = new SortedMerge();
        //System.out.println(Arrays.toString(s.mergeTwoSortedArrays(new int[]{1,5,9,21,0,0}, new int[]{-1,0})));
        List<List<Integer>> lists = Arrays.asList( Arrays.asList(7,8,9), Arrays.asList(4,5,6),Arrays.asList(1,2,3));
        //System.out.println( s.mergeSortedArrays(lists);

        //List<Integer> list= new ArrayList<>(Collections.nCopies(lists.size(),0));
        //System.out.println(s.mergeSortedArraysSolution3(lists));
        System.out.println(s.mergeSortedArraysSolution4(lists));
    }
}



























