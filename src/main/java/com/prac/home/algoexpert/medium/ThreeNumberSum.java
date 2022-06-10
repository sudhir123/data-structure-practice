package com.prac.home.algoexpert.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Like two number now we have to find three number and return the triplet in order
 */
public class ThreeNumberSum {
    public static void main(String[] args) {
        List<Integer[]> list= threeNumberSum(new int[]{6, 4, -1, 1, 2}, 9);
        list.stream().forEach(x-> {
            System.out.println(Arrays.toString(x));
        });
    }
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> list= new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int leftIdx= i+1;
            int rightIdx = array.length-1;
            int num = array[i];
            while (leftIdx< rightIdx){
                int sum = num+ array[leftIdx]+ array[rightIdx];
                if (targetSum== sum){
                    list.add(new Integer[]{num,array[leftIdx] , array[rightIdx]});
                    leftIdx++;
                }else if (sum< targetSum){
                    leftIdx++;
                }else {
                    rightIdx--;
                }
            }
        }
        return list;
    }




    /*public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> list= new ArrayList<>();
        for (int i =0; i < array.length-2; i++){
            int current=array[i];
            int leftPointer= i+1;
            int rightPointer = array.length-1;

            while (leftPointer < rightPointer){
                int leftElement = array[leftPointer]; int rightElement = array[rightPointer];
                int currentSum = current+leftElement+rightElement;

                if (currentSum == targetSum){
                    list.add(new Integer[]{current, leftElement, rightElement});
                    leftPointer++; rightPointer--;
                }else if (currentSum<targetSum){
                    leftPointer++;
                }else {
                    rightPointer--;
                }
            }
        }
        return list;
    }*/


}























