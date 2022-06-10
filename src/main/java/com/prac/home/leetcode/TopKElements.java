package com.prac.home.leetcode;

import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        TopKElements t = new TopKElements();
        System.out.println(Arrays.toString(t.topKFrequent(new int[]{5,2,5,3,5,3,1,1,3}, 2)));
    }

    // concept shared is heap and sort
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums); // nlogn
        Map<Integer,Integer> uniqueElementsMap = new HashMap<>();// we will insert after removing from min heap
        int[] result = new int[k];// with this we don't need to traverse map at the end one more time.
        // rest is MINHEAP
        for (int i=0; i< nums.length; i++){
            if (uniqueElementsMap.containsKey(nums[i])){
                uniqueElementsMap.put(nums[i], uniqueElementsMap.get(nums[i])+1);
            }else {
                uniqueElementsMap.put(nums[i], 1);
            }
        }
        List<Record> list= new ArrayList<>();
        for (Integer key: uniqueElementsMap.keySet()
        ) {
            list.add(new Record(key, uniqueElementsMap.get(key)));
        }
        MinHeap m = new MinHeap(list);
        for (int i=0; i<k; i++){
            result[i]= m.remove().num;
        }
        return result;
    }

    static class Record{
        int num;
        int count;
        Record(int num, int count){
            this.num= num;
            this.count= count;
        }
    }
    // we need to use min for count.
    static class  MinHeap{
        List<Record> list;
        MinHeap(List<Record> array){
            list= constructMinHeap(array);
        }

        public List<Record> constructMinHeap(List<Record> array){
            int firstParentIdx = (array.size()-1)/2;
            for (int  parentIdx=firstParentIdx ; parentIdx>=0; parentIdx--){
                siftDown(array, parentIdx);
            }
            return array;
        }
        private void swap(List<Record> array, int idx1, int idx2){
            Record temp = array.get(idx2);
            array.set(idx2, array.get(idx1));
            array.set(idx1, temp);
        }
        private void siftDown(List<Record> array, int parentIdx){
            int childOneIdx = (2*parentIdx)+1;
            while (childOneIdx< array.size()){
                int childTwoIdx= (2*parentIdx)+2< array.size()? (2*parentIdx)+2: -1;
                int swapIdx;
                if (childTwoIdx!=-1 && array.get(childTwoIdx).count> array.get(childOneIdx).count){
                    swapIdx= childTwoIdx;
                }else {
                    swapIdx= childOneIdx;
                }

                if (array.get(parentIdx).count < array.get(swapIdx).count){
                    swap(array, swapIdx, parentIdx);
                    parentIdx= swapIdx;
                    childOneIdx= (2*parentIdx)+1;
                }else {
                    break;
                }
            }
        }

        public Record remove(){
            swap(list, 0, list.size()-1);
            Record min = list.remove(list.size()-1);
            siftDown(list, 0);
            return min;

        }
    }
}
