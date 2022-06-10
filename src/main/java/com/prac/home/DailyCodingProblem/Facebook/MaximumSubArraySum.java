package com.prac.home.DailyCodingProblem.Facebook;

import java.util.Arrays;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        int a[] = {8,-8,9,-9,10,-11,12};
        int n = 7;
        System.out.println(kadane(a,n));
        System.out.println(reverseKadane(a,n));
        System.out.println("Maximum circular sum is " +Integer.max(kadane(new int[]{8,-8,9,-9,10,-11,12},n),
                reverseKadane(new int[]{8,-8,9,-9,10,-11,12},n)));
    }
    public static int kadane(int a[],int n){
        int res = 0;
        int x =  a[0];
        for(int i = 0; i < n; i++){
            res = Math.max(a[i],res+a[i]);
            x= Math.max(x,res);
        }
        return x;
    }
    //lets write a function for calculating max sum in circular manner as discuss above
    public static int reverseKadane(int a[],int n){
        int total = 0;
        //taking the total sum of the array elements
        for(int i = 0; i< n; i++){
            total +=a[i];

        }
        // inverting the array
        for(int i = 0; i<n ; i++){
            a[i] = -a[i];
        }
        // finding min sum subarray
        int k = kadane(a,n);
//      max circular sum
        int ress = total+k;
        // to handle the case in which all elements are negative
        if(total == -k ){
            return total;
        }
        else{
            return ress;
        }

    }








    // i think kadaneAlgo lets try is for
    // this is for non- wrapping elements. if elemnts are are wrapping than best is to use kadane but with non wrapping
//     that means consider this .. we need to find the maximum sum of wrapping elements instead o that if we find the sum of
    // non wrapping non contributing number ... we will sub that from total.
    // now how to find sum of non contributing ....multiple the whole aglo with -1 and app kadane algi
    static int maxSubArraySum(int nums[]){
        int[] arr= Arrays.copyOf(nums, nums.length);
        int totalSum=0;
        for (int i=0; i < arr.length; i++){
            arr[i]*=-1;
        }
        for (int i=0; i < nums.length; i++){
            totalSum= totalSum+nums[i];
        }
        int nonContributingNonWrappingSum = kadaneAlgo(arr);
        int ress = totalSum+ nonContributingNonWrappingSum;
        if (totalSum== nonContributingNonWrappingSum){
            return totalSum;
        }else {
            return ress;
        }
    }
    static int kadaneAlgo(int nums[]){
        int sumSoFar= nums[0];
        int maxSum= nums[0];
        for (int i=1; i<nums.length; i++){
            sumSoFar= Math.max(sumSoFar, sumSoFar+nums[i]);
            maxSum= Math.max(maxSum, sumSoFar);
        }
        return maxSum;
    }
}
