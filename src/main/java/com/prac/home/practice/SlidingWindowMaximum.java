package com.prac.home.practice;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum s= new SlidingWindowMaximum();
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,-1}, 1)));

        //s.maxSlidingWindow(new int[]{1,-1 }, 1);
    }
    // dequeue
    public int[] maxSlidingWindow(int[] nums, int k) {
        //List<Integer> dp = new ArrayList<>();
        int[] dp = new int[nums.length-k+1];
        Deque<Integer> deque= new LinkedList<>();

        int i;
        for (i=0; i<k ; i++){

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.removeLast();
            }

            deque.addLast(i);
        }
        for (; i< nums.length; i++){
            //dp.add(nums[deque.peek()]);
            dp[i-k]= nums[deque.peek()];
            //System.out.println(nums[deque.peek()]);

            while (!deque.isEmpty() && deque.peek() <= i-k){
                deque.removeFirst();
            }

            while ((!deque.isEmpty()) && nums[i] >=
                    nums[deque.peekLast()]){
                deque.removeLast();
            }

            deque.addLast(i);
        }
        dp[dp.length-1]= nums[deque.peek()];
        /*dp.add(nums[deque.peek()]);
        System.out.println(nums[deque.peek()]);
        int[] arr= new int[dp.size()];
        for (int j=0; j< dp.size(); j++){
            arr[j]= dp.get(j);
        }
        return arr;*/
        return dp;
    }
    // best approach is keep k elements in MaxHeap. Add new remove Max ...automatically sorted ...

    // another approach is Queue and DeQueue. lets try those. Not understood completely. Lets do with MaxHeap.
    // maxheap is not working as per my expectation to trying with dqueue
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        // K elements in max heap. remove and add new .. remove and add new ... you will be ahving
        // max k elements in heap and get max out of those.
        int[] dp = new int[nums.length-k+1];
        List<Node> list = new ArrayList<>();
        for (int idx =0; idx< k; idx++){
            list.add(new Node(nums[idx],idx) );
        }
        MaxHeap m = new MaxHeap(list);
        int  dpIdx=0;
        for (int i=k; i<nums.length; i++, dpIdx++){
            dp[dpIdx]= m.peek().value;
            m.insert(nums[i],i);
            if ((i-k)> m.peek().idx  || m.peek().idx> i){
                m.remove();
            }
        }
        dp[dpIdx]= m.peek().value;
        return dp;
    }*/

    static class Node{
        Integer value;
        Integer idx;
        Node(Integer value ,Integer idx){
            this.value= value;
            this.idx= idx;
        }
    }

    static class  MaxHeap {
        public List<Node> heap ;
        MaxHeap(List<Node> array){
            heap= buildHeap(array);
        }
        List<Node> buildHeap(List<Node> array){
            int firstIdx = (array.size()-1)/2;
            for (int firstParentIdx =firstIdx; firstParentIdx>=0; firstParentIdx--){
                siftDown(array, firstParentIdx);
            }
            return array;
        }

        void siftDown(List<Node> array, int parentIdx){
            int childOneIdx = (2*parentIdx)+1;
            while (childOneIdx< array.size()){
                int childTwoIdx = (2*array.size())+2 < array.size()? (2*array.size())+2:-1;
                int swapIdx;
                if (childTwoIdx!=-1 && array.get(childTwoIdx).value> array.get(childOneIdx).value){
                    swapIdx= childTwoIdx;
                }else {
                    swapIdx= childOneIdx;
                }
                if (array.get(parentIdx).value< array.get(swapIdx).value){
                    swap(parentIdx, swapIdx, array);
                    parentIdx= swapIdx;
                    childOneIdx= (2*array.size())+1;
                }else {
                    break;
                }
            }
        }

        void siftUp(List<Node> array, int currentIdx){
            int parentIdx = (currentIdx-1)/2;
            while (parentIdx>=0 && array.get(parentIdx).value< array.get(currentIdx).value){
                swap(parentIdx, currentIdx, array);
                currentIdx= parentIdx;
                parentIdx= (currentIdx-1)/2;;
            }
        }

        void swap(int i, int j, List<Node> array){
            Node temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
        void insert(Integer num, Integer idx){
            heap.add(new Node(num, idx));
            siftUp(heap, heap.size()-1);
        }

        Node peek(){
            return heap.get(0);
        }

        Node remove(){
            swap(0, heap.size()-1, heap);
            Node max = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            siftDown(heap, 0);
            return max;
        }
    }




    // this solution is proof ...as example 7,2,4 -->2 --> first it will be 7,2 and then 2,4 answer is 7,4
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        int[] dp =new int[(nums.length-(k-1))];
        dp[0] = getMaxFromFirstKElements(nums, k);
        for (int i=k, j=1; i<nums.length; i++, j++){
            if (k>1){
                dp[j]= Math.max(dp[j-1], nums[i]);
            }else {
                dp[j]= nums[i];
            }
        }
        return dp;
    }
    int getMaxFromFirstKElements(int[] nums , int k){
        int max= Integer.MIN_VALUE;
        for (int i=0; i< k; i++){
            max= Math.max(max, nums[i]);
        }
        return max;
    }*/
}
