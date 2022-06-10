package com.prac.home.practice.algoexpert;

public class MinimumNumberOfCoinForChange {
    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(7, new int[]{1, 5, 10}));
    }
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[][] dp = new int[denoms.length+1][n+1];
        /*int r=0, c=0;
        while (r< dp.length){
            dp[r][c]=Integer.MAX_VALUE;
            r++;
        }
        r=0;
        while (c< dp[0].length){
            dp[r][c]=Integer.MAX_VALUE;
            c++;
        }*/
        int row=1;
        for (int coin: denoms
             ) {

            for (int amount=1; amount< dp[0].length; amount++){
                if (amount< coin){
                    dp[row][amount]= dp[row-1][amount];
                }else if (amount== coin) {
                    dp[row][amount]= dp[row-1][amount]+1;
                } else {
                    dp[row][amount]= Math.min(dp[row-1][amount], dp[row][amount-coin]+ amount/ coin);
                }
            }
            row++;
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
