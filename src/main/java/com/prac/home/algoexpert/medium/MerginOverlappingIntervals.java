package com.prac.home.algoexpert.medium;
/**
 *
 */
public class MerginOverlappingIntervals {
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // merging is possible if higher element od one array is greater then the lower element of another array
        int[][] a= new int[intervals.length][]; int k =0;int i =0;
        for (; i <intervals.length-1; i ++) {
            int[] t = intervals[i];
            boolean mergeDirect = false;
            while (intervals[i][1] >= intervals[i + 1][0]) {
                i++;
                mergeDirect=true;
            }
            if (mergeDirect) {
                i--;
            }
            int[] temp = mergeTwo(t, intervals[i+1], mergeDirect);
            if (temp != null) {
                a[k] = temp;
                k++; i++;
            } else {
                a[k] = intervals[i];
                k++;
            }

        }
        while (i<intervals.length){
            a[k] = intervals[i];
            k++;i++;
        }
        return a;
    }
    static int[] mergeTwo(int[] a, int[] b, boolean mergeDirect){
        if (mergeDirect){
            return new int[]{a[0],b[1]};
        }else {
            if (a[1]>b[0]){
                return new int[]{a[0],b[1]};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        mergeOverlappingIntervals(new int[][]{{1,2},{3,5},{4,7},{6,8},{9,10}});
    }
}

















