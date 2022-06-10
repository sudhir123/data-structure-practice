package com.prac.home.algoexpert.hard;

import java.util.*;
import java.util.stream.IntStream;

/**
 * #Array
 * we have list of student's remarks. Teacher wants to give prise to students. Minimum 1 prise to everybody. at any random student
 *
 */
public class MinRewards {
    // #way2. we dont need to find local min and max exclusively. we start traversing. we only work with when we have steep upside.
    // so in this case we run loop from 0 to lenght-1 and then length -1 to 0. while o to -> we mark entries which are in upside.
    // best solution
    public static int minRewards(int[] scores) {
        int [] rewards = new int[scores.length];
        Arrays.fill(rewards,1);
        for (int i=0; i< scores.length-1; i++){
            if (scores[i]< scores[i+1]){
                rewards[i+1]= Math.max(rewards[i+1], rewards[i]+1);
            }
        }
        for (int i=scores.length-1; i>0 ; i--){
            if (scores[i]< scores[i-1]){
                rewards[i-1]= Math.max(rewards[i-1], rewards[i]+1);
            }
        }
        return IntStream.of(rewards).sum();
    }
    public static void main(String[] args) {
        System.out.println(minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5}));
    }

    // way 1 this is O(n) but still finding local min max ...we can reduce it while running. #way2;
    /*public static int minRewards(int[] scores) {
        int[] rewards=new int[scores.length];
        Arrays.fill(rewards,1);
        if (scores.length<2) return 1;
        List<Integer> localMinIndexList = localMinIndexes(scores);
        for (Integer localMinidx: localMinIndexList
             ) {
            leftPrizeCount(scores, localMinidx, rewards);
            rightPrizeCount(scores, localMinidx, rewards);
        }
        return IntStream.of(rewards).sum();
    }
    static List<Integer> localMinIndexes(int[] scores){
        List<Integer>localMinIndexList = new ArrayList<>();
        for (int i =0; i < scores.length; i ++){
            if (i==0 ){
                if( scores[i] < scores[i+1]){
                    localMinIndexList.add(i);
                }
            }else if (i==scores.length-1){
                if( scores[i]< scores[i-1]){
                    localMinIndexList.add(i);
                }
            }else {
                if (scores[i-1]> scores[i] && scores[i]< scores[i+1]){
                    localMinIndexList.add(i);
                }
            }
        }
         return localMinIndexList;
    }
    static void leftPrizeCount(int[] scores, int idx, int[] rewards){
        while (idx>0){
            if(scores[idx-1]> scores[idx]){
                rewards[idx-1]= Math.max(rewards[idx-1], rewards[idx]+1);
            }
            idx--;
        }
    }
    static void rightPrizeCount(int[] scores, int idx, int[] rewards){
        while (idx< scores.length-1){
            if(scores[idx] < scores[idx+1]){
                rewards[idx+1]= Math.max(rewards[idx+1],rewards[idx]+1);
            }
            idx++;
        }
    }*/
}
