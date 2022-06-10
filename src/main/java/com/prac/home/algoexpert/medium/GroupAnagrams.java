package com.prac.home.algoexpert.medium;

import java.util.*;

/**
 * Two string are anagram , if made up exactlysame letters, order does not matter. cinema, iceman are anagram.
 * write function that take array of strings and retrun all anagrams together.
 * ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"] ---> [[oy, yo], [cat, act, tac]...]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")));
    }

    //each string is char array ..array sort O(NLogN) ..total such words are w ... so w*n*logn
    public static List<List<String>> groupAnagrams(List<String> words) {
        List<List<String> >lists = new ArrayList<>();
        List<String> copy = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word: words
             ) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            copy.add(new String(arr));
        }

        for (int i=0; i < copy.size(); i++){
            String str = copy.get(i);
            if (map.get(str)!=null){
                List<String> list = map.get(str);
                list.add(words.get(i));
                map.put(str, list);
            }else {
                List<String > list = new ArrayList<>();
                list.add(words.get(i));
                map.put(str, list);
            }
        }
        for (String key : map.keySet()
             ) {
            lists.add(map.get(key));
        }
        return lists;
    }
}
