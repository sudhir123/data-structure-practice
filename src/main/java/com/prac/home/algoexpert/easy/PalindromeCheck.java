package com.prac.home.algoexpert.easy;
/**
 * function to return array of three largest number on given an i/p of unsorted array
*/
public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        int i =0; int j=str.length()-1;
        while (i <= j) {
            if (str.charAt(i)!=str.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
