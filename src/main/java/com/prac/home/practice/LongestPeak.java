package com.prac.home.practice;

public class LongestPeak {

    //peak is between three
    public static int longestPeak(int[] array) {

        int maxCount=Integer.MIN_VALUE;
        if (array.length<2) return -1;
        for (int i=1; i< array.length; i++){
            if (array[i]> array[i-1]){
                int intrimCount =1;
                while (i< array.length && array[i]> array[i-1]){
                    i++;intrimCount++;
                }
                boolean peak=false;
                while (i< array.length && array[i]< array[i-1]){
                    peak=true;
                    i++; intrimCount++;
                }
                if (peak){
                    maxCount= Math.max(maxCount, intrimCount);
                }
                i=i-1;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
    }
}
