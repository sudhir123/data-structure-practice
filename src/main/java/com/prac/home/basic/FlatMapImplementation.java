package com.prac.home.basic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMapImplementation {

    public static void main(String[] args) {
        List<List<String>> list= Arrays.asList(
                Arrays.asList("Sudhir1","Sudhir2"),
                Arrays.asList("Sudhir3", "Sudhir1"),
                Arrays.asList("Sudhir1", "Sudhir4"),
                Arrays.asList("Sudhir5", "Sudhir3")
                );

        Set<String> l= list.stream().flatMap(List::stream).collect(Collectors.toSet());
        l.forEach(System.out::println);

        LinkedList<Integer> list1[];
        list1= new LinkedList[3];

        IntStream.range(0,3).forEach( x-> {
            list1[x]= new LinkedList();
            list1[x].add(1);
            list1[x].add(2);
        }  );
        Set<Integer> l1= Arrays.stream(list1).flatMap(List::stream).collect(Collectors.toSet());
        l1.forEach(System.out::println);
    }
}
