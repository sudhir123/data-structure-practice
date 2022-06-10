package com.prac.home.algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * array of positive integers. Function to return the min value which cannot be constructed using th numbers.
 * O(nlogn)
 */
public class NonConstructibleChange {
    // #mythinking, if it be sorted.
    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChangeCreated= 0;
        for (int i= 0 ; i <coins.length; i++){
            if (coins[i] > currentChangeCreated+1) {
                return currentChangeCreated+1;
            }
            currentChangeCreated= currentChangeCreated+coins[i];
        }
        return currentChangeCreated+1;
    }

    /*public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChangeCreated=0;
        for (int coin: coins
        ) {
            if (coin>currentChangeCreated+1){
                return currentChangeCreated+1;
            }
            currentChangeCreated= currentChangeCreated+coin;
        }
        return currentChangeCreated+1;
    }*/
    public static void main(String[] args) {
        NonConstructibleChange n = new NonConstructibleChange();
        System.out.println(n.nonConstructibleChange(new int[]{5, 7, 1, 1, 2, 3, 22}));
    }
}
