package com.prac.home.basic;

import java.util.*;
import java.util.stream.Collectors;

public class SetWithIntegerArray {
    public static void main(String[] args) {

        List<Integer[]> list= Arrays.asList(new Integer[]{-8, 3, 5},new Integer[]{-8, 2, 6}, new Integer[]{-6, 7, 5});

        list.stream().forEach(x->{
            System.out.println(Arrays.toString(x));
        });
        System.out.println();
        System.out.println();
        Collections.sort(list, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                // Sort the lists using the starting position (second element in the list)
                return o1[1].compareTo(o2[1]);
            }
        });


        list.stream().forEach(x->{
            System.out.println(Arrays.toString(x));
        });

        /*Set<Integer[]> set = new HashSet<>();
        Integer[] intArr= new Integer[]{-8,5,3};
        set.add(intArr);
        if (set.contains(new Integer[]{-8,5,3})){
            System.out.println(true);
        }else
            System.out.println(false);

        Set<List<Integer>> set2 = new HashSet<>();
        List<Integer> intList= Arrays.asList(-8,5,3);
        set2.add(intList.stream().sorted().collect(Collectors.toList()));
        if (set2.contains(Arrays.asList(5,-8,3).stream().sorted().collect(Collectors.toList()))){
            System.out.println(true);
        }else
            System.out.println(false);*/
    }
}
