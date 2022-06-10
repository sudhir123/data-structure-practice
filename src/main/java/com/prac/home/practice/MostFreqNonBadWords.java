package com.prac.home.practice;

import java.util.*;

public class MostFreqNonBadWords {
    static String MostFrequent(String paragraph, List<String> taboo)
    {
        Set<String> badWordsSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (String badWord: taboo
             ) {
            badWordsSet.add(badWord.toLowerCase());
        }

        paragraph = paragraph.replaceAll("\\p{Punct}","");

        String[] words = paragraph.split(" ");
        for (int i=0; i< words.length; i++){
            String word = words[i].toLowerCase();
            if (!badWordsSet.contains(word)){
                if (map.containsKey(word)){
                    map.put(word, map.get(word)+1);
                }else {
                    map.put(word, 1);
                }
            }
        }
        int maxCount=Integer.MIN_VALUE;
        String maxWord ="";
        for (String key: map.keySet()
             ) {
            if (map.get(key)> maxCount){
                maxWord= key;
                maxCount= map.get(key);
            }
        }
        return maxWord;
    }

}
