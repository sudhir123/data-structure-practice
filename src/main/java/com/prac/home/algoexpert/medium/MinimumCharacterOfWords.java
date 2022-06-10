package com.prac.home.algoexpert.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * write function that takes in an array of words and returns smallest array of characters needed to form all words. That->2 T needed
 */
public class MinimumCharacterOfWords {
    public static void main(String[] args) {
        MinimumCharacterOfWords m = new MinimumCharacterOfWords();
        System.out.println(
                Arrays.toString(m.minimumCharactersForWords(new String[]{"this", "that", "did", "deed", "them!", "a"}))
        );
    }
    public char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();

        int charCount=0;
        for (String word: words
             ) {
            Map<Character, Integer> integerMap= new HashMap<>();
            for (int i=0; i < word.length(); i++){

                if (integerMap.get(word.charAt(i))!=null){
                    integerMap.put(word.charAt(i), integerMap.get(word.charAt(i))+1);
                }else {
                    integerMap.put(word.charAt(i), 1);
                }
            }
            for (Character c:integerMap.keySet()
            ) {
                if (map.get(c)==null){
                    map.put(c, integerMap.get(c));
                    charCount+=integerMap.get(c);
                }
                else if (map.get(c)!=null && map.get(c)< integerMap.get(c)){
                    charCount-=map.get(c);
                    map.put(c, integerMap.get(c));
                    charCount+=integerMap.get(c);
                }
            }
        }

        char[] charArray= new char[charCount];charCount=0;
        for (Character c: map.keySet()
             ) {
            for (int i= 1; i<=map.get(c); i++){
                charArray[charCount++]=c;
            }
        }

        return charArray;
    }
}
