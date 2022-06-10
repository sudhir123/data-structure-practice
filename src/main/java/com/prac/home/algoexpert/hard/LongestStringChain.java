package com.prac.home.algoexpert.hard;

import java.util.*;

public class LongestStringChain {
    public static void main(String[] args) {
        System.out.println(longestStringChain(Arrays.asList("lgoprt", "12345678", "algoxpert", "abcde", "123468", "lgoxprt", "abde", "lgopt", "1234678", "ade", "ae", "algoxprt", "a", "1abde", "lgpt", "123456789", "234678", "algoexpert")));
    }
    public static List<String> longestStringChain(List<String> strings) {
        List<String> result = new ArrayList<>();
        Map<String, StringInfo > map =new HashMap<>();
        for (String s: strings
        ) {
            map.put(s,new StringInfo(s,1));
        }
        strings.sort((o1, o2) -> o1.length()>o2.length()?1:-1);

        for (String s: strings
        ) {
            compareAndUpdateStringInfo(s, map);
        }
        int maxLen=1;
        String maxLenKey =null;
        for (String s:map.keySet()
             ) {
            if (maxLen<map.get(s).maxChain){
                maxLen=map.get(s).maxChain;
                maxLenKey=s;
            }
        }
        while (maxLenKey!=null){
            result.add(maxLenKey);
            maxLenKey= map.get(maxLenKey).next;
        }
        return result;
    }

    static void compareAndUpdateStringInfo(String str , Map<String, StringInfo> map){
        for (int i=0; i< str.length(); i++){
            String temp =str.replace(""+str.charAt(i),"");;
            if (map.containsKey(temp)){
                StringInfo stringInfo= map.get(str);
                if (stringInfo.maxChain <map.get(temp).maxChain+1) {
                    stringInfo.next = temp;
                    stringInfo.maxChain = map.get(temp).maxChain + 1;
                    map.put(str, stringInfo);
                }
            }
        }
    }

    static class StringInfo{
        String current;
        String next;
        int maxChain;
        StringInfo(String current, int maxChain){
            this.current=current;
            this.maxChain=maxChain;
        }
    }

}
