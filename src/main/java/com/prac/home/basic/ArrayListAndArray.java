package com.prac.home.basic;

import java.util.*;

public class ArrayListAndArray {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists= new ArrayList<>();
        ArrayList a2= new ArrayList();
        a2.add(1);a2.add(2);a2.add(3);
        lists.add(a2);
        System.out.println(lists.toArray());
       // int[][] list = new int[][]
    }
}
