package com.prac.home.algoexpert.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *function to return the first duplicate value. I/p is an array of integers from 1 to n, and n the length of array.
 * return duplicate from left to right, which means 2,3,3,2  answer will be 3 not 2
 * Best trick part of this question is the statement if array has length of n that means array can not have element more than n
 * which mean lest say n =5 that means it can have 4,4,4,2,3 cannot have 6
 */
public class FirstDuplicateValue {
    // i think similar one we have done for string in firstRepeatingChar Index. We uses hashmap
    // this is O(n) time and space. as we need to store n values in set or map
    /*static public int firstDuplicateValue(int[] array) {
        Map<Integer, Integer> map= new HashMap<>();
        for (int i =0; i <array.length; i ++){
            if (map.get(array[i])!=null && (map.get(array[i])+1)>1){
                return array[i];
            }else {
                map.put(array[i],1);
            }
        }
        return -1;
    }*/
    // O(n) time and O(1) space
    // awsome ...
    static public int firstDuplicateValue(int[] array) {
        for (int value :array
             ) {
            int absValue = Math.abs(value);
            if (array[absValue-1]<0) return absValue;
            array[absValue-1] *=-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(firstDuplicateValue(new int[]{2, 1, 5, 3, 3, 2, 4}));
    }
}

















