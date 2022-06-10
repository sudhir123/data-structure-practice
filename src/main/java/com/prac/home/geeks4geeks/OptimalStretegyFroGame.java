package com.prac.home.geeks4geeks;

import java.util.Map;

public class OptimalStretegyFroGame {
    public static void main(String[] args) {
        System.out.println(countMaximum(new int[]{5,3,7,10},4 ));
    }
    static long countMaximum(int arr[], int n){
        return count(arr, 0, n-1);
    }

    static long count(int[] arr, int i, int j){
        if (i>j)
            return 0;
        long maxsum=0;
            maxsum+= Math.max(arr[i] + Math.min(count(arr, i+1,j), count(arr, i, j-1)) ,
                                arr[j]+ Math.min(count(arr, i, j-1), count(arr, i+1,j ))
                    );

        return maxsum;
    }

    /*static long count(int[] arr, int i, int j, int turn){
        if (i>j)
            return 0;
        long maxsum=0;
        if (turn%2!=0) {
            maxsum+= Math.max(arr[i] + count(arr, i+1, j, turn+1), arr[j] + count(arr, i, j-1, turn+1));
        }else {
            if (arr[i]> arr[j]){
                maxsum=count(arr, i + 1, j, turn+1);
            }else {
                maxsum= count(arr, i, j - 1, turn+1);
            }
        }
        return maxsum;
    }
*/
}
