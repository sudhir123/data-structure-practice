package com.prac.home.algoexpert.medium;

import java.util.*;

/**
 * two dimensional matrix n*m will be in put to method and get linear array , which has element traversed in spiral shape.
 * Sprial is basically from 00 --> till end in same row than that column till end
 */
public class SpiralTraverse {
    // solution 1 not good
    /*public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> list = new ArrayList<>();
        Set<ElementTracker> unique= new HashSet<>();
        int x =0; int y=0;

        while ((x< array.length && y < array[0].length) && !unique.contains(new ElementTracker(x,y))){
            y = increaseY(array, x, y, unique, list);
            x= increaseX(array,x+1, y, unique, list );
            y= decreaseY(array, x, y-1, unique, list);
            x= decreaseX(array, x-1, y, unique, list);
            y++;
        }
        return list;
    }

    static int increaseX(int[][] array, int x, int yConst, Set<ElementTracker> set, List<Integer> list){
        while (x< array.length && !set.contains(new ElementTracker(x,yConst))){
            list.add(array[x][yConst]);
            ElementTracker e = new ElementTracker(x,yConst);
            set.add(e);
            x++;
        }
        return x-1;
    }

    static int increaseY(int[][] array, int xConst, int y, Set<ElementTracker> set, List<Integer> list){
        while (y< array[0].length && !set.contains(new ElementTracker(xConst,y))){
            list.add(array[xConst][y]);
            ElementTracker e = new ElementTracker(xConst,y);
            set.add(e);
            y++;
        }
        return y-1;
    }

    static int decreaseX(int[][] array, int x, int yConst, Set<ElementTracker> set, List<Integer> list){
        while (x>= 0 && !set.contains(new ElementTracker(x,yConst))){
            list.add(array[x][yConst]);
            set.add(new ElementTracker(x,yConst));
            x--;
        }
        return x+1;
    }

    static int decreaseY(int[][] array, int xConst, int y, Set<ElementTracker> set, List<Integer> list){
        while (y>= 0 && !set.contains(new ElementTracker(xConst,y))){
            list.add(array[xConst][y]);
            set.add(new ElementTracker(xConst,y));
            y--;
        }
        return y+1;
    }

    static class ElementTracker{
        int x; int y; boolean visited;
        ElementTracker(int x, int y ){
            this.x=x;
            this.y=y;
            this.visited=false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ElementTracker that = (ElementTracker) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }*/

    // algoexpert solution1 iterative
    /*public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int startRow=0, endRow=array.length-1;
        int startColumn=0, endColumn= array[0].length-1;

        while (startRow<=endRow && startColumn<=endColumn){
            *//**
             * multiple for loops, we can track values by incrementing an decrementing the array parametetrs
             * and we dont need hashset to track it.
             *//*
            for (int c = startColumn ;c<=endColumn; c++){
                list.add(array[startRow][c]);
            }
            for (int r=startRow+1 ;r<=endRow; r++){
                list.add(array[r][endColumn]);
            }
            for (int c = endColumn-1;c>=startColumn; c--){
                if (startRow==endRow) break;
                list.add(array[endRow][c]);
            }
            for (int r= endRow-1;r>=startRow+1; r--){
                if (startColumn==endColumn) break;
                list.add(array[r][startColumn]);
            }
            startRow= startRow+1; startColumn= startColumn+1; endColumn= endColumn-1; endRow= endRow-1;
        }
        return list;
    }*/

    // algoexpert solution2 recursive.

    /**
     * very simple and kinda same logic as we in iterative one. we need base condition to return. Like we have while loop.
     * we will have here one condition. and in end of while loop we adjust parameters value, we will do those same by passing value
     */
    public static List<Integer> spiralTraverse(int[][] array) {
        int startRow=0, endRow=array.length-1;
        int startColumn=0, endColumn= array[0].length-1;
        List<Integer> list = new ArrayList<>();
        recursiveSolution(array, startRow, endRow, startColumn, endColumn, list);
        return list;
    }

    static void recursiveSolution(int[][] array, int startRow, int endRow, int startColumn, int endColumn, List<Integer> list){
        if (startRow> endRow || startColumn> endColumn) return;
        for (int c = startColumn ;c<=endColumn; c++){
            list.add(array[startRow][c]);
        }
        for (int r=startRow+1 ;r<=endRow; r++){
            list.add(array[r][endColumn]);
        }
        for (int c = endColumn-1;c>=startColumn; c--){
            if (startRow==endRow) break;
            list.add(array[endRow][c]);
        }
        for (int r= endRow-1;r>=startRow+1; r--){
            if (startColumn==endColumn) break;
            list.add(array[r][startColumn]);
        }
        recursiveSolution(array,startRow+1,endRow-1, startColumn+1, endColumn-1, list);
    }

    public static void main(String[] args) {
        //int [] a = {27, 12, 35, 26, 25, 21, 94, 11, 19, 96, 43, 56, 55, 36, 10, 18, 96, 83, 31, 94, 93, 11, 90, 16};
        int [] a= {1, 3, 2, 5, 4, 7, 6};
        int [][] arr = new int[1][7];
        int num=0;
        for (int i =0; i < arr.length; i++){
            for (int j =0; j < arr[0].length; j ++){
                arr[i][j]=a[num];
                num++;
            }
        }
        for (int i =0; i < arr.length; i++){
            for (int j =0; j < arr[0].length; j ++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        /*int [][] arr = new int[1][1];
        arr[0][0]=1;
        int num=0;*/

        System.out.println(spiralTraverse(arr));
    }
}
