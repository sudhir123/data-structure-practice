package com.prac.home.practice.slidingwindow;

import java.util.*;

// this will be a combination of grouping anagrams from algo expert and sliding window
public class CountOccourencesOfAnagram {
    public static void main(String[] args) {
        CountOccourencesOfAnagram c= new CountOccourencesOfAnagram();
        System.out.println(c.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map= new HashMap<>();
        for (int i=0; i< p.length(); i++){
            if (map.containsKey(p.charAt(i))){
                map.put(p.charAt(i), map.get(p.charAt(i))+1);
            }else {
                map.put(p.charAt(i), 1);
            }
        }
        int count= map.size();
        int left=0; int right =0;

        while (right < s.length()){
            if (right-left+1 < p.length()){
                if (map.containsKey(s.charAt(right))){
                    map.put(s.charAt(right), map.get(s.charAt(right))-1);
                    if (map.get(s.charAt(right))==0){
                        count--;
                    }
                }
                right++;
            }else {
                if (map.containsKey(s.charAt(right))){
                    map.put(s.charAt(right), map.get(s.charAt(right))-1);
                    if (map.get(s.charAt(right))==0){
                        count--;
                    }
                }
                if (count==0){
                    result.add(left);
                }
                right++;
                if (map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                    if (map.get(s.charAt(left))==1){
                        count++;
                    }
                }
                left++;
            }
        }
        return result;
    }

}
