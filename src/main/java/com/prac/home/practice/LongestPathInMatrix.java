package com.prac.home.practice;

public class LongestPathInMatrix {
    public static void main(String[] args) {
        System.out.println(finLongestOverAll(new int[][]{
                {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}
        }));
    }
    static int finLongestOverAll(int mat[][]){
        int[][] dp= new int[mat.length][mat[0].length];
        for (int r=0; r< dp.length; r++){
            for (int c =0; c< mat[0].length; c++){
                dp[r][c]=-1;
            }
        }
        int result=1;
        for (int r=0; r< dp.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (dp[r][c]==-1){
                    longestPath(mat, dp, 0,0);
                    result= Math.max(dp[r][c], result );
                }
            }
        }

        return result;
    }

    static int longestPath(int[][] matrix, int[][] dp , int row, int col){
        if (outBoundary(matrix, row, col) ){
            return 0;
        }
        if (dp[row][col]!=-1) return dp[row][col];

        int a =Integer.MIN_VALUE; int b =Integer.MIN_VALUE; int c =Integer.MIN_VALUE; int d =Integer.MIN_VALUE;

        if ( row+1 < matrix.length && matrix[row+1][col]- matrix[row][col] ==1){
            a=dp[row][col] = 1+ longestPath(matrix, dp, row+1, col);
        }
        if (row-1 >=0&& matrix[row-1][col]- matrix[row][col] ==1){
            b=dp[row][col] = 1+ longestPath(matrix, dp, row-1, col);
        }
        if (col+1 < matrix[0].length && matrix[row][col+1]- matrix[row][col] ==1){
            c=dp[row][col] = 1+ longestPath(matrix, dp, row, col+1);
        }
        if (col-1>=0 && matrix[row][col-1]- matrix[row][col] ==1){
            d=dp[row][col] = 1+ longestPath(matrix, dp, row, col-1);
        }
        return dp[row][col] = Math.max(a, Math.max(b, Math.max(c, Math.max(d, 1))));
    }

    static boolean outBoundary(int[][]matrix, int r, int c){
        int maxRow= matrix.length-1;
        int maxCol= matrix[0].length-1;
        if (r <0 || r> maxRow || c<0 || c> maxCol) return true;
        else return false;
    }
}
