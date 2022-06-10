package com.prac.home.algoexpert.hard;

import java.util.*;

/**
 * sudolu is famous number game. total 9 -> 3*3 matrix  basically 9*9 grid .. we need to fill each row and column such now row has same digit
 * so does no column has same digit. Digits available to use are between 1-9 only. few number already filled
 */
public class SolveSudoku {
    public static void main(String[] args) {
        SolveSudoku s = new SolveSudoku();
        List<List<Integer>> boardList = Arrays.asList(
                Arrays.asList(7, 8, 0, 4, 0, 0, 1, 2, 0),
                Arrays.asList(6, 0, 0, 0, 7, 5, 0, 0, 9),
                Arrays.asList(0, 0, 0, 6, 0, 1, 0, 7, 8),
                Arrays.asList(0, 0, 7, 0, 4, 0, 2, 6, 0),
                Arrays.asList(0, 0, 1, 0, 5, 0, 9, 3, 0),
                Arrays.asList(9, 0, 4, 0, 6, 0, 0, 0, 5),
                Arrays.asList(0, 7, 0, 3, 0, 0, 0, 1, 2),
                Arrays.asList(1, 2, 0, 0, 0, 7, 4, 0, 0),
                Arrays.asList(0, 4, 9, 2, 0, 6, 0, 0, 7)
        );
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        for (int row=0; row< 9; row++){
            ArrayList<Integer> r= new ArrayList();
            board.add(r);
            for (int col=0; col< 9; col++){
               board.get(row).add(boardList.get(row).get(col));
            }
        }
        s.print(board);
        System.out.println();
        s.print(s.solveSudoku(board));
    }
    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        solvePartialSudoku(0,0,board);
        return board;
    }

    public boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board){
        int currentRow= row;
        int currentCol= col;
        if (currentCol== board.get(currentRow).size()){
            currentRow+=1;
            currentCol=0;

        }
        if (currentRow== board.size()){
            return true;
        }
        if (board.get(currentRow).get(currentCol)==0){
            return tryDigitAtPosition(currentRow, currentCol, board);
        }
        return solvePartialSudoku(currentRow, currentCol+1, board);
    }

    public boolean tryDigitAtPosition(int row, int col,  ArrayList<ArrayList<Integer>> board){
        for (int digit=1; digit< 10; digit++){
            if(isValid(digit, row, col, board)){
                board.get(row).set(col, digit);
                if (solvePartialSudoku(row, col+1, board)) {
                    return true;
                }
            }
        }
        board.get(row).set(col,0);
        return false;
    }

    public boolean isValid(int digit, int row, int col,  ArrayList<ArrayList<Integer>> board){
        boolean rowValid= board.get(row).contains(digit);
        boolean colValid = true;

        if (!rowValid || !colValid) return false;

        int subGridRowStart= (row/3) *3;
        int subGridCOlStart= (col/3)*3;


        for (int rowIdx=0; rowIdx < 3; rowIdx++){
            for (int colIdx =0; colIdx<3; colIdx++){
                int rowToCheck = rowIdx+subGridRowStart;
                int colToCheck = colIdx+subGridCOlStart;
                if (digit== board.get(rowToCheck).get(colToCheck)){
                    return false;
                }
            }
        }
        return true;
    }










    public void print(ArrayList<ArrayList<Integer>> board){
        for (int row=0; row< 9 ; row++) {
            System.out.println();
            for (int col = 0; col < 9; col++) {
                System.out.print(board.get(row).get(col)+",");
            }
        }
    }
    /*public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {

        for (int row=0; row< 9 ; row++){
            for (int col=0; col< 9 ; col++){
                if (board.get(row).get(col)==0){
                        fillNum(board, row, col);
                }
            }
        }
        return board;
    }*/
    public void fillNum (ArrayList<ArrayList<Integer>> board, int row, int col){
        for (int num=1; num<10; num++){
            if ( rowValidation(board, row, num) && columnValidation(board, col, num) && gridValidation(board, row, col, num) ){
                board.get(row).set(col, num);
                return;
            }
        }
    }

    public boolean rowValidation(ArrayList<ArrayList<Integer>> board, int row, int num){
        for (int col=0; col< 9 ; col++){
            if (num== board.get(row).get(col)){
                return false;
            }
        }
        return true;
    }

    public boolean columnValidation(ArrayList<ArrayList<Integer>> board, int col, int num){
        for (int row=0; row< 9 ; row++){
            if (num== board.get(row).get(col)){
                return false;
            }
        }
        return true;
    }

    public boolean gridValidation(ArrayList<ArrayList<Integer>> board , int row, int col, int num){
        int subGridRow = (row/3)*3;
        int subGridCol = (col/3)*3;

        for (int i=subGridRow; i< subGridRow+3; i++){
            for (int j = subGridCol ; j< subGridCol+3; j++){
                if (num == board.get(i).get(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
