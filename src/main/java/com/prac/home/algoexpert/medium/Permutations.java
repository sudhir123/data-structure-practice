package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * kinda very specific algorithm to learn. must watch video again
 */
public class Permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations =  new ArrayList<>();
        //helper(array, new ArrayList<>(), permutations);
        helper(array,0,permutations);
        return permutations;
    }
    // first approach
    static void helper(List<Integer> array, List<Integer> currentPerm, List<List<Integer>> permutations){
        if (array.size()==0 && currentPerm.size()>0) {
            permutations.add(currentPerm);
        } else {
            for (int i=0; i< array.size(); i++){
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPerm= new ArrayList<>(currentPerm);
                newPerm.add(array.get(i));
                helper(newArray,newPerm,permutations);
            }
        }
    }

    // second approach to save space. time complexity is 2^(n) because at every charachter we are in position to take that or not.
    // if there are two such strings to compare , we will have 2^ (n+m)
    static void helper(List<Integer> array, int i, List<List<Integer>> permutations){
        if (i== array.size()-1) permutations.add(new ArrayList<>(array));
        else {
            for (int j=i; j< array.size(); j++){
                swap(array,i, j);
                helper(array, i+1, permutations);
                swap(array, i, j);
            }
        }
    }

    static void swap(List<Integer> array, int i , int j){
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void main(String[] args) {
        System.out.println(getPermutations(Arrays.asList(1,2,3)));
    }
}
