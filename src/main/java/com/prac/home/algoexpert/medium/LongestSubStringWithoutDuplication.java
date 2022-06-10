package com.prac.home.algoexpert.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutDuplication {
    public static String longestSubstringWithoutDuplication(String str) {
        int maxLength=Integer.MIN_VALUE;
        String result ="";
        int i=0; int j=0;
        Map<Character, Integer> map = new HashMap<>();
        while (j< str.length()){
            Character c = str.charAt(j);
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else {
                map.put(c, 1);
            }

            if (map.size()==(j-i+1)){
                maxLength= Math.max(maxLength, (j-i+1));
                result= result.length()<(j-i+1)? str.substring(i,j+1): result;
            }else if (map.size()< (j-i+1)){
                while (map.size()< (j-i+1)){
                    if (map.containsKey(str.charAt(i))){
                        map.put(str.charAt(i), map.get(str.charAt(i))-1);
                    }
                    if (map.get(str.charAt(i))==0){
                        map.remove(str.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication(
                "abcddc"
        ));
    }
}
