package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * write function that takes three strings and returns boolean representing whether thirst string can be formed by interweaving two strings
 * interweaving means merge two in any order basically permutations.
 */
public class InterweavingString {
    public static void main(String[] args) {
        System.out.println(interweavingStrings("algoexpert","your-dream-job", "your-algodream-expertjob"));
    }
    // third way by recursion and then apply caching using matrix.
    public static boolean interweavingStrings(String one, String two, String three) {
        if (one.length()+ two.length() != three.length()) return false;
        return  weavingRecursion(one,two,three, 0,0,0);
    }
    static boolean weavingRecursion(String one, String two, String three, int i, int j, int k){
        if (k == three.length()) return true;

        if (i< one.length() && one.charAt(i)==three.charAt(k)){
            if( weavingRecursion(one, two, three, i+1, j, k+1)) return true;
        }
        if (j< two.length() && two.charAt(j)==three.charAt(k)){
            if( weavingRecursion(one, two, three, i, j+1, k+1)) return true;
        }
        return false;
    }
    // #mythinking second approach-- understaning issue here ...cleared 16 test out of 20 but understanding woring
    /*public static boolean interweavingStrings(String one, String two, String three) {
        int[] arr= new int[128];
        for (int i=0; i < one.length(); i++){
            arr[one.charAt(i)]+=1;
        }

        for (int i=0; i < two.length(); i++){
            arr[two.charAt(i)]+=1;
        }

        for (int i=0; i < three.length(); i++){
            arr[three.charAt(i)]-=1;
        }
        for (int i=0; i < three.length(); i++){
            if(arr[three.charAt(i)] !=0){
                return false;
            }
        }
        return true;
    }*/


    // bad approach  #mythinking .. solution1 -> create one string and with character array create all possible permuattaions in Set and check if thirst exists.
    /*public static boolean interweavingStrings(String one, String two, String three) {
        return permutations((one+two).toCharArray()).contains(three);
    }*/
    static List<String> permutations(char[] array){
        List<String> list = new ArrayList<>();
        getAllPermutations(array, 0, list);
        return list;
    }
    static void getAllPermutations(char[] array, int i, List<String> list){
        if (i== array.length-1) {
            list.add(new String(array));
        }
        for (int j=i; j< array.length; j++){
            swap(i, j, array);
            getAllPermutations(array, i+1, list);
            swap(i,j, array);
        }
    }
    static void  swap(int i, int j , char[] array){
        char temp = array[i];
        array[i]= array[j];
        array[j]= temp;
    }
}
