package com.prac.home.practice.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class NumbersInPi {
    public static void main(String[] args) {
        /*System.out.println(
                numbersInPi(
                        "3141592653589793238462643383279",
                        new String[]{"314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79"}));*/
        System.out.println(
                numbersInPi(
                        "3141592",
                        new String[]{"3141", "5", "31", "2", "4159", "9", "42"}));
    }
    public static int numbersInPi(String pi, String[] numbers) {
        Map<String , String> keyMap = new HashMap<>();
        for (String s:numbers
             ) {
            keyMap.put(s,s);
        }
        return numbers(pi, keyMap,0);
    }

    public static int numbers(String pi, Map<String , String> keyMap, int idx) {
        if (idx == pi.length()) return -1;
        int count = Integer.MAX_VALUE;
        for (int i = idx; i < pi.length(); i++) {
            String s = pi.substring(idx, i + 1);
            if (keyMap.containsKey(s)) {
                int min=  numbers(pi, keyMap, i+1);
                if (min==Integer.MAX_VALUE){
                    count= Math.min(count, min);
                }else {
                    count= Math.min(count, min+1);
                }
            }
        }
        return count;
    }
}
