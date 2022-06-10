package com.prac.home.algoexpert.easy;

import java.util.List;

/**
 * if array 2 is subsequence is first. O(n). Keeping one pointer fixed and moving another on bigger array.
 * retrun false if bigger array ends first.
 */
public class ValidateSubSequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int i =0, j=0;
        while (i< array.size() && j <sequence.size()){
            if (array.get(i)==sequence.get(j)){
                i++; j++;
            }else {
                i++;
            }
        }
        if (j==sequence.size()){
            return true;
        }
        return false;
    }
}
