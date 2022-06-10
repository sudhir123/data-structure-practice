package com.prac.home.algoexpert.hard;

import java.util.Arrays;

/**
 * #Array
 * write a function that takes in array of integers and returns the largest possible value for the expression
 * array[a] -array[b] + array[c]- array[d]
 */
public class MaximizeExpression {
    public static void main(String[] args) {
        MaximizeExpression m = new MaximizeExpression();
        System.out.println(m.maximizeExpression(new int[]{3, 6, 1, -3, 2, 7}));
    }
    // direct by algoexpert..
    // using dynamic prog... declare an array for a only and calculate max A possible ...not declare another array a-b only
    // this will give if a is some what b can be so that we have max a-b
    // then next array would be a-b+c
    // similarly a-b+c-d
    public int maximizeExpression(int[] array) {
        if (array.length<4) return 0;
        int[] a= array.clone();
        for (int i =1; i < a.length; i++){
            a[i]= Math.max(a[i], a[i-1]);
        }

        int[] ab =new int[array.length];
        Arrays.fill(ab, Integer.MIN_VALUE);
        int bIdx=1;
        for (int i =1; i < a.length; i++){
            if ((a[i-1]-array[i]) > ab[i-1]){
                bIdx= i;
            }
            ab[i]= Math.max((a[i-1]-array[i]),ab[i-1] );
        }

        int[] abc =new int[array.length];
        Arrays.fill(abc, Integer.MIN_VALUE);
        for (int i =2; i < a.length; i++){
            abc[i]= Math.max((ab[i-1]+array[i]),abc[i-1] );
        }

        int[] abcd =new int[array.length];
        Arrays.fill(abcd, Integer.MIN_VALUE);
        for (int i =3; i < a.length; i++){
            abcd[i]= Math.max((abc[i-1]-array[i]),abcd[i-1] );
        }
        return abcd[abcd.length-1];
    }
}

