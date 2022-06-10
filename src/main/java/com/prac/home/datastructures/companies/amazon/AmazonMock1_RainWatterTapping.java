package com.prac.home.datastructures.companies.amazon;

public class AmazonMock1_RainWatterTapping {
    public static void main(String[] args) {
        System.out.println(trappingWater(new int[]{3,0,0,2,0,4},6));
    }
    static int trappingWater(int arr[], int n) {

        int[] left= new int[arr.length];
        int[] right = new int[n];
        int[] result = new int[n];
        for (int i=0; i< arr.length; i++){
            if (i==0){
                left[i]= arr[i];
            }else {
                left[i]= Math.max(arr[i], left[i-1]);
            }
        }

        for (int i=n-1; i>0; i--){
            if (i==n-1){
                right[i]= arr[i];
            }else {
                right[i]= Math.max(arr[i], right[i+1]);
            }
        }
        int sum=0;
        for (int i=0; i< arr.length; i++){
            int res= Math.min(left[i], right[i])- arr[i];
            result[i]= res>=0? res:0;
            sum+=result[i];
        }
        return sum;
    }
}
