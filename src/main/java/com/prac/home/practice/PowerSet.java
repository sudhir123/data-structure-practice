package com.prac.home.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * #Array
 * given and array of elements. generate all possible subsets, this will also include empty set.
 */
public class PowerSet {
    // best complexity O(n2^n) because at every element we have choince to include it in set or not , so 2^n and we n such element
    // n 2^n
    static List<List<Integer>> powerSet(int[] array){
        List<List<Integer>> sets = new ArrayList<>();
        List<Integer> emptySet = new ArrayList<>();
        sets.add(emptySet);
        for (int i =0; i <array.length; i++){
            int val= array[i];
            List<List<Integer>> newValSets= new ArrayList<>();
            for (List<Integer> set: sets
                 ) {
                List<Integer> cloneSet= new ArrayList<>(set);
                cloneSet.add(val);
                newValSets.add(cloneSet);
            }
            sets.addAll(newValSets);
        }
        return sets;
    }

    public static void main(String[] args) {
        System.out.println(powerSet(new int[]{1,2,3}));
    }
}
