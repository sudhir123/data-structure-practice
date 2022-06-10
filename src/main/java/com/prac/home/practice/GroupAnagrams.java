package com.prac.home.practice;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
       /* System.out.println(groupAnagrams(Arrays.asList(
                "yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"
        )));*/
    }

    public static List<List<String>> groupAnagrams(String [] strs) {
        Map<String , List<String >> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String  word: strs
             ) {
            char[] s =word.toCharArray();
            Arrays.sort(s);
            String sTemp =new String(s);
            if (map.containsKey(sTemp)){
                map.get(sTemp).add(word);
            }else {
                List<String>l = new ArrayList<>();
                l.add(word);
                map.put(sTemp, l);
            }
        }
        for (String  key: map.keySet()
             ) {
            result.add(map.get(key));
        }
        return result;
    }
}
