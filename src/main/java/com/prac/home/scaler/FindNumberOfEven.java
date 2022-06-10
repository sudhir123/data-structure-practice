package com.prac.home.scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindNumberOfEven {
    public static void main(String[] args) {
        //System.out.println(maxMinMode(new int[]{1, 2, 44, 3}));
        //System.out.println(foo(3,5));
       /* System.out.println(findMinPath(new int[][]{
                {1,2,3},
                {1,2,3}
        }, 0,0));*/
        //FindNumberOfEven f= new FindNumberOfEven() ;
        //System.out.println(f.solve(new int[]{  33, 82, 75, 4, 52, 74, 79, 46, 18, 73, 1, 83, 46, 94, 44, 86, 40, 1, 46, 24, 99, 16, 88, 6, 66, 17, 1}));
    }
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int i=A.size()-1;
        int max= A.get(i);
        int secMax =  A.get(i);

        while (max==secMax && i>=0){
            i--;
            secMax= A.get(i);
        }
        return secMax%max ;

    }

    static int findMinPath(int[][] vec , int row, int col){
        if (row>= vec.length || col>= vec[0].length) return 10000;
        if (row==vec.length-1 && col==vec[0].length-1) return 0;
        System.out.println("print");
        return vec[row][col]+ Math.min(findMinPath(vec, row+1, col),findMinPath(vec, row, col+1));
    }

    public int solve(int[] A) {
        int evenCount=0, oddCount=0;
        for (int i=0; i <A.length; i++){
            if (A[i]%2==0) {
                evenCount+=1;
            }else {
                oddCount+=1;
            }
        }
        return Math.min(evenCount, oddCount);
    }

    static int bar(int x, int y){
        if (y==0) return 0;
        return x+ bar(x,y-1 );
    }
    static int foo(int x, int y){
        if (y==0) return 1;
        return bar(x, foo(x,y-1));
    }
}
