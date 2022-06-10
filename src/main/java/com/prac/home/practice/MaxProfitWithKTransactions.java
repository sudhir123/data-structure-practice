package com.prac.home.practice;

import java.util.ArrayList;
import java.util.List;

public class MaxProfitWithKTransactions {
    public static void main(String[] args) {
        MaxProfitWithKTransactions m = new MaxProfitWithKTransactions();
        System.out.println(maxProfitWithKTransactions(new int[]{5, 11, 3, 50, 60, 90}, 2));
        //System.out.println(m.stockBuySell(new int[]{5, 11, 3, 50, 60, 90}, 2));
    }
    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[][] dp = new int[n + 1][A.length];
        for (int row=1; row< dp.length; row++){

            int intrimProfit =Integer.MIN_VALUE;

            for (int col =1; col< dp[0].length; col++){
                dp[row][col]= Math.max(
                        dp[row][col-1], // not selling
                        // selling
                        A[col] + (intrimProfit= (calculateProfit(dp, A, row, col, intrimProfit, list)))
                );
            }
        }
        return list;
    }

    static int calculateProfit(int[][]dp, int[] A, int row, int col, int intrimProfit, ArrayList<ArrayList<Integer>> result){
        ArrayList<Integer> a= new ArrayList<>();
        for (int k =0; k< col; k++){
            if (intrimProfit<  (-A[k]+ dp[row][k])){
                intrimProfit= -A[k]+ dp[row][k];
                a.add(k);
                result.add(a );
            }
            //intrimProfit= Math.max(intrimProfit, -A[k]+ dp[row][k]);
        }
        return intrimProfit;
    }



    public static int maxProfitWithKTransactions(int[] prices, int k) {
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i < dp.length; i++) {

            int intrimProfit = Integer.MIN_VALUE;

            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(
                        dp[i][j - 1],// not selling
                        prices[j] + (intrimProfit = calculateBoughtPriceAndAddProfitTillThatPriceFromDP(dp, prices, i, j, intrimProfit))
                );
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    static int calculateBoughtPriceAndAddProfitTillThatPriceFromDP(int[][]dp, int[] prices, int row, int j, int previousProfit){
        //for (int k=0; k < j; k++){
            previousProfit= Math.max(previousProfit, -prices[j-1]+ dp[row-1][j-1]);
        //}
        return previousProfit;
    }
}
