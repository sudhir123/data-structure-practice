package com.prac.home.practice.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutDuplication {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("clementisacap"));
    }
    // i will apply sliding window.
    public static String longestSubstringWithoutDuplication(String str) {
        String result ="";
        Map<Character, Integer>map= new HashMap<>();
        int i=0; int j=0;
        while (j<str.length()){
            Character ch = str.charAt(j);
            if (!map.containsKey(ch)){
                map.put(ch, 1);
            }else {
                map.put(ch, map.get(ch)+1);
            }
            if (j-i+1 > map.size()){

                while (j-i+1> map.size()){
                    if (map.containsKey(str.charAt(i))){
                        map.put(str.charAt(i), map.get(str.charAt(i))-1);
                    }
                    if (map.get(str.charAt(i))==0) {
                        map.remove(str.charAt(i));
                    }
                    i++;
                }

            }else if (j-i+1== map.size()){
                result= result.length()< str.substring(i, j+1).length()?str.substring(i, j+1):result;
            }
            j++;
        }
        return result;
    }
}
