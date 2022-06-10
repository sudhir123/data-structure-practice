package com.prac.home.practice.algoexpert;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i,
 * you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * Notice that you can not jump outside of the array at any time.
 * Example 1:
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 */
// in this example we just need to check if from start idx can we to any idx with value as 0  in array. Moving to and fro.
public class MinimumNumberOfJumpsIII {
    public static void main(String[] args) {
        MinimumNumberOfJumpsIII m = new MinimumNumberOfJumpsIII();
        System.out.println(m.jump(new int[]{4,2,3,0,3,1,2}, 5));
    }
    // leetcode.. my thinking to implement the maxheap.. no use, that will end up n^2
    // best is via dp, where can find at any point what is the maximum reach we can do at that point.
    // steps is a variable which tell yes a point now we have to jump ... that point we go to maxReach point.
    public boolean jump(int[] arr, int start) {
        return jumpFwd(arr, start)||jumpBack(arr, start);
    }
    public boolean jumpFwd(int[] arr, int start) {
        for (int i=start; i< arr.length;){
            if ((arr[i]+i)< arr.length && (arr[arr[i]+i])==0){
                return true;
            }
            i=arr[i]+i;
        }
        return false;
    }
    public boolean jumpBack(int[] arr, int start) {
        for (int i=start; i> 0; ){
            if ((i-arr[i])>0 && (arr[i-arr[i]])==0){
                return true;
            }
            i=i-arr[i];
        }
        return false;
    }
}
