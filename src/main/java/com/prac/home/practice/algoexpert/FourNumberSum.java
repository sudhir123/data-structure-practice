package com.prac.home.practice.algoexpert;

import java.util.*;

public class FourNumberSum {
    public static void main(String[] args) {
        System.out.println(fourNumberSum_MyThinking(new int[]{7, 6, 4, -1, 1, 2}, 16));
    }
    public static List<Integer[]> fourNumberSum_MyThinking(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<Integer[]>> map= new HashMap<>();
        for (int i=0; i<array.length-1; i++){
            for (int j=i+1; j< array.length; j++) {
                int currentSum =array[i]+ array[j];
                int intrimTarget = targetSum-(currentSum);
                if (map.containsKey(currentSum)){
                    List<Integer[]> list =map.get(currentSum);
                    for (Integer[] existing:list
                    ) {
                        System.out.println(Arrays.toString(new Integer[]{existing[1], existing[0], array[i],array[j]}));
                        result.add(new Integer[]{existing[0], existing[1], array[i],array[j]});
                    }
                }else {
                    List<Integer[]> newList= new ArrayList<>();
                    Integer[] integers= new Integer[]{array[i], array[j]};
                    newList.add(integers);
                    map.put(intrimTarget, newList);
                }
            }
        }
        return result;
    }

    // way algo expert did this is:-
    // don't sort .. start first for loop and than start second for loop from the next number j=i+1 till end. and check if
    // (target -[i]+ [j]) already exists in map. if not keep on going , do not store that value like we do in two number sum.
    // we will store [i]+[j=i-1 till 0  reverse loop ] in map. This will avoid creating duplicates. Lets do this logic first and
    // then we will apply normal sorting and two number sum to understand this logic
    public static List<Integer[]> fourNumberSum_AlgoExpert(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<Integer[]>> map= new HashMap<>();

        for (int i=0; i<array.length-1; i++){
            for (int j=i+1; j< array.length; j++){
                int intrimTarget = targetSum-(array[i]+ array[j]);
                if (map.containsKey(intrimTarget)){
                    List<Integer[]> list =map.get(intrimTarget);
                    for (Integer[] existing:list
                         ) {
                        System.out.println(Arrays.toString(new Integer[]{existing[1], existing[0], array[i],array[j]}));
                        result.add(new Integer[]{existing[0], existing[1], array[i],array[j]});
                    }
                }
            }
            for (int j=0; j <i; j++){
                int currentSum= array[i]+ array[j];
                if (map.containsKey(currentSum)){
                    List<Integer[]> existingList= map.get(currentSum);
                    List<Integer[]> newList= new ArrayList<>();
                    for (Integer[] in :existingList
                            ) {
                        Integer[] integers= new Integer[]{in[0],in[1], array[i], array[j]};
                        newList.add(integers);
                    }
                    map.put(currentSum, newList);
                }else {
                    Integer[] integers= new Integer[]{array[i], array[j]};
                    List<Integer[]> list= new ArrayList<>();
                    list.add(integers);
                    map.put(currentSum, list);
                }
            }
        }

        return result;
    }
}
