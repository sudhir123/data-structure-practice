package com.prac.home.practice;

/**
 * Given an array(0-based indexing), you have to find the max sum of i*A[i] where A[i] is the element at index i in the array.
 * The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.
 */
public class MaxSumInConfiguration {
    public static void main(String[] args) {
        MaxSumInConfiguration m = new MaxSumInConfiguration();
        System.out.println(m.max_sum(new int[]{8,3,2,1}, 4));
    }
    int max_sum(int A[], int n) {
        int ans=0;
        int pro=0;
        int sum=0;
        for (int i =0; i < A.length; i++){
            sum+=A[i];
            pro+=A[i]*i;
        }

        for (int i =0; i < A.length; i++){
            pro= pro+sum -((n)*(A[n-1-i]));
            ans = Math.max(ans, pro);
        }
        return ans;
    }
}
