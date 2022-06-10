package com.prac.home.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * at-most two transaction
 */
public class BuySellStockMaximiseProfitPart3 {

    public static void main(String[] args) {
        BuySellStockMaximiseProfitPart3 b= new BuySellStockMaximiseProfitPart3();
        System.out.println(b.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
    public int maxProfit(int[] arr) {
        int fb=Integer.MIN_VALUE,  fs= 0, sb= Integer.MIN_VALUE, ss= 0;
        int[] buyArr = new int[2];
        Arrays.fill(buyArr, Integer.MIN_VALUE);
        int[] sellArr= new int[2];
        Arrays.fill(sellArr,0);
        for (int i=0; i< arr.length; i++){
            int price = arr[i];
            twoStokes(price, buyArr, sellArr, 2);
            /*fb = Math.max(fb, -price);
            fs = Math.max(fs , fb+ price);
            sb = Math.max(sb, fs-price);
            ss= Math.max(ss, sb+price);*/
        }
        return sellArr[sellArr.length-1];
    }

    public void twoStokes(int price, int[] buyArr, int[] sellArr, int k){
        buyArr[0] = Math.max(buyArr[0], -price);
        sellArr[0]= Math.max(sellArr[0], buyArr[0]+price);
        for (int i=1; i<k; i++){
            buyArr[i] = Math.max(buyArr[i-1], sellArr[i-1]-price);
            sellArr[i]= Math.max(sellArr[i], buyArr[i]+price);
        }
    }


}






























