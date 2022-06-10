package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #Array
 * travers n*m matrix in zig zag manner. n could be equal to m.
 *      {1, 3, 4, 10],
 *      {2, 5, 9, 11],
 *      [6, 8, 12, 15],
 *      [7, 13, 14, 16]  and output will be 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
 */
public class ZigZagTraverse {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> results= new ArrayList<>();
        int height = array.size()-1;
        int width = array.get(0).size()-1;
        int row=0; int col=0;
        boolean goingDown= true;
        while (!isOutOfBound(row, col, height, width)){
            results.add(array.get(row).get(col));
            if (goingDown){// row increase
                if (row==height || col==0) {
                    goingDown = false;
                    if (row==height){
                        col++;
                    }else {
                        row++;
                    }
                }else {
                    row++;
                    col--;
                }
            }else {
                if (row==0 || col==width){
                    goingDown=true;
                    if (col==width){
                        row++;
                    }else {
                        col++;
                    }
                }else {
                    col++;
                    row--;
                }
            }
        }
        return results;
    }

    static boolean isOutOfBound(int row, int col, int height, int width){
        return row<0 || row> height || col<0 || col >width;
    }

    static void traverTillReverseElement(int xCordinate, int yCordinate, List<List<Integer>>array){
        int numberOfElement=0; boolean xInc=true;
        while (numberOfElement < (array.size()* array.get(0).size())) {
            int x=xCordinate, y=yCordinate;
            if (xInc){
                while (x < array.size() && x <=yCordinate ){
                    System.out.print(array.get(x).get(y) +" ");
                    x++;
                    if (y>0){
                        y--;
                    }
                    numberOfElement++;
                }
                xCordinate=x; yCordinate=y;
                xInc=false;
            }else {
                while (y < array.get(0).size() && y<=xCordinate){
                    numberOfElement++;
                    System.out.print(array.get(x).get(y)+" ");
                    if (x >0){
                        x--;
                    } y++;
                }
                xCordinate=x; yCordinate=y;
                xInc=true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 3, 4, 10},
                {2, 5, 9, 11},
                {6, 8, 12, 15},
                {7, 13, 14, 16}
        };
        List<List<Integer>> list= new ArrayList<>();
        for (int[] arr: array
             ) {
            List<Integer> l= new ArrayList<>();
            for (int i =0; i <arr.length; i++){
                l.add(arr[i]);
            }
            list.add(l);
        }
        System.out.println(zigzagTraverse(list));
    }

}
