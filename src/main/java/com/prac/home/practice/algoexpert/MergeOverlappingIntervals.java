package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b) ->Integer.compare(a[0],b[0]) );
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]); int k=1;
        for (int i=1; i< intervals.length; i++){
            int[] current = intervals[i];
            int[] prevCalculated = result.get(k-1);
            if (current[0]<= prevCalculated[1]){
                result.set(k-1, new int[]{prevCalculated[0], Math.max(prevCalculated[1], current[1])});
            }else {
                result.add(intervals[i]);
                k++;
            }

        }
        int[][] resultArray = new int[result.size()][2];
        int i=0;
        for (int[] ar: result
             ) {
            resultArray[i]= ar;
            i++;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        MergeOverlappingIntervals m = new MergeOverlappingIntervals();
        m.mergeOverlappingIntervals(new int[][]{
                {1,2},
                {3,5},
                {4,7},
                {6,8},
                {9,10},
        });
    }
}
