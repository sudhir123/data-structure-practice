package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.List;

// its is part of LCS and in algo expert it is from Substring.
// LCS using dynamic prog, wether to include char or not.
public class LongestPalindromicSubStringUsingLCS {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
    }
    // one way by algo expert ...it is not related to LCS but aditya verma said its LCS.
    public static String longestPalindromicSubstring(String str) {
        int maxLen=Integer.MIN_VALUE;
        String maxLengthSubStr="";
        for (int i=1; i < str.length(); i++){
          int left = 0; int right= 0;
          if (i%2==0){
              left= i-1; right=i+1;
          }else {
              left= i; right=i+1;
          }
          while (left>=0 && right<= str.length()-1 && str.charAt(left)== str.charAt(right)){
              left--;
              right++;
          }
          String subStr = str.substring(left+1, right);
          if (maxLen< subStr.length()){
              maxLengthSubStr= subStr;
              maxLen= subStr.length();
          }
        }
        return maxLengthSubStr;
    }
}
