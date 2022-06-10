package com.prac.home.algoexpert.easy;
/**
 * question is if you able to generate a target string from given characters. Strign can have anything number, chars special char.
 */
public class GenerateDocument {
    public boolean generateDocument(String characters, String document) {
        int[] chars1 = new int[255];
        for (int i=0;i < document.length(); i ++){
            chars1[document.charAt(i)]= chars1[document.charAt(i)]+1;
        }
        for (int i=0;i < characters.length(); i ++){
            chars1[characters.charAt(i)]= chars1[characters.charAt(i)]-1;
        }
        for (int i =0;i <255; i ++){
            if (chars1[i]>0) return false;
        }
        return true;
    }
}
