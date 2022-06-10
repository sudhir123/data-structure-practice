package com.prac.home.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        TargetSum t= new TargetSum();
        System.out.println(t.findTargetSumWays(new int[]{1,1,1,1,1,},3));
    }
    public int findTargetSumWays(int[] nums, int target) {
        Map<Entry, Integer> entryIntegerMap= new HashMap<>();
        return findTarget(nums, target,entryIntegerMap, nums.length-1,0);
    }
    static class Entry{
        int index;
        int sum;
        Entry(int index, int sum){
            this.index=index;
            this.sum=sum;
        }
    }
    public int  findTarget(int[] array, int target, Map<Entry, Integer>map, int currentIdx, int currentSum) {
        Entry entry= new Entry(currentIdx,currentSum);
        if (map.containsKey(entry)){
            return map.get(entry);
        }
        if (currentIdx <0 && currentSum==target) return 1;

        if (currentIdx<0) return 0;
        int positives = findTarget(array,target, map, currentIdx-1, currentSum+ array[currentIdx]);
        int negatives = findTarget(array,target, map, currentIdx-1, currentSum- array[currentIdx]);
        int sum = positives+negatives;
        map.put(entry, sum);
        return map.get(entry);
    }

}


























