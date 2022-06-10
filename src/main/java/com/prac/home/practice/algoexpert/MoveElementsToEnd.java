package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementsToEnd {
    public static void main(String[] args) {
        System.out.println(moveElementToEnd(Arrays.asList(3, 1, 2, 4, 5), 3));
    }
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left=0; int right =array.size()-1;
        while (left<right){
            if (array.get(right)==toMove ){
                right--;
            }else if (array.get(left)==toMove && array.get(right)!=toMove){
                swap(array, left, right);
                left++; right--;
            }else {
                left++;
            }
        }
        return array;
    }
    static void swap(List<Integer>  arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);

    }
}
