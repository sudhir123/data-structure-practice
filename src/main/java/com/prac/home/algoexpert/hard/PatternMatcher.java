package com.prac.home.algoexpert.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PatternMatcher {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString( patternMatcher("xxyxxy","gogopowerrangergogopowerranger")));
        System.out.println(Arrays.toString( patternMatcher("xyx","thisshouldobviouslybewrong")));
    }
    public static String[] patternMatcher(String pattern, String str) {
        if (pattern.length()> str.length()) return new String[]{};
        char[] array = pattern.toCharArray();
        if (pattern.charAt(0)=='y'){
            invertPattern(array);
        }

        Map<Character, Integer> patCount= charCount(array);
        Map<Character, String> characterStringMap =new HashMap<>();

        if (pattern.charAt(0)=='y'){
            String[] arr = wm(str, new String(array).indexOf('y'),0,array, patCount , characterStringMap, new String[2]);
            return new String[]{arr[1], arr[0]};
        }else {
            return wm(str, pattern.indexOf('y'),0,array, patCount , characterStringMap, new String[2]);
        }
    }

    static void invertPattern(char[] pattern){
        for (int i=0; i < pattern.length; i++){
            if(pattern[i]=='x'){
                pattern[i]='y';
            }else if (pattern[i]=='y'){
                pattern[i]='x';
            }
        }
    }
    static Map<Character, Integer> charCount(char[] pattern){
        Map<Character, Integer> map= new HashMap<>();
        for (int i=0; i < pattern.length; i++){
            char c = pattern[i];
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        return map;
    }

    static String[] wm(
                       String str,
                       int positionOfY,
                       int lengthOfX ,
                       char[] array,
                       Map<Character, Integer> patCount,
                       Map<Character, String> characterStringMap,
                       String[] result){
        if (lengthOfX== str.length()) return result;

        if (checkPattern(str, array, characterStringMap.get('x'), characterStringMap.get('y'))){
            result[0]= characterStringMap.get('x');
            result[1]= characterStringMap.get('y');
            return result;
        }

        // calculation everytime.
        // x char
        lengthOfX+=1;
        characterStringMap.put('x', str.substring(0, lengthOfX));

        int totalLengthX =  patCount.get('x') * lengthOfX;
        int lengthOfY = (str.length() -(totalLengthX))/ patCount.get('y');
        int lengthOfXBeforeY = characterStringMap.get('x').length() * positionOfY;
        if (patCount.get('y')!=0 && lengthOfY<0){
            return new String[]{};
        }
        characterStringMap.put('y', str.substring(lengthOfXBeforeY, lengthOfXBeforeY+lengthOfY));

        wm(str, positionOfY, lengthOfX, array, patCount, characterStringMap, result);

        return result;
    }

    static boolean checkPattern(String str, char []array, String x, String y){
        StringBuilder sb = new StringBuilder();
        for (char c: array
             ) {
            if (c=='x'){
                sb.append(x);
            }else {
                sb.append(y);
            }
        }
        return sb.toString().equals(str);
    }
}
