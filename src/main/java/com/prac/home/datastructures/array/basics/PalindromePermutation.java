package com.prac.home.datastructures.array.basics;

/**
 * Question is basically to check if it is a permutation of a palindrome. KANAK is si asb -> KKAAN
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        isPermutationOfPalindrome("taco cat");
    }
   static boolean isPermutationOfPalindrome(String phrase){
       System.out.println(buildCharacterFrequencyTable().length);
       return true;
   }

   static int [] buildCharacterFrequencyTable(){
        int i = Character.getNumericValue('z');
        int j = Character.getNumericValue('a');
        int[] arr = new int[i-j +1];
        return arr;
   }
}
