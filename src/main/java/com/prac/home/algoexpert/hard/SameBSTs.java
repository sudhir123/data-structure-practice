package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * function to take two array lists, with return boolean, if list are for the same BST. BST where each node is smaller then right and
 * greater then each left node.
 */
public class SameBSTs {
    public static void main(String[] args) {
        System.out.println(sameBsts(
                Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, -1, 100, 45, 12, 9, -1, 8, 2, -34),
                Arrays.asList(10, 8, 5, 15, 2, 12, 94, 81, -1, -1, -34, 8, 2, 9, 12, 45, 100)));
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

        return orderHelper(arrayOne, arrayTwo);
    }
    static boolean orderHelper(List<Integer> arrayOne,  List<Integer> arrayTwo){
        if (arrayOne.size()!=arrayTwo.size()) return false;
        if (arrayOne.size()==0 && arrayTwo.size()==0) return true;
        if (arrayOne.get(0)!= arrayTwo.get(0)) return false;

        List<Integer> arrayOneLeft= smallerNumberArray(arrayOne, arrayOne.get(0) );
        List<Integer> arrayTwoLeft= smallerNumberArray(arrayTwo, arrayTwo.get(0) );

        List<Integer> arrayOneRight= largeNumberArray(arrayOne, arrayOne.get(0) );
        List<Integer> arrayTwoRight= largeNumberArray(arrayTwo, arrayTwo.get(0) );
       return orderHelper(arrayOneLeft,arrayTwoLeft)  && orderHelper(arrayOneRight, arrayTwoRight);

    }
    static List<Integer> smallerNumberArray(List<Integer> array, int num){
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<array.size(); i++){
            if (array.get(i)< num){
                list.add(array.get(i));
            }
        }
        return list;
    }
    static List<Integer> largeNumberArray(List<Integer> array, int num){
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<array.size(); i++){
            if (array.get(i)>= num){
                list.add(array.get(i));
            }
        }
        return list;
    }

}
