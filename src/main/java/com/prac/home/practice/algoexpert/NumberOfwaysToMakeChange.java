package com.prac.home.practice.algoexpert;

public class NumberOfwaysToMakeChange {
    public static int numberOfWaysToMakeChange(int amount, int[] coins) {
        int[] dp =new int[amount+1];
        dp[0]=1;
        for (int coin: coins
             ) {
            for (int currAmount=1; currAmount<amount+1; currAmount++ ){
                if (coin <= currAmount){
                    dp[currAmount]= dp[currAmount]+ dp[currAmount-coin];
                }
            }
        }
        return dp[dp.length-1];
    }
    /*public static int numberOfWaysToMakeChange(int amount, int[] coins) {
        int n=amount; int[] denoms=coins;
        int[][] dp =new int[denoms.length+1][n+1];

        for (int row=0; row< dp.length; row++){
            dp[row][0]=1;
        }

        for (int row=1; row< dp.length; row++){
                int currency =denoms[row-1];
            for (int amt =1; amt< dp[0].length; amt++){

                if (currency <= amt){
                    dp[row][amt]= dp[row-1][amt] + dp[row][amt-currency];
                }else {
                    dp[row][amt]= dp[row-1][amt];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }*/

    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(5, new int[]{1,2,5}));
    }
}
