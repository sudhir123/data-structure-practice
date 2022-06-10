package com.prac.home.practice.slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// find maximum in each window
public class SlidingWindowMaximumValueForThatWindow {
    public static void main(String[] args) {
        SlidingWindowMaximumValueForThatWindow s = new SlidingWindowMaximumValueForThatWindow();
        System.out.println(Arrays.toString(s.maxSlidingWindowDeque(new int[]{1,3,1,2,0,5}, 3)));
    }

    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        int[]dp=new int[nums.length-k+1];
        Deque<Integer> dq= new LinkedList<>();
        for (int left=0, right=0; right< nums.length; ){
            if (right-left+1< k){
                while (!dq.isEmpty() && nums[right]>= nums[dq.peekLast()] ){
                    dq.removeLast();
                }
                dq.addLast(right);
                right++;
            }else {

                while (!dq.isEmpty() && right-k >=dq.peek()){
                    dq.removeFirst();
                }
                while (!dq.isEmpty() && nums[right]>= nums[dq.peekLast()] ){
                    dq.removeLast();
                }
                dq.addLast(right);
                dp[right-k+1]= nums[dq.peek()];
                left++; right++;
            }
        }
        return dp;
    }
}
