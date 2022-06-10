package com.prac.home.algoexpert.medium;

import java.util.Arrays;
import java.util.List;

/**
 * given an array and single number. Move all the occurrences of that number at the end in the array.
 * [12,3,4,5,2,2,6,7,,78,8,]  2--> [12,3,4,5,6,7,78,8, 2,2]
 */
public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int endIdx= array.size()-1;
        System.out.println(array.size()-1);
        for (int i =0; i<=endIdx; i++){
            while (endIdx>-1 && array.get(endIdx)==toMove ){
                endIdx--;
            }
            if (array.get(i)==toMove && i <= endIdx){
                swap(array, i, endIdx);
                endIdx--;
            }
        }
        return array;
    }
    static void swap(List<Integer> array, int index, int endIdx){
        int temp = array.get(index);
        array.set(index, array.get(endIdx));
        array.set(endIdx, temp);
    }

    public static void main(String[] args) {
        System.out.println(moveElementToEnd(Arrays.asList( 2,1,2,2,2,3,4,2), 2));
    }
}
// 2,1,2,2,2,3,4,2
// 4,1,3,2,2,2,2,2