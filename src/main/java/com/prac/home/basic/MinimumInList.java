package com.prac.home.basic;

import java.util.*;

public class MinimumInList {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer expectedResult = 89;

        // then
        Integer max = listOfIntegers
                .stream()
                .mapToInt(v -> v) //  converts the stream to IntStream and calling Max function
                .max().orElseThrow(NoSuchElementException::new);
        System.out.println(max);

        Optional<Integer> min=listOfIntegers.stream().min(Comparator.comparing(Integer::intValue));
        System.out.println(min.get());
    }
}
