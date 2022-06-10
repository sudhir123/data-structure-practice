package com.prac.home.algoexpert.hard;

import java.util.Map;

/**
 * #Array
 * given a non empty set of integers and where each integer replresnts the number of steps you can take to move forward
 * lest say at index 1-> 3 ..u can take 3, 2,1  any number of steps ..goal is to reach end in minumum number of steps
 */
public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        System.out.println(minNumberOfJumps(new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3}));
    }

    public static int minNumberOfJumps(int[] array) {
        if (array.length<2) return 0;
        int steps= array[0];
        int maxReach = array[0];
        int jumps=0;
        for (int i = 1; i < array.length-1; i++) {

            maxReach= Math.max(maxReach, i+array[i]);
            steps--;
            if (steps==0){
                // its time to jump
                steps= maxReach-i;
                jumps++;
            }
        }
        return jumps+1;
    }
    // worst case n^2 time
    /*public static int minNumberOfJumps(int[] array) {
        int numberOfSteps=0;
        for (int i =0; i < array.length;){
            if (i >= array.length-1) return numberOfSteps;
            i= nextIdx(array,i, array[i]);
            numberOfSteps++;
        }

        return numberOfSteps;
    }

    static int nextIdx(int[] array, int currentIdx , int maxValueAtCurrentIdx){
        int maxIdx = currentIdx+ maxValueAtCurrentIdx ;
        if (maxIdx>= array.length-1) return array.length;
        int maxVal= array[maxIdx];
        int maxValIdx= maxIdx;
        while (maxIdx > currentIdx){
            int val= array[maxIdx];
            if (val> maxVal){
                maxVal= val;
                maxValIdx= maxIdx;
            }
            maxIdx--;
        }
        return maxValIdx;
    }*/

}
