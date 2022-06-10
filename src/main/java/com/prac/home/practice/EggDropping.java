package com.prac.home.practice;

public class EggDropping {
    public static void main(String[] args) {
        System.out.println(eggDrop(2,10));
    }
    static int eggDrop(int n, int k){
        int [][] dp= new int[n+1][k+1];
       return solve(n, k , dp);
    }

    static int solve(int eggs, int f, int [][] dp ){
        if (eggs==1) return f;
        if (f==0||f==1) return 1;

        if (dp[eggs][f]!=0){
            return dp[eggs][f];
        }
        int min = Integer.MAX_VALUE;
        for (int k=1; k<=f; k++){
            int count= 1+Math.max( solve(eggs-1, k-1, dp), solve(eggs, f-k, dp));
            min= Math.min(min, count);
        }
        dp[eggs][f]= min;
        return min;
    }

    /*static int eggDrop(int n, int k){
        int[][] dp = new int[n+1][k+1];
        for (int c=0; c< dp[0].length;c++ ){
            dp[0][c]=0;
            dp[1][c]= c ;
        }
        for (int r=2; r< dp.length; r++){
            for (int c=0; c<dp[0].length; c++){
                if (c>r) {
                    dp[r][c] = 1 + Math.max(dp[r-1][c - 1], dp[r - 1][c - r]);
                }else {
                    dp[r][c]= dp[r-1][c];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }*/
}
