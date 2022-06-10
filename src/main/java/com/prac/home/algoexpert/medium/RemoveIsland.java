package com.prac.home.algoexpert.medium;

import java.util.*;

/**
 * given a two dimensional array with 0s and 1s. 1 represent island. But 1 at the border that is first row column
 * and last row and column are not counted in islands, so does the diognols. Islands are only horizonal and vertical 1s.
 */
public class RemoveIsland {
    public int[][] removeIslands(int[][] matrix) {
        Set<String>visited= new HashSet<>();

        for (int r =0; r < matrix.length; r ++){
            for (int c=0; c< matrix[0].length; c++){

                boolean rowBorder = r==0||r==matrix.length-1;
                boolean colBorder = c==0 || c== matrix[0].length-1;
                boolean isBorder = rowBorder || colBorder;

                if (!isBorder)
                    continue;

                if (matrix[r][c]==1){

                    if (!visited.contains(r+","+c) ){

                        findOnesConnectedToBorder(matrix,r,c,visited);
                    }
                }
            }
        }

        for (int r =1; r < matrix.length-1; r ++) {
            for (int c = 1; c < matrix[0].length - 1; c++) {

                if (visited.contains(r+","+c)) continue;
                matrix[r][c]=0;
            }
        }
        return matrix;
    }

    void findOnesConnectedToBorder(int[][]matrix, int row, int col, Set<String>visited){
        Stack<String> stack= new Stack<>();
        stack.push(row + "," + col);
        while (!stack.isEmpty()){
            String str = stack.pop();
            if (visited.contains(str)) continue;
            visited.add(str);
            List<String > list = getNeighbours(matrix, Integer.parseInt(str.split(",")[0]), Integer.parseInt(str.split(",")[1]));
            for (String st :list
                 ) {
                String[] s = st.split(",");
                int i = Integer.parseInt(s[0]);
                int j = Integer.parseInt(s[1]);
                if (matrix[i][j]!=1 ){
                    continue;
                }
                stack.push(st);
            }

        }
    }
    List<String > getNeighbours(int[][]matrix, int row, int col){
        int numRows= matrix.length-1;
        int numCol= matrix[0].length-1;

        List<String> list=  new ArrayList<>();
        if (row-1 >0 ){
            list.add(row-1 + "," + col);
        }
        if (row+1 < numRows){
            list.add(row+1 + "," + col);
        }
        if (col-1 >0 ){
            list.add(row+","+(col-1));
        }
        if (col+1 < numCol ){
            list.add(row+","+(col+1));
        }

        return list;
    }

    static boolean traverseGraph(int[][]matrix, int row, int col, Set<String>visited) {
        if ((row < 0 || row > matrix.length - 1 || col < 0 || col > matrix[0].length - 1)) {
            return false;
        }
        /*if ((row == 0 || row == matrix.length - 1 || col == 0 || col == matrix[0].length - 1)) {
            return false;
        }*/

        if (visited.contains(row + "," + col)){
            return false;
        }
        if (matrix[row][col] == 1) {
            matrix[row][col] = 5;
        }
        visited.add(row + "," + col);
        return traverseGraph(matrix, row-1,col,visited)
                && traverseGraph(matrix, row+1,col,visited)
                && traverseGraph(matrix, row,col-1,visited)
                && traverseGraph(matrix, row,col+1,visited);
        /*if(!traverseGraph(matrix, row-1,col,visited)){
            if (matrix[row-1][col]==5){
                matrix[row-1][col]=9;
            }
        }
        if(!traverseGraph(matrix, row+1,col,visited)){
            if (matrix[row+1][col]==5){
                matrix[row+1][col]=9;
            }
        }
        if(!traverseGraph(matrix, row,col-1,visited)){
            if (matrix[row][col-1]==5){
                matrix[row][col-1]=9;
            }
        }
        if(!traverseGraph(matrix, row,col+1,visited)){
            if (matrix[row][col+1]==5){
                matrix[row][col+1]=9;
            }
        }

        return true;*/
    }

    public static void main(String[] args) {
        RemoveIsland r= new RemoveIsland();
        int[][] arr = new int[][]{
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };

        printMatrix(arr);
        System.out.println();
        System.out.println();
        printMatrix(r.removeIslands(arr));
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
