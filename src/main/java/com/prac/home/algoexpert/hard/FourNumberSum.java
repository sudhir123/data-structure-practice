package com.prac.home.algoexpert.hard;

import java.util.*;
/**
 * #Array
 */
public class FourNumberSum {
    public static void main(String[] args) {
        fourNumberSum(new int[]{7, 6, 4, -1, 1, 2}, 16 );
    }
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
   // better way is make sum as two number sum p and q , which actually internally p is sum of a and b ... so does q is c and d
        // map's key is P (sum of a and b ). there is a catch to save sum.
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        List<Integer[]> list= new ArrayList<>();

        for (int i=1; i< array.length-1 ; i ++){

            for (int j=i+1; j<array.length; j++){
                int currentSum = array[i]+ array[j]; // p
                int difference = targetSum- currentSum; // q
                if (map.get(difference)!=null){
                    for (Integer[] pair: map.get(difference)
                         ) {
                        Integer[] quad = new Integer[]{pair[0], pair[1], array[i], array[j]};
                        list.add(quad);
                    }

                }
            }
            for (int k =0; k <i; k++){
                int currentSum = array[k]+ array[i];
                Integer[]pair = new Integer[]{array[k], array[i]};
                if (!map.containsKey(currentSum)){
                    List<Integer[]> listOfPairs= new ArrayList<>();
                    listOfPairs.add(pair);
                    map.put(currentSum, listOfPairs);
                }else {
                    List<Integer[]> listOfPairs = map.get(currentSum);
                    listOfPairs.add(pair);
                }
            }
        }
        return list;
    }
    //worst way
        /*List<Integer[]> list= new ArrayList<>();
        Arrays.sort(array);  // nlogn
        for (int i =0; i < array.length; i++){
            findThreeNumberSum(array, targetSum- array[i],i , list);
        }

        return list;*/
    static void findThreeNumberSum( int[] array, int newTargetSum, int firstIdx, List<Integer[]> list){
        for (int secondIdx = firstIdx+1; secondIdx< array.length; secondIdx++ ){

            int leftIdx = secondIdx+1;
            int rightIdx = array.length-1;
            while (leftIdx< rightIdx){
                int sum = array[secondIdx] + array[leftIdx]+ array[rightIdx];
                if (sum==newTargetSum){
                    list.add(new Integer[]{array[firstIdx], array[secondIdx], array[leftIdx], array[rightIdx]});
                    leftIdx++;
                }else if (sum < newTargetSum){
                    leftIdx++;
                }else {
                    rightIdx--;
                }

            }
        }
    }
}

/*
int left=j+1;
                int right = array.length-1;

                while (left<right){
                    int lftNum= array[left];
                    int rightNum = array[right];

                    int sum = array[i] + array[j] + lftNum +rightNum;
                    if (sum == targetSum){
                        list.add(new Integer[]{array[i], array[j], lftNum, rightNum});
                        left++;
                        //right--;
                    }else if (sum < targetSum){
                        left++;
                    }else {
                        right--;
                    }
                }
 */