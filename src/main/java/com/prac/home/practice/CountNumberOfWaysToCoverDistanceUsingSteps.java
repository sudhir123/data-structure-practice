package com.prac.home.practice;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfWaysToCoverDistanceUsingSteps {
    public static void main(String[] args) {
        CountNumberOfWaysToCoverDistanceUsingSteps c = new CountNumberOfWaysToCoverDistanceUsingSteps();
        System.out.println(c.climbStairs(5));
    }

    public int climbStairs(int n) {
        int maxStepAllowed= 2;
        Map<Integer, Integer> map = new HashMap<>();
        return ways(n, maxStepAllowed, map);
    }

    public int ways(int n, int maxSteps, Map<Integer, Integer> map){
        if (n==0 || n==1){
            return 1;
        }
        while (n <= maxSteps){ // in this case this condition is same as normal ..else lets say max step is 4 ... than this make sense
                                // till we reach 4 .. we will have two steps sum once reaching 4 than sum of last 4 steps
            if (map.containsKey(n)) return map.get(n);
            else {
                map.put(n, ways(n-1, maxSteps, map)+ ways(n-2, maxSteps, map));
                return map.get(n);
            }
        }
        if (map.containsKey(n)) return map.get(n);
        else {
            map.put(n, (ways(n-1, maxSteps, map)+ ways(n-2, maxSteps, map))%1000000007);
            return map.get(n);
        }
    }
}
