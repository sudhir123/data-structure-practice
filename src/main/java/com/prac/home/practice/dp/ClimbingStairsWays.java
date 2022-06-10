package com.prac.home.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsWays {
    public static void main(String[] args) {
        ClimbingStairsWays c= new ClimbingStairsWays();
        System.out.println(c.climbStairs(4));
    }
    // n is total number of steps .. max steps allowed is 2 that means either 1 or 2
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climb(n, map);
    }

    public int climb(int n, Map<Integer, Integer> map){
        if (n==0 || n==1) return 1;
        if (map.containsKey(n)){
            return map.get(n);
        }
        int num= climb(n-1, map)+ climb(n-2, map);
        map.put(n, num);
        return map.get(n);
    }
}
