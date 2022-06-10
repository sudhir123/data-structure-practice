package com.prac.home.datastructures.array.basics;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 * permutation means exactly same length Sudhir -> hiruSd -> true
 */
public class OneStringIsPermutationOfOther {

    public static void main(String[] args) {

        System.out.println(check("Sudhir","hiruSd"));
    }

    public static boolean check(String a, String b){
        boolean var = true;
        int[] arr = new int[128];
        int i =0;
        for(; i < a.length(); i++){
            arr[a.charAt(i)]= arr[a.charAt(i)]+1;
        }
        for(i=0; i < b.length(); i++){
            if(arr[b.charAt(i)]<1) return false;
        }
        printArray(arr);
        return var;
    }

    public static void printArray(int[] arr){
        Arrays.stream(arr).forEach(System.out::print);
    }
}
