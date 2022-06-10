package com.prac.home.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomClass {
    public static void main(String[] args) {
        //Random r = new Random();
        //System.out.println(r.nextInt(10));
        List<Integer> a= Arrays.asList(48,12,24,7,8,-5,24,391,24,56,2,6,8,41);
        List<Integer> b= new ArrayList<>(a);
        b.add(12);
    }
}
