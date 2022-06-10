package com.prac.home.algoexpert.hard;

public class MaxProfitWithTwoTransaction {
    public static void main(String[] args) {
        System.out.println(maxProfitWithKTransactions(new int[]{5, 11, 3, 50, 60, 90}, 2));
    }
    // this works with DP and in such cases we will have two-D array. columns represents the price on days and
    // rows represent the transactions such as 1 transaction and with such price how much profit we can have.
    // base case will be 0 transaction no profit that is 0.
    public static int maxProfitWithKTransactions(int[] prices, int k) {
        if (prices.length==0){
            return 0;
        }
        if (prices.length==1){
            return prices[0];
        }

        int[][] dp = new int[k+1][prices.length];

        for (int row=1; row< dp.length; row++){
            int intrimProfit=Integer.MIN_VALUE ;
            for (int col=1; col< dp[0].length; col++){
                dp[row][col]= Math.max(
                        dp[row][col-1],// not selling it at current price
                        // or selling at current prise , buying at preveous prise and adding profit till that prevouis prise, which
                        // is saved in dp already
                        prices[col] + (intrimProfit=calculateProfitIfSellTodayBuyingSomePreviousPrice(dp,prices, row, col, intrimProfit)) // selling at current prise
                );
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    //this is another loop which we can reduce latter
    static int calculateProfitIfSellTodayBuyingSomePreviousPrice(int[][] dp, int[] price, int row, int col, int intrimProfit){

        //for (int idx=0; idx< col; idx++){
            intrimProfit= Math.max(intrimProfit, -price[col-1]+ dp[row-1][col-1]);
        //}
        return intrimProfit;
    }
}

/**
 *          int buy1= Integer.MIN_VALUE, sell1= Integer.MIN_VALUE, buy2= Integer.MIN_VALUE, sell2 = Integer.MIN_VALUE;
 *
 *         for (int i =0; i< prices.length; i++){
 *             buy1= Math.max(buy1, -1*prices[i]);
 *             sell1= Math.max(sell1, buy1+ prices[i]);
 *             buy2= Math.max(buy2, sell1- prices[i]);
 *             sell2= Math.max( sell2, buy2+ prices[i]);
 *         }
 *
 *         return sell2;
 */
