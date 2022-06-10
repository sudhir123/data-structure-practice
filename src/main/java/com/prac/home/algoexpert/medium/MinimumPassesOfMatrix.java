package com.prac.home.algoexpert.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * given a 2-D matrix , which has +ves and -ve number. Minimum how many pass it will take to convert all numbers to positive.
 * One pass is counted , when you convert few and in second pass few more.
 * it could be minimum one conversion to increment pass
 */
public class MinimumPassesOfMatrix {

    public int minimumPassesOfMatrix(int[][] matrix) {

        Queue<String> queue= new LinkedList<>();
        for (int row=0; row<matrix.length; row++){
            for (int col=0; col< matrix[0].length; col++){
                if (matrix[row][col]>0){
                    String rowCol = row+"-"+col;
                    queue.add(rowCol);
                }
            }
        }
        int pass=0;
        Queue<String> queueForChild= new LinkedList<>();
        while (!queue.isEmpty()){
            String[] rowCol= queue.poll().split("-");
            int row = Integer.parseInt(rowCol[0]);
            int col = Integer.parseInt(rowCol[1]);
            addChild(row, col, matrix, queueForChild);
            if (queue.isEmpty() && !queueForChild.isEmpty()){
                queue= new LinkedList<>(queueForChild);
                queueForChild.clear();
                pass+=1;
            }
        }
        for (int row=0; row<matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col]<0)
                    return -1;
            }
        }
        return pass;
    }

    public void addChild(int r, int c, int[][]matrix, Queue<String> queue){
        if (r-1>=0 && matrix[r-1][c] <0) {
            matrix[r-1][c]= matrix[r-1][c]*-1;
            queue.add(r - 1 + "-" + c);
        }

        if (r+1 <matrix.length && matrix[r+1][c] <0){
            matrix[r+1][c]= matrix[r+1][c]*-1;
            queue.add(r+1+"-"+c);
        }

        if (c-1 >=0 && matrix[r][c-1] <0){
            matrix[r][c-1] = matrix[r][c-1]*-1;
            queue.add(r+"-"+(c-1));
        }

        if (c+1<matrix[0].length && matrix[r][c+1] <0){
            matrix[r][c+1]= matrix[r][c+1]*-1;
            queue.add(r+"-"+(c+1));
        }

    }

    public static void main(String[] args) {
        MinimumPassesOfMatrix m = new MinimumPassesOfMatrix();
        System.out.println(m.minimumPassesOfMatrix(new int[][]{
                {-1, 0, 3},
                {0, -5, -6}
        }));

    }
}

























