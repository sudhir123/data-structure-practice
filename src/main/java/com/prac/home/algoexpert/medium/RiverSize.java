package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class RiverSize {
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int r=0; r< matrix.length; r++){
            for (int c=0; c<matrix[0].length; c++){
                if ( matrix[r][c]==1){
                    list.add(traverseGraph(matrix, r,c));
                }
            }
        }
        return list;
    }

    static int traverseGraph(int[][] matrix, int x, int y){
        if (x<0 || x>= matrix.length || y<0 || y>= matrix[0].length ) return 0;
        if (matrix[x][y]!=1) return 0;
        int counter=0;
        if (matrix[x][y]==1){
            matrix[x][y]= 5;
            counter++;
        }

        int c1= traverseGraph(matrix, x+1,y);
        int c2=traverseGraph(matrix, x-1,y );
        int c3=traverseGraph(matrix, x, y+1 );
        int c4=traverseGraph(matrix, x, y-1 );
        return counter+c1+c2+c3+c4;
    }

    public static void main(String[] args) {
        int[][] arr = new int[5][5];

        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 0;
        arr[0][3] = 0;
        arr[0][4] = 0;

        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[1][2] = 0;
        arr[1][3] = 0;
        arr[1][4] = 0;

        arr[2][0] = 0;
        arr[2][1] = 0;
        arr[2][2] = 1;
        arr[2][3] = 0;
        arr[2][4] = 0;

        arr[3][0] = 0;
        arr[3][1] = 0;
        arr[3][2] = 0;
        arr[3][3] = 1;
        arr[3][4] = 1;

        arr[4][0] = 1;
        arr[4][1] = 1;
        arr[4][2] = 0;
        arr[4][3] = 1;
        arr[4][4] = 1;
        printMatrix(arr);
        System.out.println();
        System.out.println(riverSizes(arr));
    }

    public static void printMatrix(int[][] arr) {
        int row = 0;
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (row == r) {
                    if (c == arr[0].length - 1)
                        System.out.print(arr[r][c]);
                    else
                        System.out.print(arr[r][c] + ", ");
                } else {
                    row = r;
                    System.out.print("\n" + arr[r][c] + ", ");
                }
            }
        }

    }
}

























