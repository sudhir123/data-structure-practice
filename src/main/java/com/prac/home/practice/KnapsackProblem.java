package com.prac.home.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapsackProblem {
    public static void main(String[] args) {
        KnapsackProblem k = new KnapsackProblem();
        System.out.println(knapsackProblem(new int[][]{
                {1, 2},
                {4, 3},
                {5, 6},
                {6, 7}}, 10));
    }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] dp =new int[wt.length+1][W+1];
        int row=0, col=0;
        while (col< dp[0].length){
            dp[row][col]=0;
            col++;
        }
        col=0;
        while (row< dp.length){
            dp[row][col]=0;
            row++;
        }

        for (row=1;row< dp.length; row++){

            int currentPrise= val[row-1];
            int currentWeight = wt[row-1];

            for (col=1; col< dp[0].length; col++){
                int currentCap = col;
                if (currentWeight > currentCap){
                    dp[row][col]= dp[row-1][col];
                }else {
                    int remainingWeight = currentCap - currentWeight;
                    int totalPrise= currentPrise;
                    if (remainingWeight>=0){
                        totalPrise= totalPrise + dp[row-1][remainingWeight];
                    }
                    dp[row][col]= Math.max(dp[row-1][col], totalPrise);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] dp =new int[items.length+1][capacity+1];
        int row=0, col=0;
        while (col< dp[0].length){
            dp[row][col]=0;
            col++;
        }
        col=0;
        while (row< dp.length){
            dp[row][col]=0;
            row++;
        }
        for (row=1;row< dp.length; row++){
            int[] item= items[row-1];
            int currentPrise= item[0];
            int currentWeight = item[1];
            for (col=1; col< dp[0].length; col++){
                int currentCap = col;
                if (currentWeight > currentCap){
                    dp[row][col]= dp[row-1][col];
                }else {
                    int remainingWeight = currentCap - currentWeight;
                    int totalPrise= currentPrise;
                    if (remainingWeight>=0){
                        totalPrise= totalPrise + dp[row-1][remainingWeight];
                    }
                    dp[row][col]= Math.max(dp[row-1][col], totalPrise);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> maxPrise = new ArrayList<>();
        maxPrise.add(dp[dp.length-1][dp[0].length-1]);
        List<Integer> position = new ArrayList<>();
        calculatePositions(dp, items, position);
        Collections.reverse(position);
        result.add(maxPrise);
        result.add(position);
        return result;
    }

    public static void calculatePositions(int[][] dp, int[][] items, List<Integer> positions){
        int maxRow = dp.length-1; int maxCol = dp[0].length-1;
        positions.add(maxRow-1);
        int[] item = items[maxRow-1];
        int remainingPrise = dp[maxRow][maxCol- item[1]];
        while (maxRow>0){
            if (dp[maxRow][maxCol-item[1]]==remainingPrise){
                maxRow-=1;
            }else {
                break;
            }
        }
        positions.add(maxRow);
    }

}
