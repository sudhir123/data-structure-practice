package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.List;

// variation of Longest Common SubSequence
public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSuperSequence("aaaaaaaa","aaaaaaaa"));
    }
    public static String shortestCommonSuperSequence(String str1, String str2) {
        str1= " "+str1; str2= " "+str2;
        String[][] seq= new String[str1.length()][str2.length()];

        int row=0,  col=0;
        while (row< seq.length){
            seq[row][col]= "";
            row++;
        }
        row=0;
        while (col< seq[0].length){
            seq[row][col]= "";
            col++;
        }
        // first calculate LCS
        for (row=1; row< seq.length; row++){

            for (col=1; col< seq[0].length; col++){

                if (str1.charAt(row)==str2.charAt(col)){
                    seq[row][col]=seq[row-1][col-1]+str1.charAt(row);
                }else {
                    String upper= seq[row-1][col];
                    String leftSide = seq[row][col-1];
                    if (leftSide.length()>= upper.length()){
                        seq[row][col]=leftSide;
                    }else {
                        seq[row][col]=upper;
                    }
                }
            }
        }
        String lcs= seq[seq.length-1][seq[0].length-1];
        String s="";int i=1; int j=1; int k=0;
        while (k< lcs.length()) {

            char c =lcs.charAt(k);
            while (str2.charAt(j)!=c){
                s= s+str2.charAt(j);
                j++;
            }
            while (str1.charAt(i)!=c){
                s= s+str1.charAt(i);
                i++;
            }
            s= s+lcs.charAt(k);
            k=k+1; i=i+1; j=j+1;
        }
        while (j< str2.length()){
            s=s+str2.charAt(j);
            j+=1;
        }
        while (i< str1.length()){
            s=s+str1.charAt(i);
            i+=1;
        }

        return s;
    }
}
