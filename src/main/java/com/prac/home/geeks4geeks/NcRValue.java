package com.prac.home.geeks4geeks;

import java.util.Map;

public class NcRValue {
    public static int nCrModp(int n, int r){
        // your code here
        return -1;
    }

    public static int factorial(int n, Map<Integer, Integer> map){
        if (n==0 || n==1) return 1;
        return -1;
    }

    int convertfive(int num) {
        String str = ""+num;
        char[] arr= str.toCharArray();
        for (int i=0; i< str.length(); i++){
            if (arr[i]==0){
                arr[i]= 5;
            }
        }
        String s = new String(arr);
        return Integer.parseInt(s);
    }

}
