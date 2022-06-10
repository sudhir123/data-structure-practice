package com.prac.home.practice.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class StairCase {
    public int staircaseTraversal(int height, int maxSteps) {
        if (maxSteps==1) return 1;
        Map<Integer, Integer> map =new HashMap<>();
        map.put(0,1);
        map.put(1,1);
        return stairs(height, maxSteps, map);
    }

    public int stairs(int height, int maxSteps, Map<Integer, Integer> map){

        if (map.containsKey(height)) return map.get(height);
        int numberOfWays=0;
        for (int steps=1; steps<Math.min(maxSteps,height)+1; steps++ ){
            numberOfWays+= stairs(height-steps, maxSteps, map);
        }
        map.put(height, numberOfWays);
        return map.get(height);
    }

    public static void main(String[] args) {
        StairCase s= new StairCase();
        System.out.println(s.staircaseTraversal(4,3));
    }
}
