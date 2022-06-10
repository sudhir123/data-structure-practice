package com.prac.home.practice.algoexpert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiskStacking {
    public static void main(String[] args) {
        List<Integer[]> disks= new ArrayList<>();
        disks.add( new Integer[]{2, 1, 2});
        disks.add( new Integer[]{3, 2, 3});
        disks.add( new Integer[]{2, 2, 8});
        disks.add( new Integer[]{2, 3, 4});
        disks.add( new Integer[]{1, 3, 1});
        disks.add( new Integer[]{4, 4, 5});
        diskStacking(disks);
    }
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // sorting disk by height

        disks.sort((a, b) -> a[2]> b[2]?1:-1);
        List<Integer[]> result = new ArrayList<>();
        int[] heights = new int[disks.size()];
        int[] seq = new int[disks.size()];
        Arrays.fill(seq, -1);

        for (int i=0; i < disks.size(); i++){
            heights[i]= disks.get(i)[2];
        }

        for (int i=0; i< disks.size(); i++){
            Integer[] current= disks.get(i);

            for (int j=0; j< i; j++){
                Integer[] other = disks.get(j);

                if (current[0]> other[0] && current[1]> other[1]){

                    if (heights[i] < heights[j]+ current[2]){
                        heights[i] = heights[j]+ current[2];
                        seq[i]= j;
                    }
                }
            }
        }
        int maxVal =Integer.MIN_VALUE; int maxValIdx = -1;
        for (int i =0; i < heights.length;i++){
            if (maxVal< heights[i]){
                maxVal= heights[i];
                maxValIdx=i;
            }
        }

        return seq(disks, seq, maxValIdx,result);
    }
    static List<Integer[]> seq(List<Integer[]> disks, int[] seq, int maxValId, List<Integer[]> result){
        int i=maxValId ;
        result.add(disks.get(i));
        while (seq[i]!=-1){
            i= seq[i];
            result.add(disks.get(i));
        }
        return result;
    }
}
