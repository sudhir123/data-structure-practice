package com.prac.home.algoexpert.hard;

import java.util.*;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("AC","ABCD"));
    }
    /**
     * practice 2 learned that it will be dynamic programming
         * and it involves two array (character array in this) , we need matrix. Now how to fill matrix is main thins to understand.
     * pick common by each character at a time. increase value when you get common to the exting value. how will you have existing
     * pick value diognal that when equal character is not there. lets say not equal in that case pick what is greatest from up or left.
     * base case would be 0.
     */
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        str1= " "+str1; str2= " "+str2;
        int[][] matrix = new int[str2.length()][str1.length()];

        // base case
        int r=0, c=0;
        while (c<matrix[0].length){
            matrix[r][c]=0;
            c++;
        }
        c=0;
        while (r<matrix.length){
            matrix[r][c]= 0;
            r++;
        }
        for (r=1; r< matrix.length; r++){
            for (c=1; c< matrix[0].length; c++){
                if (str2.charAt(r)==str1.charAt(c)){
                    matrix[r][c]=  matrix[r-1][c-1]+1;
                }else {
                    matrix[r][c]= Math.max( matrix[r-1][c],  matrix[r][c-1]);
                }
            }
        }
        return new ArrayList<>();
    }

    /*public int longestCommonSubsequence(String text1, String text2) {
        String str1= " "+text1; String str2= " "+text2;
        int[][] matrix = new int[str2.length()][str1.length()];

        // base case
        int r=0, c=0;
        while (c<matrix[0].length){
            matrix[r][c]=0;
            c++;
        }
        c=0;
        while (r<matrix.length){
            matrix[r][c]= 0;
            r++;
        }
        for (r=1; r< matrix.length; r++){
            for (c=1; c< matrix[0].length; c++){
                if (str2.charAt(r)==str1.charAt(c)){
                    matrix[r][c]=  matrix[r-1][c-1]+1;
                }else {
                    matrix[r][c]= Math.max( matrix[r-1][c],  matrix[r][c-1]);
                }
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }*/

    // first way which has time complexity O(nm*min(n+m)) ..this solution involves concatinations of strings
    /* practice 1 aia algo expert
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        int[][] length =  new int[str2.length()+1][str1.length()+1]; // +1 is because we kept empty string and lcs i.e
        // least common string between start is empty string
        // start with i and j as 1 because of the algo ..


        for (int i =1; i <str2.length()+1; i++){
            for (int j =1; j< str1.length()+1; j++){
                if (str2.charAt(i-1)==str1.charAt(j-1)){
                    length[i][j]=   length[i-1][j-1] + 1;// diagonal + current common value
                }else {
                    length[i][j]=Math.max(length[i-1][j], length[i][j-1]);
                }
            }
        }
        return buildSequence(length, str1);
    }
    static List<Character> buildSequence(int[][]length, String str1){
        List<Character> sequence= new ArrayList<>();
        int i = length.length-1;
        int j= length[0].length-1;
        while (i!=0 && j!=0){
            if (length[i][j]== length[i-1][j]){
                i--;
            }else if (length[i][j]== length[i][j-1]){
                j--;
            }else {
                sequence.add(0, str1.charAt(j-1));
                i--;
                j--;
            }
        }
        return sequence;
    }*/
    // not a good way ...not solve all kinda problem
    /*public static List<Character> longestCommonSubsequence(String str1, String str2) {
        List<Character> characters= new ArrayList<>();
        Map<Character, List<Integer>> mapCharactersWithIndex= new HashMap<>();
        for (int i=0; i < str1.length(); i++){
            char ch= str1.charAt(i);
            if (mapCharactersWithIndex.containsKey(ch)){
                mapCharactersWithIndex.get(ch).add(i);
            }else {
                List<Integer> indexes= new ArrayList<>();
                indexes.add(i);
                mapCharactersWithIndex.put(ch, indexes);
            }
        }

        int lastIdx=Integer.MIN_VALUE;
        for (int i=0; i < str2.length(); i ++){
            char ch = str2.charAt(i);
            if (mapCharactersWithIndex.containsKey(ch) ){
                int temp=-1;
                if ((temp= partOfSequence(mapCharactersWithIndex.get(ch), lastIdx))!=-1){
                    lastIdx= temp!=-1?temp: lastIdx;
                    characters.add(str1.charAt(lastIdx));
                }
            }
        }
        return characters;
    }

    static int partOfSequence(List<Integer> seq, int lastIdx){
        int newLastIdx=-1;
        for (Integer index:seq
             ) {
            if (index > lastIdx){
                newLastIdx= index;
            }
        }
        return newLastIdx;
    }*/
}
