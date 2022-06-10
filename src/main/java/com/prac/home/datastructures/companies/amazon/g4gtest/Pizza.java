package com.prac.home.datastructures.companies.amazon.g4gtest;

public class Pizza {
    public static void main(String[] args) {
        System.out.println(maxPizza(5, new int[]{5,3,4,11,2}));
    }
    static int maxPizza(int n, int[] arr) {
        if (n<2){
            return arr[0];
        }
        int[] dp = new int[arr.length];
        dp[0]= arr[0];
        if (arr[1]> arr[0]){
            dp[1]=arr[1];
        }else {
            dp[1]=arr[0];
        }
        for (int i=2; i<arr.length; i++){
            if (arr[i]+dp[i-2]> dp[i-1]){
                dp[i]= arr[i]+dp[i-2];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
