package com.prac.home.algoexpert.medium;

import java.util.Arrays;

/**
 * sorted matrix in row and column . search and target number and return the index of it in terms of array
 *
 */
public class SearchInSortedMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchInSortedMatrix(new int[][]{
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}
        }, 44)));
    }
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int row=0; int col =matrix[0].length-1;
        while (row< matrix.length && col>=0){
            if (matrix[row][col]>  target){
                col--;
            }else if (matrix[row][col]<  target){
                row++;
            }else {
                return new int[]{row, col};
            }
        }
        return new int[]{-1,-1};
    }

    public static int maxColumn( int[][] matrix, int target, int col) {
        while (matrix[0][col]< target){
            col++;
        }
        if (col>0){
            col--;
        }
        return col;
    }

    public static int maxRow( int[][] matrix, int target, int row) {
        while (matrix[row][0]< target){
            row++;
        }
        if (row> 0){
            row--;
        }
        return row;
    }
}
