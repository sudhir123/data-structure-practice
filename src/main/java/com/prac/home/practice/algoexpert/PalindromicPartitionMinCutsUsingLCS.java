package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitionMinCutsUsingLCS {
    public static void main(String[] args) {
        System.out.println(palindromePartitioningMinCuts("noonabbad"));
    }
    // number of cuts is equal to number of palindromic substring ...not subsequence. Lets try with LongestPalindromicSubString.
    // I think variation is rather than getting longest ..get all substrings
    static int palindromePartitioningMinCuts(String str1){
         getAllPalindromicSubStrings(str1);
         return -1;
    }
    // this works on the principle of "treat each index as middle of palindrome. Just keep on increasing on both side
    // this is O(n^2)
    static List<String > getAllPalindromicSubStrings(String str){
        List<String> result = new ArrayList<>();
        for (int i=1; i< str.length(); i++){

            String even= palindrome(str, i-1, i+1);
            String odd = palindrome(str, i, i+1);

            String currentLong = even.length()>odd.length()? even:odd;

        }
        return null;
    }

    static String palindrome(String str, int left, int right ){
        while (left>=0 && right<=str.length()-1){
            if (str.charAt(left)!= str.charAt(right)){
                break;
            }
            left--; right++;
        }
        return str.substring(left+1, right);
    }
}
