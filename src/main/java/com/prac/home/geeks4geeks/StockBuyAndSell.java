package com.prac.home.geeks4geeks;

import java.util.ArrayList;
import java.util.Arrays;

public class StockBuyAndSell {
    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        int array[]= A;
        ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        int i=1;
        while (true){
            int x=i;
            while (i< array.length && array[i]> array[i-1]){
                i++;
            }
            if (x!=i) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(x-1);
                l.add(i - 1);
                result.add(l);
            }

            if (i>=array.length){
                break;
            }
            i++;
        }
        return result;
    }

   /**
    * logic says at any price either you sell it to make profit or not sell.
    * If you don't sell than profit will be of previous day same transaction not previous transaction.
    * but if you sell it today than profit will be
    * (selling price of today - buying price of some previous day + profit you have earned on that day but on previous transaction)
*/
    public static int maxProfitWithKTransactions(int[] prices, int k) {
        int[][] dp = new int[k+1][prices.length];

        for (int row=1; row< dp.length; row++){
            int intrimProfit=Integer.MIN_VALUE;
            for (int col=1; col< dp[0].length; col++){

                dp[row][col]=Math.max(
                        dp[row][col-1], // don't sell
                        prices[col]+ (
                                intrimProfit= profitOnPreviousTransactionOfTheDayBoughtTheShare(prices,dp, row, col, intrimProfit))
                );

            }

        }
        return dp[dp.length-1][dp[0].length-1];

    }

    static int profitOnPreviousTransactionOfTheDayBoughtTheShare(int[] price,int[][]dp,  int row, int col, int intrimProfit){
        //int profit=Integer.MIN_VALUE;
        //for (int i=0; i< col; i++){
            return Math.max(intrimProfit, -price[col-1]+dp[row-1][col-1]);
        //}
       // return profit;
    }

    public static void main(String[] args) {
        StockBuyAndSell s = new StockBuyAndSell();
        System.out.println(s.stockBuySell(new int[]{4,2,2,2,4}, 5));
        //System.out.println(maxProfitWithKTransactions(new int[]{5, 11, 3, 50, 60, 90}, 2));
    }
}
