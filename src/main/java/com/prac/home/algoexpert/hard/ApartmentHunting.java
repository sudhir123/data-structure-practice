package com.prac.home.algoexpert.hard;

import com.sun.org.apache.bcel.internal.generic.FADD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {
    //brute force approach is to traverse each index of list and check if apartment is taken in that block. Maximum how block
    // needs to be travel to cover all requirement ,which means which one is farthest.
    // O(n^2 r)
   /* public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[] distances = new int[blocks.size()];
        Arrays.fill(distances, Integer.MIN_VALUE);
        int block = 0;
        while (block< blocks.size()) {
            int[] reqIdx = new int[reqs.length];
            Arrays.fill(reqIdx, Integer.MAX_VALUE);
            for (int requirement = 0; requirement < reqs.length; requirement++) {
                String r = reqs[requirement];
                for (int currentIdx = 0; currentIdx < blocks.size(); currentIdx++) {
                    if (blocks.get(currentIdx).get(r) == true) {
                        reqIdx[requirement]= Math.min(reqIdx[requirement], Math.abs(currentIdx-block));
                    }
                }
            }
            distances[block]= Math.max(distances[block], Arrays.stream(reqIdx).max().getAsInt());
            block++;
        }
        int min =Integer.MAX_VALUE;
        int minIdx =-1;
        for (int i=0; i < distances.length; i++){
            if (min> distances[i]){
                min= distances[i]; minIdx= i;
            }
        }
        return minIdx;
    }*/

    // try same thing in O(nr). main problem with above solution is we need to traverse the block again and again.
    // what if we traverse once and check if Gyem is how much block away from any block. this info can be derived using a techniche, which
    // we used in water storage kinda problem. Left to right and than right to left. this way we travers the problem with 2n rather than
    // n^2 and more.
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {

        int[] gymDist = new int[blocks.size()];
        int[] schoolDist = new int[blocks.size()];
        int[] storeDist = new int[blocks.size()];

        blockInformationFromLeft(gymDist, blocks, "gym");
        blockInformationFromRight(gymDist, blocks, "gym");

        blockInformationFromLeft(schoolDist, blocks, "school");
        blockInformationFromRight(schoolDist, blocks, "school");

        blockInformationFromLeft(storeDist, blocks, "store");
        blockInformationFromRight(storeDist, blocks, "store");

        int[] distances = new int[blocks.size()];
        for (int idx =0; idx< blocks.size(); idx++){
            distances[idx]= Math.max(Math.max(gymDist[idx], schoolDist[idx]), storeDist[idx]);
        }
        int min=Integer.MAX_VALUE; int minIdx =-1;
        for (int idx =0; idx< blocks.size(); idx++){
            if (min> distances[idx]){
                min= distances[idx];
                minIdx= idx;
            }
        }
        return minIdx;
    }

    static void blockInformationFromLeft(int[] array, List<Map<String, Boolean>> blocks, String str){
        array[0]= blocks.get(0).get(str)==true?0:-1;
        for (int block=1; block< blocks.size(); block++){
            if (blocks.get(block).get(str)==true){
                array[block]= 0;
            }else {
                if (array[block-1]>=0){
                    array[block]= array[block-1]+1;
                }else {
                    array[block]= array[block-1];
                }
            }
        }
    }
    static void blockInformationFromRight(int[] array, List<Map<String, Boolean>> blocks, String str){
        for (int block=array.length-2; block>=0; block--){
            if (array[block+1]>=0 && array[block]!=-1){
                array[block]= Math.min(array[block+1]+1, array[block]);
            }
            if (array[block]==-1){
                array[block]=array[block+1]+1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(apartmentHunting(
                Arrays.asList(
                        new HashMap<String, Boolean>() {{
                            put("gym", false);
                            put("school", true);
                            put("store", false);
                        }},
                        new HashMap<String, Boolean>() {{
                            put("gym", true);
                            put("school", false);
                            put("store", false);
                        }},
                        new HashMap<String, Boolean>() {{
                            put("gym", true);
                            put("school", true);
                            put("store", false);
                        }},
                        new HashMap<String, Boolean>() {{
                            put("gym", false);
                            put("school", true);
                            put("store", false);
                        }},
                        new HashMap<String, Boolean>() {{
                            put("gym", false);
                            put("school", true);
                            put("store", true);
                        }}
                )
                , new String[]{"gym", "school", "store"}
        ));
    }
}



























