package com.prac.home.practice.algoexpert;

import java.util.List;

/**
 * same in leet code https://leetcode.com/problems/jump-game-ii/
 */

public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        MinimumNumberOfJumps m = new MinimumNumberOfJumps();
        System.out.println(m.jump(new int[]{3,4, 2, 1 , 5, 3, 7, 1, 1, 1, 3}));
    }
    // leetcode.. my thinking to implement the maxheap.. no use, that will end up n^2
    // best is via dp, where can find at any point what is the maximum reach we can do at that point.
    // steps is a variable which tell yes a point now we have to jump ... that point we go to maxReach point.
    public int jump(int[] nums) {
        int jumps=0;
        int maxReach =nums[0];
        int steps =nums[0];
        for (int i=1; i<nums.length; i++){
            maxReach= Math.max(maxReach, nums[i]+i);
            steps--;
            if (steps==0){
                steps= maxReach-i;
                jumps++;
            }
        }
        return jumps+1;
    }
    // max heap work good with list
}
