package com.prac.home.algoexpert.medium;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {
    // #my thinking not 100%correct
    /*public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] minNumberCoin = new int[n + 1];

        for (int denom : denoms
        ) {
            for (int amount = 0; amount <= n; amount++) {
                if (denom <= amount) {
                    if (denom == 1) {
                        minNumberCoin[amount] = amount / denom;
                    } else {
                        minNumberCoin[amount] = Math.min(
                                minNumberCoin[amount],
                                (minNumberCoin[amount / denom] + minNumberCoin[amount - denom]));
                    }
                }
            }

        }
        return minNumberCoin[n ];
    }*/
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] minNumberCoin = new int[n + 1];
        Arrays.fill(minNumberCoin, Integer.MAX_VALUE);
        minNumberCoin[0]=0 ; int toCompare =0;
        for (int denom : denoms
        ) {
            for (int amount = 0; amount <= n; amount++) {
                // id 1 dollar <= 0 dollar ... which we cannot use 1 dollar to make 0 dollar
                // another example 1<=1 yes ,we can use
                // another example when we have 2 as coin and amount we need to generate is 3
                // 2<=3 yes we can use use 2 dollar and along with 1 dollar --3-2=1
                if (denom<=amount){
                    if (minNumberCoin[(amount-denom)] ==Integer.MAX_VALUE){
                        toCompare= minNumberCoin[(amount-denom)];
                    }else {
                       toCompare= (1)+minNumberCoin[(amount-denom)];
                    }
                    minNumberCoin[amount]=Math.min(minNumberCoin[amount],toCompare);
                }
            }
        }
        return minNumberCoin[n]==Integer.MAX_VALUE?-1: minNumberCoin[n];
    }

    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(8, new int[]{2, 1}));
    }
}
