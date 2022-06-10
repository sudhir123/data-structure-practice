package com.prac.home.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(longestSubStringWithKUnique(new String[]{"a","a","b","a","c","b","e","b","e","b","e" }, 3));
    }
    static int longestSubStringWithKUnique(String[] array, int k){
        int i=0; int j=0;
        Map<String , Integer> map=new HashMap<>();
        int count=0; int length=0;
        for (; j< array.length; ){

            if (map.containsKey(array[j])){
                map.put(array[j], map.get(array[j])+1);
            }else {
                if (count < k) {
                    map.put(array[j], 1);
                    count++;
                }else {
                    // new  value and k+1th
                    System.out.println("array[i])- "+array[i]);
                    map.put(array[i], map.get(array[i])-1);
                    if (map.get(array[i])==0) {
                        count--;
                    }else {
                        j--;
                    }
                    i++;
                }
            }
            length = Math.max(length, j - i + 1);
            j++;

        }
        return length;
    }
}

