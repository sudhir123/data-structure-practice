package com.prac.home.practice;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trappingWater(new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3},14 ));
    }
    static long trappingWater(int arr[], int n) {
        int[] leftArray = new int[n];
        int[] rightArr= new int[n];
        int[] result = new int[n];

        for (int i=0; i < n; i++){
            if (i==0){
                leftArray[i]= arr[0];
            }else {
                leftArray[i]= Math.max(arr[i], leftArray[i-1]);
            }
        }

        for (int i=n-1; i >=0; i--){
            if (i==n-1){
                rightArr[i]= arr[n-1];
            }else {
                rightArr[i]= Math.max(arr[i], rightArr[i+1]);
            }
        }
        long area=0;
        for (int i=0; i < n; i++){
            int res= Math.min(leftArray[i], rightArr[i])- arr[i];
            result[i]= res>=0? res:0;
            area+=result[i];
        }
        return area;
    }
}
