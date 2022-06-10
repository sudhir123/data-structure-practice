package com.prac.home.practice.algoexpert;

import java.util.List;

public class ProductSum {
    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    public static int productSum(List<Object> array, int level) {
        int totalSum=0;
        for (Object o: array
             ) {
            if (o instanceof List){
               totalSum+= productSum((List<Object>) o, level+1);
            }else {
                totalSum+=(Integer)o;
            }
        }
        return totalSum*level;
    }
}
