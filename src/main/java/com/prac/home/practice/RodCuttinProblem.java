package com.prac.home.practice;

import java.util.Arrays;

public class RodCuttinProblem {
    public static void main(String[] args) {
        RodCuttinProblem r=new RodCuttinProblem();
        System.out.println(r.maximizeCuts(4, 2,1,1));
        System.out.println(r.maximizeCuts(5, 5,3,2));
        System.out.println(r.maximizeCuts(7, 5,5,2));
    }
    public int maximizeCuts(int n, int x, int y, int z){
        /*int w=n; n=3;
        int[] arr=new int[3];
        arr[0]=x;arr[1]=y;arr[2]=z;
        int[][] dp=new int[n+1][w+1];
        for(int j=1;j<=w;j++)
            dp[0][j]=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=w;j++) {
                if(arr[i-1]<=j)
                    dp[i][j]=Math.max(dp[i][j-arr[i-1]]+1,dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return (dp[n][w]<0)?0:dp[n][w];*/
        int[] arr= new int[]{x,y,z};
        Arrays.sort(arr);
        int[] lengths = new int[n+1];
        int[][] dp  = new  int[arr.length][lengths.length];
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        int r=0;
        while (r< dp.length){
            dp[r][0]=0; r++;
        }
        for (int i=1; i< dp.length; i++){
            for (int j=1; j< dp[0].length; j++ ){
                if (arr[i-1]<=j){
                    dp[i][j]= Math.max(dp[i-1][j], 1+(dp[i][j-arr[i-1]]));
                }else {
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
