package com.prac.home.algoexpert.medium;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 12-NOV-2021
 * give an array of numbers replresenting  coins and an integer
 */
public class NumberOfWaysToMakeChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // algo expert logic
        int[] ways = new int[n + 1];
        ways[0] = 1; // that's base case , we can genrate 0 amount only by not using any other. only 1 way/
        // now how can we generate 1 dollar using the denoms.
        //if (denoms[i]< n)
        //     ways[i] = ways[n-i]  which means lets say denom[i]=1 so ways of creating 1 dollar using 1 dollar is 1 way, which
        // ways[0] => 1
        for (int denom :denoms
             ) {
            for (int amount=1 ; amount< n+1; amount++){
                if (denom <= amount) {
                    ways[amount]= ways[amount]+  ways[amount-denom];
                }
            }
        }

        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(4,new int[]{1,2}));
    }
}
