package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(getPermutations(Arrays.asList(1,2,3)));
    }

    // same thing for leet code

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(array, 0, result);
        return result;
    }

    // time conplexity is very bad to understand time complexity ... when we have one element in an array, we will have 1 permutation.
    // when we have 2 --> we will have 2 permutations 1,2 and 2,1. when we have 3 we will have 6 permutations. so basically n! times something
    // now in this case we will have n! leave to this tree.that is we n! time we will hit our base case of else. apart form this , in IF statament
    // copy new array from old is (n) so minimum i tcan think of O(n time n!)..simlarly we have space we are saving
    public static void permutations(List<Integer> array, int i, List<List<Integer>> result) {
       if (i==array.size()-1){
           List<Integer> copy = new ArrayList<>(array);
           result.add(copy);
       }else {
           for (int j=i; j <array.size(); j++){
               swap(array, i, j);
               permutations(array, i+1 , result);
               swap(array, i, j);
           }
       }
    }

    static void swap(List<Integer> array, int i, int j){
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j , temp);
    }
}
