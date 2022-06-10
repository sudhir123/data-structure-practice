package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Radix sort is algorithm , internally uses counting sort, which is linear time complexity algo, but linear time complexity with some conditions.
 * lets say we have single digits in an array and very long array, definetly linear time complexity. but if we have 10 elements
 * and one is 1 and another is 100000000 then worst than any existing algos such as merge , heap , quick which gives you nlogn
 * how radix works is , we have basically we use ones digit to sort , then in another iteration, 10's digit to sort, so on till the max
 * integer we have in array.
 */
public class RadixSort {
    public static void main(String[] args) {
        RadixSort r= new RadixSort();
        ArrayList<Integer> array = new ArrayList<>();
        array.add(8762);
        array.add(654);
        array.add(3008);
        array.add(345);
        array.add(87);
        array.add(65);
        array.add(234);
        array.add(12);
        array.add(2);
        System.out.println(r.radixSort(array));
    }
    public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        // step 1) declare countsArray , which is defining the system we are using to count. 0-9 digit system.
        // another is sorted array of same length as of original array

        // calculate max digit integer in the array
        if (array.size()==0){
            return array;
        }
        int maxNumber = Collections.max(array);
        int digit=0;
        while ((maxNumber/Math.pow(10, digit))>0){
            countingSort(array, digit);
            digit += 1;
        }

        return array;
    }

    public void countingSort(ArrayList<Integer> array, int digit){
        int[] countArray = new int[10];
        int[] sortedArray = new int[array.size()];

        int digitColumn= (int)Math.pow(10, digit);
        for (Integer num: array
             ) {
            int counterIdx = (num/digitColumn)%10;
            countArray[counterIdx]+=1;
        }

        for (int idx = 1; idx<countArray.length; idx++){
            countArray[idx]+= countArray[idx-1];
        }

        for (int idx= array.size()-1; idx>=0 ; idx--){
            int counterIdx = (array.get(idx)/digitColumn)%10;
            countArray[counterIdx]-=1;
            int sortedIndex = countArray[counterIdx];
            sortedArray[sortedIndex]=array.get(idx);
        }

        for (int idx=0; idx<array.size(); idx++){
            array.set(idx, sortedArray[idx]);
        }
    }


}






































