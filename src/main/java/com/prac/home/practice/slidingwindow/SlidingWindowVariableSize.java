package com.prac.home.practice.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowVariableSize {
    public static void main(String[] args) {
        System.out.println(slidingWindow(new int[]{4,1,1,1,1,1,2,3},5));
    }
    static int slidingWindow(int[] arr, int targetSum){
        List<List<Integer>> result= new ArrayList<>();
        int left=0, right=0; int sum=0; int maxLength=0;
        while (right<arr.length){
            if (left==right ){
                if (targetSum==arr[right]){
                    result.add(new ArrayList<>(arr[right]));
                }else {
                    right++;
                }
            }else {
                sum+=arr[right];
                if(sum==targetSum){
                    maxLength= Math.max(maxLength, (right-left+1));
                    sum-=arr[left];
                    left++;
                }else if (sum<targetSum){
                    right++;
                }else {
                    sum-=arr[left];
                    left++;
                }
            }
        }

        return maxLength;
    }
}
