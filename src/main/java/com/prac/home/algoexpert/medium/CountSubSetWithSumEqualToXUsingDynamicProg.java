package com.prac.home.algoexpert.medium;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * #Array #DynamicProg
 * Count SubSet With Sum Equal To X Using DynamicProg [1,2,3,3] ==> [[1,2,3],  [1,2,3],  [3,3]]
 */
public class CountSubSetWithSumEqualToXUsingDynamicProg {
    public static void main(String[] args) {
        System.out.println(sumEqualToX(new int[]{1,2,3,3}, 6));
    }

    static List<List<Integer>> sumEqualToX(int[] array, int target){
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0 ; i < array.length; i++){
            findSubset(array, i,target ,result);
        }

        return result;
    }

    static void findSubset(int[] array, int currentIdx, int target, List<List<Integer>> result){
        List<Integer> subset = new ArrayList<>();
        int num = array[currentIdx];
        int i = currentIdx+1;
        int j = array.length-1;
        while (i <= j){
            int left= array[i];
            int right= array[j];
            int sum = num +left+right;

            if (sum==target){
                subset.add(num);
                subset.add(left);
                subset.add(right);
                result.add(subset);
                j--;
            }else if (sum < target){
                subset.add(left);
                i++;
            }else {
                j--;
            }
        }
    }


















}
