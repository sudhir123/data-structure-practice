package com.prac.home.datastructures.companies.amazon;
/**
 * Given two strings S and T of length n and m respectively. find count of distinct occurrences of T in S as a sub-sequence.
 * Input: * S = "banana" , T = "ban"
 * Output: 3
 * Explanation: There are 3 sub-sequences:
 * [ban], [ba n], [b an].
 */
public class DistinctOccurrences {
    public static void main(String[] args) {
        DistinctOccurrences d= new DistinctOccurrences();
        System.out.println(d.subsequenceCount("geeksforgeeks","ge"));

    }
    // logic id to check if last characters are equal or not. If not equal than distinct count is same as we dont include that character.
    // but if we have characters equal than case is to if we need to include that or not. Sum of two cases.
    int  subsequenceCount(String S, String T) {
        S= " "+S;
        T= " "+T;
        int[][] matrix = new int[T.length()][S.length()];
        int row=0; int col=0;
        while (row< matrix.length){
            matrix[row][col]=0;
            row++;
        }
        row=0;
        while (col< matrix[0].length){
            matrix[row][col]= 1;
            col++;
        }


        for (row=1; row< matrix.length; row++){
            for (col=1; col< matrix[0].length; col++){
                if (S.charAt(col)==T.charAt(row)){
                    matrix[row][col]= matrix[row][col-1]+matrix[row-1][col-1];
                }else {
                    matrix[row][col]= matrix[row][col-1];
                }
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }
}
