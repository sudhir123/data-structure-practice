package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * generate all possible subsets of give array [1,2] -> [[],[1][2][12]] -- [1,2 and [2,1]] are the same
 */
public class PowerSet {

    public static List<List<Integer>> powerset(List<Integer> array) {

        //# way by algoexpert.
        // create an emprt subset add as empty list to main list. than traverse each subset in main list and add element to it.
        //for blank subset add new element.
        List<List<Integer>> powerSets = new ArrayList<>();
        powerSets.add(new ArrayList<>());

        for (Integer element: array
             ) {
            List<List<Integer>> sets = new ArrayList<>(powerSets);
            for (List<Integer> set: powerSets
                 ) {
                List<Integer> temp=new ArrayList<>(set);
                temp.add(element);
                sets.add(temp);
            }
            powerSets=sets;
        }
        return powerSets;

        /*Completly wrong way
        List<List<Integer>> sets= new ArrayList<>();
        generateSets(array, 0, array.size()-1, sets);
        return sets;*/
    }

    /*static void generateSets(List<Integer> array, int start, int end, List<List<Integer>> sets){
        if (start>end)
            return;
        List<Integer> list= new ArrayList<>();
        for (int i =start; i <=end; i ++){
            list.add(array.get(i));
        }
        int mid = (start+end)/2;
        sets.add(list);
        generateSets(array, start, mid-1, sets);
        generateSets(array, mid+1, end,sets );
    }*/

    public static void main(String[] args) {
        System.out.println(powerset(Arrays.asList(1,2,3)));
    }
}
