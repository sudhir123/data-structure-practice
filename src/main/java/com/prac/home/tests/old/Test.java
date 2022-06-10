package com.prac.home.tests.old;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

            List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        System.out.println(sumOfInteger(list).get());
    }

    /**
     *
     * @param list
     * @return
     */
    public static Optional<Integer> sumOfInteger(List<Integer> list ){
        return list.stream().reduce(Math::addExact);

        /*Integer number=0;
        if(list!=null) {
            for (Integer i : list
            ) {
                if(i!=null){
                    number = number + i;
                }
            }
        }
        return number;*/
    }

}
