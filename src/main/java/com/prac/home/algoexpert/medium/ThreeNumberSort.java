package com.prac.home.algoexpert.medium;

/**
 * given two arrays ...one containing few elements in any random order and are not distinct. Another array of distinct integers from first.
 * sort the first array as per second order.
 */
public class ThreeNumberSort {
    // first solution
    // this is called bucket sort, map kinda structure we maintain and store all count for that value. but  this will take
    ///a dditional DS and more passes. so thsi ssolution will work using the same array as bucket.
    /*public int[] threeNumberSort(int[] array, int[] order) {

        int idxOrder=0; int idxBucket=0;
        // first pass
        for (int i =0; i < array.length; i ++){

            if (array[i]== order[idxOrder]){
                int temp =  array[idxBucket];
                array[idxBucket] = array[i];
                array[i]= temp;
                idxBucket++;
            }
        }
        // second Pass
        idxBucket=array.length-1; idxOrder= order.length-1;
        for (int i =array.length-1; i>=0; i --){

            if (array[i]== order[idxOrder]){
                int temp =  array[idxBucket];
                array[idxBucket] = array[i];
                array[i]= temp;
                idxBucket--;
            }
        }
        return array;
    }*/


    // socond solution to do all this in single pass. by maintaint three pointers not first, second and third.
    // we will traverse the loop as usal and increments our pointer based on the order array

    static public int[] threeNumberSort(int[] array, int[] order) {
         int firstValue = order[0];
         int secondValue = order[1];

         int firstIdx=0, secondIdx=0, thirdIdx =array.length-1;

         while (secondIdx<= thirdIdx){
             int value = array[secondIdx];

             if (value==firstValue){
                 swap(array,firstIdx,secondIdx);
                 firstIdx+=1;
                 secondIdx+=1;
             }else if (value==secondValue){
                 secondIdx+=1;
             }else {
                 swap(array,secondIdx,thirdIdx);
                 thirdIdx-=1;
             }
         }
        return array;
    }

    static void swap(int[] array, int idx1, int idx2){
        int temp =  array[idx1];
        array[idx1] = array[idx2];
        array[idx2]= temp;
    }

    public static void main(String[] args) {
        threeNumberSort(new int []{1, 1, 0, -1, -1, 0, 1, 1} , new int[]{0,1,-1});
    }
}
