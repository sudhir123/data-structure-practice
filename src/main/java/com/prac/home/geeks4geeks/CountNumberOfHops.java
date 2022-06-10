package com.prac.home.geeks4geeks;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfHops {
    public static void main(String[] args) {
        System.out.println(countWays(4));
    }
    static long countWays(int n){
        return countNumberOfWays(n, new HashMap<Integer, Long>());
    }

    static long countNumberOfWays(int n, Map<Integer, Long> map){
        if (n==0 || n==1) return 1;
        if (n==2) return countNumberOfWays(n-1, map)+ countNumberOfWays(n-2, map);

        if (map.containsKey(n)){
            return map.get(n);
        }
        long res=   countNumberOfWays(n-1, map)
                +   countNumberOfWays(n-2, map)
                +   countNumberOfWays(n-3, map);
        map.put(n, res%1000000007);

        return map.get(n);
    }
}
