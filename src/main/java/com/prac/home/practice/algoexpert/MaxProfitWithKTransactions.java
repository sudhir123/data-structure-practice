package com.prac.home.practice.algoexpert;

public class MaxProfitWithKTransactions {
    public static int maxProfitWithKTransactions(int[] prices, int k) {
        int[][]dp =new int[k+1][prices.length];
        for (int row=1; row<dp.length; row++){
            // row is transaction
            int prevMaxProfit=Integer.MIN_VALUE;
            for (int col=1; col< dp[0].length; col++){
                // col= prices on single day
                dp[row][col]= Math.max(dp[row][col-1],
                        prices[col]+ (prevMaxProfit= previousProfitMinusPreviousPrice(prices, row, col, dp, prevMaxProfit))
                        );
            }
        }
        return -1;
    }

    static int previousProfitMinusPreviousPrice(int[] prices, int row, int col, int [][]dp, int prevMaxProfit){

        prevMaxProfit= Math.max(prevMaxProfit,  -prices[col-1]) +dp[row-1][col-1];
        return prevMaxProfit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfitWithKTransactions(new int[]{5, 11, 3, 50, 60, 90}, 2));
    }
}
