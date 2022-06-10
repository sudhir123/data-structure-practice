package com.prac.home.practice;

import java.util.Arrays;

public class NonConstructibleChange {
    public static void main(String[] args) {
        System.out.println(new NonConstructibleChange().nonConstructibleChange(new int[]{1, 5, 1, 1, 1, 10, 15, 20, 100}));
    }
    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int possibleChange =0;
        for (int i=0; i < coins.length; i++){
            if (coins[i] > possibleChange+1){
                return possibleChange+1;
            }else {
                possibleChange+=coins[i];
            }
        }
        return possibleChange+1;
    }

}
