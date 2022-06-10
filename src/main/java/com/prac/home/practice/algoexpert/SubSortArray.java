package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SubSortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
    }
    public static int[] subarraySort(int[] array) {
        List<Integer> unsortedIdx=new ArrayList<>();
        for (int i=0; i<array.length; i++){
            if (i>0 && i< array.length-1 && (array[i-1]> array[i] || array[i]> array[i+1])){
                unsortedIdx.add(array[i]);
            }
        }
        int maxNum=Integer.MIN_VALUE; int minNum= Integer.MAX_VALUE;
        for (int i=0; i<unsortedIdx.size(); i++){
            maxNum= Math.max(maxNum, unsortedIdx.get(i));
            minNum= Math.min(minNum, unsortedIdx.get(i));
        }
        int minIdx=-1; int maxIdx=-1;
        for (int i=0; i< array.length; i++){
            if (minNum<array[i]){
                minIdx= i;
                break;
            }
        }
        for (int i=array.length-1; i>0; i--){
            if (maxNum>array[i]){
                maxIdx= i;
                break;
            }
        }
        return new int[] {minIdx, maxIdx};
    }
}
