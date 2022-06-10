package com.prac.home.algoexpert.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * #Array
 * u have been give first N digits of PI in string format, and a list of strings from that number.
 * we need to find minimum number of spaces
 * we need to add to the main string so that we can cover every string given in list.
 * example "1413" ["1","4","3"]  minimum 2 spaces required. Specific logic to solve such problems
 */
public class NumberInPi {
    public static void main(String[] args) {
        System.out.println(numbersInPi("3141592", new String[]{"3141", "5", "31", "2", "4159","9","42"}));
    }
    // one way
    // Algo -> check evey character y putting space in main string, and see if that substring exists. If so pass remaining string to the
    // method and keep on doing the logic and count the total in that recursive logic. when return keep the count as Min.
    public static int numbersInPi(String pi, String[] numbers) {
        Set<String> numberTable = new HashSet<>();
        for (String num: numbers
             ) {
            numberTable.add(num);
        }
        Map<Integer, Integer> cache= new HashMap<>();
        int minSpaces = getMinSpaces(pi, numberTable, cache, 0);

        return minSpaces==Integer.MAX_VALUE? -1: minSpaces;
    }

    static int getMinSpaces(String pi, Set<String> numberTable, Map<Integer, Integer>cache, int idx ){
        if (idx==pi.length()) return -1;
        if (cache.containsKey(idx)) return cache.get(idx);
        int minSpace = Integer.MAX_VALUE;

        for (int i =idx; i< pi.length(); i++){
            String prefix = pi.substring(idx, i+1);
            if (numberTable.contains(prefix)){
                int minSpaceInSuffix = getMinSpaces(pi, numberTable, cache, i+1);
                if (minSpaceInSuffix==Integer.MAX_VALUE){
                    minSpace= Math.min(minSpace, minSpaceInSuffix);
                }else {
                    minSpace= Math.min(minSpace, minSpaceInSuffix+1);
                }
            }
        }

        cache.put(idx, minSpace);
        return cache.get(idx);
    }




}
