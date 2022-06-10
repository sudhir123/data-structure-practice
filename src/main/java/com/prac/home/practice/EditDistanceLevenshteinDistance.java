package com.prac.home.practice;

public class EditDistanceLevenshteinDistance {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        word1= " "+word1;word2=" "+word2;
        int[][] matrix = new int[word1.length()][word2.length()];
        // base case
        int row=0, col=0;
        while (col< matrix[0].length){
            matrix[row][col]= col;
            col++;
        }
        col=0;
        while (row< matrix.length){
            matrix[row][col]= row;
            row++;
        }

        for (row=1; row< matrix.length; row++){
            for (col=1; col < matrix[0].length; col++){

                if (word1.charAt(row)== word2.charAt(col)){
                    matrix[row][col]= matrix[row-1][col-1];
                }else {
                    matrix[row][col]= 1+ Math.min(matrix[row-1][col-1], Math.min(matrix[row-1][col], matrix[row][col-1]));
                }
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }

}
