package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Palindromic SubString
 */
public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("ab12365456321bb"));
    }
    // this solution O(n^2)
    public static String longestPalindromicSubstring(String str) {
        String longestPalindrome="";
        if (str.length()<2) longestPalindrome=str;
        for (int i =1; i <str.length(); i++){

            String even = palindrome(str, i, i+1);
            String odd = palindrome(str, i-1, i+1);
            String currentLong= even.length()>odd.length()?even:odd;
            longestPalindrome = longestPalindrome.length()> currentLong.length()? longestPalindrome:currentLong;
        }
        return longestPalindrome;
    }

    static String palindrome(String string, int leftIdx, int rightIdx){

        while (leftIdx>=0 && rightIdx<=string.length()-1){
            if (string.charAt(leftIdx)!=string.charAt(rightIdx)){
                break;
            }
            leftIdx--; rightIdx++;
        }
        return string.substring(leftIdx+1, rightIdx);
    }
    boolean isPalindrome(String s){
        int left= 0, right = s.length()-1;
        while (left< right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++; right--;
        }
        return true;
    }
    // this solution is bad n^3 time complexity
    /*public static String longestPalindromicSubstring(String str) {
        String prevString="";
        //List<String> list = new ArrayList<>();
        for (int startIdx = 0; startIdx< str.length(); startIdx++){
            for (int lastIdx =str.length()-1; lastIdx>startIdx; lastIdx--){
                if (str.charAt(startIdx)== str.charAt(lastIdx)){
                    int idxFrom= startIdx, idxTo= lastIdx;
                    while (str.charAt(idxFrom)==str.charAt(idxTo)){
                        if (idxFrom < idxTo ){
                            idxFrom++;idxTo--;
                        } else if (idxFrom >= idxTo) {
                            if (prevString.length()< str.substring(startIdx, lastIdx+1).length()){
                                prevString= str.substring(startIdx, lastIdx+1);
                            }
                            //list.add(str.substring(startIdx, lastIdx+1));
                           idxFrom++;
                        }
                    }
                }
            }
        }
        //System.out.println(list);
        return prevString;
    }*/
}
