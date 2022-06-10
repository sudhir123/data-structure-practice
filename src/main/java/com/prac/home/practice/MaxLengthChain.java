package com.prac.home.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * You are given N pairs of numbers. In every pair, the first number is always smaller than the second number.
 * A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. You have to find the longest
 * chain which can be formed from the given set of pairs.
 * N = 5
 * P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
 * Output: 3
 * Explanation: The given pairs are { {5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },the longest chain that
 * can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
 *
 */
public class MaxLengthChain {
    public static void main(String[] args) {
        MaxLengthChain m= new MaxLengthChain();
        System.out.println(m.maxChainLength(new Pair[]{
                new Pair(5,24),
                new Pair(39,60),
                new Pair(15,28),
                new Pair(27,40),
                new Pair(50,90)
        }, 5));

        System.out.println(m.maxChainLength(new Pair[]{
                new Pair(5,10),
                new Pair(1,11)
        }, 2));
    }

    int maxChainLength(Pair arr[], int n){
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.x >o2.x?1:-1;
            }
        });

        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        for (int i=1; i <n; i++){
            Pair indexPair = arr[i];
            for (int j=0; j< i; j++){
                Pair current = arr[j];
                if (indexPair.x> current.y ){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
                ans= Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}























