package com.prac.home.algoexpert.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * building height is given in an array and direction is right or left. write a function that that return and array of buildings
 * which can see the sunset. Only condition is building has to greatest in height from the building in the direction.
 */
public class SunSetView {
    /*public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> list= new ArrayList<>();
        int maxHeightSoFar=0;
        if (direction == "EAST") {
            for (int b=buildings.length-1; b>=0; b--){
                if (maxHeightSoFar < buildings[b]){
                    list.add(b); maxHeightSoFar= buildings[b];
                }
            }
            Collections.reverse(list);
        }else {
            for (int b=0; b< buildings.length; b++){
                if (maxHeightSoFar < buildings[b]){
                    list.add(b); maxHeightSoFar= buildings[b];
                }
            }
        }
        return list;
    }
*/

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> list= new ArrayList<>();
        int startIdx=buildings.length-1;
        int step =1;
        int idx = startIdx;
        int runningMaxheight = 0;
        while (idx>=0 && idx< buildings.length){
            int buildingHeight = buildings[idx];
            if (buildingHeight> runningMaxheight){
                list.add(idx);
            }
            runningMaxheight= Math.max(runningMaxheight, buildingHeight);
            idx+=step;
        }
        if (direction.equals("EAST")){
            Collections.reverse(list);
        }
        return list;
    }
    public static void main(String[] args) {
        SunSetView s = new SunSetView();
        System.out.println(s.sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST"));
    }
}
