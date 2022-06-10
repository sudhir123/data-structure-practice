package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapSackProbelm {
    public static void main(String[] args) {
        System.out.println(knapsackProblem(new int[][]{
                {1, 2},
                {4, 3},
                {5, 6},
                {6, 7}}, 10));
    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] dp = new int[items.length+1][capacity+1];
        for (int row=1; row< dp.length; row++){

            int[] currentItem = items[row-1];
            int currentItemPrise = currentItem[0];
            int currentItemWight = currentItem[1];

            for (int col = 1; col<dp[0].length; col++){
                int currentSackWeight= col;
                if (currentSackWeight < currentItemWight){
                    dp[row][col]= dp[row-1][col];
                }else {
                    if (row == 1) {
                            dp[row][col]= currentItemPrise;
                    } else {
                        int remainWeight = currentSackWeight - currentItemWight;
                        dp[row][col] = Math.max(currentItemPrise + dp[row-1][remainWeight], dp[row - 1][col]);
                    }
                }
            }
        }



        List<Integer> totalValue = Arrays.asList(dp[dp.length-1][dp[0].length-1]);
        List<Integer> finalItems= buildIdx(items, dp);
        List<List<Integer>> result = new ArrayList<>();
        result.add(totalValue);
        result.add(finalItems);
        return result;
    }

    static  List<Integer> buildIdx(int[][] items , int[][]dp){
        List<Integer> idxList = new ArrayList<>();
        int maxItemPrice =dp[dp.length-1][dp[0].length-1];
        int row =dp.length-1;
        int col= dp[0].length-1;
        while (row>0 && dp[row][col]==dp[row-1][col]){
            row-=1;
        }
        idxList.add(row-1);
        int[] item =items[row-1];
        int weight = item[1];
        int maxWeight = col;
        int remainingWeight = maxWeight- weight;
        int priceAtRemainingWeight =dp[row][remainingWeight];
        while (priceAtRemainingWeight==dp[row][remainingWeight]){
            row-=1;
        }
        idxList.add(row);
        Collections.sort(idxList);
        return idxList;
    }

}
