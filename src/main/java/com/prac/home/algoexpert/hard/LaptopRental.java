package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class LaptopRental {

    public static void main(String[] args) {
        LaptopRental l = new LaptopRental();
        ArrayList<ArrayList<Integer>> list = l.prepData();

        System.out.println(l.laptopRentals(list));
    }
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        if (times.size()==0){
            return -1;
        }
        Collections.sort(times, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(times.get(0));
        int laptop=1;
        MinHeapLR m = new MinHeapLR(list);
        ArrayList<ArrayList<Integer>> heap = m.heap;

        for (int i=1; i < times.size();i++){
            if (times.get(i).get(0) < m.peek().get(1)) {
                m.insert(times.get(i));
                laptop++;
            }else {
                m.remove();
                m.insert(times.get(i));
            }
        }
        return laptop;
    }
    static class MinHeapLR{
        ArrayList<ArrayList<Integer>> heap ;

        MinHeapLR(ArrayList<ArrayList<Integer>> array){
            heap= buildHeap(array);
        }

        ArrayList<ArrayList<Integer>> buildHeap(ArrayList<ArrayList<Integer>> array){
            int firstParent = (array.size()-2)/2;
            for (int currentIdx =firstParent; currentIdx>=0; currentIdx-- ){
                siftDown(currentIdx, array);
            }
            return array;
        }

        void siftDown(int currentIdx, ArrayList<ArrayList<Integer>> array){
            int child1Idx = (2*currentIdx)+1;
            while (child1Idx< array.size()){
                int child2Idx = (2*currentIdx)+2< array.size()? (2*currentIdx)+2:-1;

                int swapIdx ;
                if (child2Idx!=-1 && array.get(child2Idx).get(1)< array.get(child1Idx).get(1)){
                    swapIdx= child2Idx;
                }else {
                    swapIdx= child1Idx;
                }
                if (array.get(currentIdx).get(1)> array.get(swapIdx).get(1)){
                    swap(currentIdx, swapIdx, array);
                    currentIdx= swapIdx;
                    child1Idx= (2*currentIdx)+1;
                }else {
                    return;
                }
            }
        }
        public void siftUp(int childIdx, ArrayList<ArrayList<Integer>> array){
            int parentIdx = (childIdx-2)/2;
            while (parentIdx>=0 && array.get(parentIdx).get(1) > array.get(childIdx).get(1)){
                swap(parentIdx, childIdx,array);
                childIdx= parentIdx;
                parentIdx= (childIdx-2)/2;
            }
        }

        public List<Integer> peek(){
           return heap.get(0);
        }

        public void insert(ArrayList<Integer> element){
            heap.add(element);
            siftUp(heap.size()-1, heap);
        }

        public List<Integer> remove(){
            swap(0, heap.size()-1, heap);
            List<Integer> element = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            siftDown(0, heap);
            return element;
        }

        public void swap(int idx1, int idx2, ArrayList<ArrayList<Integer>> array){
            ArrayList<Integer> temp = array.get(idx1);
            array.set(idx1, array.get(idx2));
            array.set(idx2, temp);
        }
    }



    public ArrayList<ArrayList<Integer>> prepData(){
        ArrayList<ArrayList<Integer>> list =new ArrayList<>();
        ArrayList<Integer> l1= new ArrayList<>();
        l1.add(0);
        l1.add(2);
        list.add(l1);

        ArrayList<Integer> l2= new ArrayList<>();
        l2.add(1);
        l2.add(4);
        list.add(l2);

        ArrayList<Integer> l3= new ArrayList<>();
        l3.add(4);
        l3.add(6);
        list.add(l3);

        ArrayList<Integer> l4= new ArrayList<>();
        l4.add(0);
        l4.add(4);
        list.add(l4);

        ArrayList<Integer> l5= new ArrayList<>();
        l5.add(7);
        l5.add(8);
        list.add(l5);

        ArrayList<Integer> l6= new ArrayList<>();
        l6.add(9);
        l6.add(11);
        list.add(l6);

        ArrayList<Integer> l7= new ArrayList<>();
        l7.add(3);
        l7.add(10);
        list.add(l7);

        return list;
    }
}
