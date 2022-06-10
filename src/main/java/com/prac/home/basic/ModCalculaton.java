package com.prac.home.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ModCalculaton {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(21);
        array.add(32);
        array.add(43);
        array.add(54);
        array.add(65);
        int maxNumber = Collections.max(array);
        int digit=0;
        while ((maxNumber/(int)Math.pow(10, digit))>0){
            System.out.println((maxNumber/Math.pow(10, digit)));
            digit+=1;
        }
    }

    static void countDigits(ArrayList<Integer> array, int[] countArray, int digit){
        int mod=digit*10;
        for (Integer number: array
        ) {
            int modDigits = number%mod;
            modDigits= modDigits/digit;
            countArray[modDigits]= countArray[modDigits]+1;
        }
    }
}
