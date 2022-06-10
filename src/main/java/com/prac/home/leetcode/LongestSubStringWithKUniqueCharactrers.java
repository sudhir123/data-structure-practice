package com.prac.home.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueCharactrers {
    public static void main(String[] args) {
        LongestSubStringWithKUniqueCharactrers l = new LongestSubStringWithKUniqueCharactrers();
        System.out.println(l.lengthOfLongestSubstringWithKUniqueCharacters("aabbccaaaaaa", 1));
    }

    // sliding window concept
    public int lengthOfLongestSubstringWithKUniqueCharacters(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        int maxLength=Integer.MIN_VALUE;
        while (j< s.length()){
            if (map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j))+1);
            }else {
                map.put(s.charAt(j), 1);
            }
            if (map.size()==k){
                maxLength= Math.max(maxLength, j-i+1);
            }else if (map.size()>k){
                while (map.size()>k && i<s.length()){
                    if (map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i), map.get(s.charAt(i))-1);
                        if (map.get(s.charAt(i))==0){
                            map.remove(s.charAt(i));
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return maxLength;
    }
}
