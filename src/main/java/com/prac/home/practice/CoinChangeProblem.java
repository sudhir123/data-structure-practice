package com.prac.home.practice;

import java.util.Arrays;

public class CoinChangeProblem {
    public static void main(String[] args) {
        CoinChangeProblem c= new CoinChangeProblem();
        System.out.println(c.minimumNumberOfCoins(new int[]{1, 2 ,3 ,4 ,5, 6, 7 ,8, 9 ,10, 11},11, 149 ));
    }
    public long minimumNumberOfCoins(int coins[],int numberOfCoins,int value) {
        Arrays.sort(coins);
        int[][] matrix = new int[coins.length+1][value+1];
        //Arrays.fill(matrix[0],Integer.MAX_VALUE-1);
        int row=0, col=0;
        while (col< matrix[0].length){
            matrix[row][col]= Integer.MAX_VALUE;
            col++;
        }
        col=0;
        /*while (row< matrix.length){
            matrix[row][col]= Integer.MAX_VALUE;
            row++;
        }
        matrix[0][0]=0;*/
        int toCompare=0;
        for (  row=1; row< matrix.length; row++){
            for ( col=0; col< matrix[0].length; col++){
                int coin= coins[row-1];
                if (coin<= col){
                    if (matrix[row-1][col-coin]==Integer.MAX_VALUE){
                        toCompare= matrix[row][col-coin];
                    }else {
                        toCompare= 1+(matrix[row][col-coin]);
                    }
                    matrix[row][col]=Math.min(matrix[row][col], toCompare);
                }
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1]==Integer.MAX_VALUE ?-1:matrix[matrix.length-1][matrix[0].length-1];
    }

    public static int minNumberOfCoinsForChange(int value, int[] coins) {
        int[][] minNumberCoin = new int[coins.length+1][value + 1];
        Arrays.fill(minNumberCoin[0], Integer.MAX_VALUE);
        minNumberCoin[0][0]=0 ;int toCompare =0;
        for (int denom=1; denom< minNumberCoin.length; denom++) {
            for (int amount = 0; amount <= value; amount++) {
                if (denom<=amount){
                    if (minNumberCoin[denom][(amount-denom)] ==Integer.MAX_VALUE){
                        toCompare= minNumberCoin[denom][(amount-denom)];
                    }else {
                        toCompare= (1)+minNumberCoin[denom][(amount-denom)];
                    }
                    minNumberCoin[denom][amount]=Math.min(minNumberCoin[denom][amount],toCompare);
                }
            }
        }
        return minNumberCoin[minNumberCoin.length-1][value]==Integer.MAX_VALUE?-1: minNumberCoin[minNumberCoin.length-1][value];
    }
    /*public static int minNumberOfCoinsForChange(int value, int[] coins) {
        int[] minNumberCoin = new int[value + 1];
        Arrays.fill(minNumberCoin, Integer.MAX_VALUE);
        minNumberCoin[0]=0 ;int toCompare =0;
        for (int denom : coins
        ) {
            for (int amount = 0; amount <= value; amount++) {
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
        return minNumberCoin[value]==Integer.MAX_VALUE?-1: minNumberCoin[value];
    }*/
}
