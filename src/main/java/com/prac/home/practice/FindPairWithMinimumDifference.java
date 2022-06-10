package com.prac.home.practice;

import java.util.Arrays;

public class FindPairWithMinimumDifference {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPairWithMinimumDifference(new int[]{10, 5, 40}, new int[]{50, 90, 80})));
    }
    static int[] findPairWithMinimumDifference(int[] a, int[]b){
        Arrays.sort(a);
        Arrays.sort(b);// nlog n
        int[] result = new int[]{a[0], b[0]};
        int targetDiff = Integer.MAX_VALUE;
        int i=0; int j=0;
        while (i< a.length && j< b.length){
            int currentDiff =Math.abs(a[i]- b[j]);
            if (currentDiff < targetDiff){
                targetDiff= currentDiff;
                result[0]= a[i];
                result[1]= b[j];
                i++;
            }else {
                j++;
            }
        }
        return result;
    }
}
