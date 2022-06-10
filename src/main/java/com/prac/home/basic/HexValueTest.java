package com.prac.home.basic;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HexValueTest {
    public static void main(String[] args) {

        aVeryBigSum();
        /*System.out.println((int)'A'); //65
        System.out.println((int)'Z');// 90
        System.out.println();
        System.out.println((int)'a'); // 97
        System.out.println((int)'z');// 122*/


    }

    public static void aVeryBigSum() {
        // Write your code here
        LocalDateTime localDateTime= java.time.LocalDateTime.now();
        System.out.println(localDateTime);
        List<Integer> list = new ArrayList<>();
        for (int i=0; i <100000; i ++){
            list.add(i);
        }
        localDateTime= java.time.LocalDateTime.now();
        System.out.println(localDateTime);


        list.add(50000,200000);
        LocalDateTime localDateTime2= java.time.LocalDateTime.now();
        System.out.println(localDateTime2);

        list.add(200001);
        System.out.println(java.time.LocalDateTime.now());
    }
    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        LocalDateTime localDateTime= java.time.LocalDateTime.now();
        System.out.println(localDateTime);
        List<Integer> list = new ArrayList<>();
        for (int i=0; i <1000000; i ++){
            list.add(i);
        }
        localDateTime= java.time.LocalDateTime.now();
        System.out.println(localDateTime);

        return ar.parallelStream().mapToLong(Long::longValue).sum();
    }
}
