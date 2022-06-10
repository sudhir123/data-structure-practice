package com.prac.home.scaler;

public class MAxEvenAndMinEvenDiff {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{5,17,100,1}));
    }
    static int solve(int[] A){
        int maxEven= Integer.MIN_VALUE;
        int minOdd= Integer.MAX_VALUE;

        for (int i=0; i< A.length; i++     ){
            if (A[i]%2==0){
                maxEven= Math.max(maxEven, A[i]);
            }else {
                minOdd= Math.min(minOdd, A[i]);
            }
        }
        return maxEven-minOdd;
    }
}
