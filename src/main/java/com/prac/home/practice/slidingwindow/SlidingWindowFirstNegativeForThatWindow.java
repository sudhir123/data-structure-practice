package com.prac.home.practice.slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// find maximum in each window
public class SlidingWindowFirstNegativeForThatWindow {
    public static void main(String[] args) {
        SlidingWindowFirstNegativeForThatWindow s = new SlidingWindowFirstNegativeForThatWindow();
        System.out.println(Arrays.toString(s.firstNegativeSlidingWindowDeque(new int[]{1,-3,-1, 1,-2,-9,5}, 3)));
    }

    public int[] firstNegativeSlidingWindowDeque(int[] nums, int k) {
        int[]dp=new int[nums.length-k+1];
        Deque<Integer> dq= new LinkedList<>();
        for (int left=0, right=0; right< nums.length; ){
            if (right-left+1< k){
                if (nums[right]<0){
                    dq.addLast(right);
                }
                right++;
            }else{
                while (!dq.isEmpty() && right-k >=dq.peek()){
                    dq.removeFirst();
                }
                if (nums[right]<0){
                    dq.addLast(right);
                }
                if(right-k+1 >=0 && !dq.isEmpty()){
                    dp[right-k+1]= nums[dq.peek()];
                }
                left++; right++;
            }

        }
        return dp;
    }
}
