package com.prac.home.practice;

import com.sun.org.glassfish.external.amx.AMX;

/**
 * there is difference between substring and subsequence. Substring is continouus chaaracters and subsequence means characters in order
 * no necessarily continuous. example abaxyaba -> longest subseq will be abaaba but when substring it is aba.
 * To subsequence we will use DP of Longest Common SubSequence
 */
public class LongestPalindromicString {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubString1("ccc"));
    }
    // algo-expert
    public static String longestPalindromeSubString1(String s) {
        int[] currentLongest = {0,1};
        for (int i=0; i<s.length(); i++ ){
            int[] odd = getPalindromic(s,i, i);
            int[] even= getPalindromic(s, i, i+1);
            int[] longest = s.substring(odd[0], odd[1]).length()> s.substring(even[0],even[1]).length()? odd:even;

            currentLongest=
                    s.substring(longest[0], longest[1]).length()> s.substring(currentLongest[0],currentLongest[1]).length()
                            ? longest:currentLongest;
        }

        return s.substring(currentLongest[0], currentLongest[1]);
    }

    static int[] getPalindromic(String s, int start, int end){
        while (start>=0 && end<s.length()){
            if (s.charAt(start)!=s.charAt(end)){
                break;
            }
            start-=1; end+=1;
        }
        return new int[]{start+1,end};
    }

}
