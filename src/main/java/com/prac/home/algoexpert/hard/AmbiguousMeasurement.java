package com.prac.home.algoexpert.hard;

import java.util.HashMap;
import java.util.Map;

public class AmbiguousMeasurement {
    public static void main(String[] args) {
        AmbiguousMeasurement a = new AmbiguousMeasurement();
        System.out.println(a.ambiguousMeasurements(new int[][]{
                {200,210},
                {450,465},
                {800,850}
        }, 2100, 2300));
    }
    // basically funda is similar to all permutations. here also we will kepe on doing with every cup and call recursion, adn will see
    // if any of the call is returning tue.
    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        Map<String, Boolean> map =new HashMap<>();
        return measurements(measuringCups, low, high, map);
    }

    public boolean measurements(int[][] measuringCups, int low, int high, Map<String, Boolean> map){
        if (low<=0 && high<= 0) return  false;
        if (map.containsKey(low+":"+high)){
            return map.get(low+":"+high);
        }
        boolean canMeasure =false;
        for (int[] cup : measuringCups
             ) {
            int lowValue= cup[0];
            int highValue = cup[1];
            if (lowValue>=low && highValue<=high){
                canMeasure=true;
                break;
            }else {
                int newLow= Math.max(0, low-lowValue);
                int newHigh= Math.max(0, high-highValue);
                canMeasure= measurements(measuringCups, newLow, newHigh, map);
                if (canMeasure) break;
            }
        }
        map.put(low+":"+high, canMeasure);
        return canMeasure;
    }
}
