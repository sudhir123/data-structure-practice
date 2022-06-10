package com.prac.home.practice.algoexpert;

import java.util.Arrays;

public class MinimumNumberOfCoinsForChange {
    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(7, new int[]{1,5,10}));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[][]dp = new int[denoms.length+1][n+1];

        for (int row=1; row< dp.length; row++){
            int coin = denoms[row-1];
            for (int amount=1 ; amount< dp[0].length; amount++){
                if (coin<= amount){
                    if (coin==1){
                        dp[row][amount]= amount/coin;
                    }else {
                        dp[row][amount]= 1 + (dp[row][amount-coin]);
                    }
                }else {
                    dp[row][amount]= dp[row-1][amount];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
