package com.prac.home.algoexpert.medium;
/**
 * function to take two strings and retuns the minimum number of operations to perform in the first to obtain second string
 * s1= abc s2= yabd  1) adding y s1= yabc 2) replace c with d   2 operations. Insert Update Delete
 */
public class LevenshteinDistance {
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc", "yabd"));
    }

    // 2-D matrix row string s1 and column string s2. Our target is to convert S1 to s2. So in matrix we need to consider that
    // what are the number of operations required to convert and empty string to empty string than empty to y so on.
    // than build case and than start thinking of when you only a character and you need to build y than build ya than yab than yabd.
    // this will help us build the formula.
    public static int levenshteinDistance(String str1, String str2) {
        int[][] matrix = new int[str1.length()+1][str2.length()+1];
        // build base case
        String str3= " "+str1;
        String str4= " "+str2;
        int r=0; int c=0;
        for (; c< matrix[0].length; c++){
            matrix[r][c]=c;
        }
        c=0;
        for (; r< matrix.length; r++){
            matrix[r][c]=r;
        }
        for (r=1; r< matrix.length; r++){
            for (c=1; c< matrix[0].length; c++){
                int minVal = Math.min(matrix[r-1][c], Math.min(matrix[r-1][c-1],matrix[r][c-1]));
                if (str3.charAt(r)==str4.charAt(c)){
                    matrix[r][c]= matrix[r-1][c-1];
                }else {
                    matrix[r][c]= minVal+1;
                }
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }

}
