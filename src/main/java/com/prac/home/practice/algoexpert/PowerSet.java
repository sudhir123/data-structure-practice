package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// power set is set of all subsets [1,2,3 ] --> [] [1] [1,2 ] [2] [3] [1,2,3][ 1,3 ][2,3]
public class PowerSet {
    public static void main(String[] args) {
        System.out.println(powerset(Arrays.asList(1,2,3)));
    }

    // do it via recusion
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();

        return result;
    }

    public static List<List<Integer>> power_Set(List<Integer> array,List<List<Integer>> result,  int idx) {
        return result;
    }


    public static List<List<Integer>> power_Set_Without_Recursion(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (Integer num: array
             ) {
            result= sets(result, num);
        }
        return result;
    }

    public static List<List<Integer>>  sets(List<List<Integer>> result , int num) {
        List<List<Integer>> resultCopy= new ArrayList<>(result);
        for (List<Integer> list : result
             ) {
            List<Integer> copy = new ArrayList<>(list);
            copy.add(num);
            resultCopy.add(copy);
        }
        return resultCopy;
    }
}
