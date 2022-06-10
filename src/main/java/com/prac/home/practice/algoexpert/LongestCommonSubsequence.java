package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("noonabbad","noonabbad"));
    }

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        return subsequence(str1,str2,new ArrayList<>());
        /*String  s=  meth2(str1,str2,str1.length()-1, str2.length()-1);
        List<Character> result= new ArrayList<>();
        char[] ar=  s.toCharArray();
        for (char c:ar
        ) {
            result.add(c);
        }
        return result;*/
    }
    // best by algo, which is subsequence().. but lets try with recursion also meth2
    public static String  meth2(String str1, String str2, int s1Idx, int s2Idx) {
        if (s1Idx==0 || s2Idx==0) return "";
        String s1="";
        if (str1.charAt(s1Idx)== str2.charAt(s2Idx)){
            return s1+str1.charAt(s1Idx)+meth2(str1,str2,  s1Idx-1, s2Idx-1);
        }else {
            if(meth2(str1,str2,  s1Idx-1, s2Idx).length() > meth2(str1,str2,  s1Idx, s2Idx-1).length()){
                return s1+meth2(str1,str2,  s1Idx-1, s2Idx);
            }else {
                return s1+meth2(str1,str2,  s1Idx, s2Idx-1);
            }
        }
    }
    // best by algo
    public static List<Character>  subsequence(String str1, String str2, List<Character> result) {
        str1 =" "+str1;  str2= " "+str2;
        String[][] chars = new String[str1.length()][str2.length()];
        int row=0;
        int col= 0;
        while (col< chars[0].length){
            chars[row][col]="";
            col++;
        }
        col=0;
        while (row< chars.length){
            chars[row][col]="";
            row++;
        }
        for (int r =1; r< chars.length; r++){

            for (int c=1; c< chars[0].length; c++){
                if (str1.charAt(r)== str2.charAt(c)){
                    chars[r][c]= chars[r-1][c-1] + str1.charAt(r);
                }else {
                    String upper = chars[r-1][c];
                    String left = chars[r][c-1];
                    if (upper.length()>=left.length()){
                        chars[r][c]= upper;
                    }else {
                        chars[r][c]= left;
                    }
                }
            }
        }
        char[] ar= (chars[chars.length-1][chars[0].length-1]).toCharArray();

        for (char c:ar
             ) {
            result.add(c);
        }
        return result;
    }
}
