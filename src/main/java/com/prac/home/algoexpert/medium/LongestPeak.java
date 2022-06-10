package com.prac.home.algoexpert.medium;
/**
 * given an array , check for longest peak. Peak is strictly increase and then decrease. Count the integers and return longest.
 */
public class LongestPeak {
    public static int longestPeak(int[] array) {
        int longest=0; int i =0;
        while (i < array.length-1  && array[i]<array[i+1] ){
                int intrimCounter=1;
                while ( i < array.length-1 && array[i]<array[i+1]){
                    intrimCounter++;
                    i++;
                }
                boolean decreased=false;
                while (i < array.length-1 && array[i]>array[i+1]){
                    decreased=true;
                    intrimCounter++;
                    i++;
                }
                if (decreased){
                    if (longest<intrimCounter){
                        longest=intrimCounter;
                    }
                    i--;
                }
            i++;
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestPeak(new int[]{1, 1, 3, 2,1 }));
    }
}

















