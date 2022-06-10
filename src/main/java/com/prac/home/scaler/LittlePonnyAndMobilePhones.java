package com.prac.home.scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LittlePonnyAndMobilePhones {

    public static void main(String[] args) {
        LittlePonnyAndMobilePhones l =new LittlePonnyAndMobilePhones();
        System.out.println(Arrays.toString(l.solve(new int[]{3, 4, 4, 6}, new int[]{20, 4, 10, 2})));
        //{3,7,11, 17}
    }
    public int[] solve(int[] A, int[] B) {

        int[] result =new int[B.length];
        int sum=0;
        for (int a=0; a< A.length; a++) {
            A[a]=sum+=A[a];
        }
        for (int bIdx =0; bIdx<B.length; bIdx++) {
            result[bIdx]= search(A, B[bIdx], 0, A.length-1);
        }

        return result;
    }

    public int search(int [] prices, int currentPrise, int start, int end){//  applying bst  for search
        if (start> end){
            return start;
        }
        int mid = (start+end)/2;
        if (prices[mid] > currentPrise){
            return search(prices, currentPrise, start, mid-1);
        }else {
           return search(prices, currentPrise, mid+1, end);
        }
    }
}
