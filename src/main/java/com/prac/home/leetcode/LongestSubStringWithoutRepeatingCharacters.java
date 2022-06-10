package com.prac.home.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharacters l = new LongestSubStringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstringWithKUniqueCharacters("abcaaadef")); //4
    }

    public int lengthOfLongestSubstringWithKUniqueCharacters(String s) {
        int maxLength=Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        while (j< s.length()){
            Character c = s.charAt(j);
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else {
                map.put(c, 1);
            }

            if (map.size()==(j-i+1)) {
                maxLength= Math.max(maxLength, (j-i+1));
            }else if (map.size()< (j-i+1) ){
                while (i< s.length() && map.size()< (j-i+1)){
                    if (map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    }
                    if (map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;

        }
        return maxLength;
    }
    // sliding window concept
    public int lengthOfLongestSubstring(String s) {
        int maxLength=Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        while (j< s.length()){
            if (!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), 1);
                j++;
            }else {
                maxLength = Math.max(maxLength, map.size());
                map.remove(s.charAt(i));
                i++;
            }
        }
        maxLength = Math.max(maxLength, map.size());
        return maxLength==Integer.MIN_VALUE?map.size():maxLength;
    }
}
