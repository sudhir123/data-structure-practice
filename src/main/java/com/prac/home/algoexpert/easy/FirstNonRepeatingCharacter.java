package com.prac.home.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * function takes string as input and returns the first non repeating character
 * abcdad  answer b
 */
public class FirstNonRepeatingCharacter {
    public int firstNonRepeatingCharacter(String string) {
        char[] chars= string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i =0; i <chars.length; i++){
            if (map.get(chars[i])!=null){
                map.put(chars[i], map.get(chars[i])+1);
            }else {
                map.put(chars[i], 1);
            }
        }

        for (int i =0; i <chars.length; i++){
            if (map.get(chars[i])==1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter f = new FirstNonRepeatingCharacter();
        System.out.println(f.firstNonRepeatingCharacter("faadaecbbbbdf"));
    }
}
