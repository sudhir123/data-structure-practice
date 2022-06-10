package com.prac.home.algoexpert.medium;

/**
 * given only x, y cordinate of a point where we need to reach from 0,0. We just need to find the number of ways.
 * 13-Nov-2021
 */
public class NumberOfWaysToTraverseAGraph {


    //recursion very bad way O(2^(n+m)) because everytime we have to look for two ways up and left
   /* public static int numberOfWaysToTraverseGraph(int width, int height) {
        if (width==1 || height==1)
            return 1;

        int left= numberOfWaysToTraverseGraph(width-1, height);
        int up= numberOfWaysToTraverseGraph(width, height-1);
        return left+up;
    }*/
// best way is o(n^2)
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        int i =0, j =1;
        int[][] dimensions = new int[height][width];
        for (; j <width; j++){
            dimensions[i][j]=1;
        }
        i =1; j =0;
        for (; i <height; i++){
            dimensions[i][j]=1;
        }
        ; ;
        for (i =1;i <height; i++){
            for (j =1; j <width; j++){
                dimensions[i][j]= dimensions[i-1][j]+ dimensions[i][j-1];
            }
        }
        return dimensions[height-1][width-1];
    }
    //
    /*static int graphTraversalUsingDynamicProg (int width, int height, int[][]dimension){

    }
*/
    public static void main(String[] args) {
        System.out.println(numberOfWaysToTraverseGraph(4,3));
    }
}
