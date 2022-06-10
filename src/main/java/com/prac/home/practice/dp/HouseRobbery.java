package com.prac.home.practice.dp;

// no adjacent robbery
public class HouseRobbery {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
    static int rob(int[] nums) {
        if (nums.length<2) return nums[0];
        if (nums.length==2){
            return Math.max(nums[0], nums[1]);
        }
        int[] result = new int[nums.length];
        result[0]= nums[0];
        result[1]= Math.max(result[0], nums[1]);
        for (int i=2; i< nums.length;i++){
            result[i]= Math.max((nums[i]+result[i-2]), result[i-1]);
        }
        return result[result.length-1];
    }
}
