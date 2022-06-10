package com.prac.home.practice;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * buy anytime and sell any time .. any number of transactions. only things is one at a time.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 */
public class BuySellStockMaximiseProfitPart2 {

    public static void main(String[] args) {
        BuySellStockMaximiseProfitPart2 b= new BuySellStockMaximiseProfitPart2();
        System.out.println(b.maxProfit(new int[]{1,2,3,4,5}));
    }
    // explained approach in videos
    public int maxProfit(int[] arr) {
        int profit=0;
        for (int i=0; i< arr.length-1; i++){
            if (arr[i]< arr[i+1]){
                profit= profit+arr[i+1]- arr[i];
            }
        }
        return profit;
    }
}
