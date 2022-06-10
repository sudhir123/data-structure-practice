package com.prac.home.algoexpert.medium;

import java.util.Arrays;

/**
 *  given two positive integers , height of star case and maximum step u can take. function to find number of ways.
 *  #mythinking Problem seems to be very similar to coin change demon and and make a number of it.
 *  height is equal to change , what we want to generate, and maxSteps is maximum coin N we have... so we can make it an array for 1..N
 */

/**
 * Solution
 */
public class StairCaseTraversal {
    public int staircaseTraversal(int height, int maxSteps) {
        //return numberOfWatsToTop(height,maxSteps);
        return numberOfWaysUsing_DP(height, maxSteps);
    }

    // solution1 recursion time complexity is O(k^n) space O(n)
    int numberOfWatsToTop(int height,  int maxStep){
        if (height <=1 ) return 1;
        int numberOfways=0;
        // why we have takine min function because , we are decreasing height to get implement febobonacci... and
        // lets saya height is 5 and max step is 2 .
        for (int step=1; step <Math.min(height,maxStep )+1;step++){
            numberOfways+=numberOfWatsToTop(height-1, maxStep);
        }
        return numberOfways;
    }

    // solution 2 is memorizarion

    // solution3 is dynamic programming
    int numberOfWaysUsing_DP(int height, int maxStep){
        int[] waysToTop= new int[height+1];
        waysToTop[0]=1;
        waysToTop[1]=1;

        for (int currentHeight =2; currentHeight< height+1; currentHeight++){
            int step=1;
            while (step<= maxStep && step<= currentHeight){
                waysToTop[currentHeight]= waysToTop[currentHeight]+ waysToTop[currentHeight-step];
                step=step+1;
            }
        }
        return waysToTop[height];
    }

    public static void main(String[] args) {
        StairCaseTraversal s = new StairCaseTraversal();
        System.out.println(s.staircaseTraversal(8, 2));
    }
}
