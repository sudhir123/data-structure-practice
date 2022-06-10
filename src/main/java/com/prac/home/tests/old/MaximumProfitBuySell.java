package com.prac.home.tests.old;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 *  every min you can buy sell or do nothing. In an array price of every min.
 *  if you are buying that number is multiplying by -1 and if you selling at that moment
 */
class Result {
    public static long maximumProfit(List<Integer> price) {

        // first thing id to break the list into multiple lists each will have ascending elements

        System.out.println(splitList(price,0));
        return 0;
    }

    static List<Integer> splitList(List<Integer> submittedList, int startIndex){
        List<Integer> retList= new ArrayList<>();
        for(; startIndex <=submittedList.size()-1; startIndex++){
            System.out.println("startIndex: "+startIndex+" && submittedList.size()-1: "+ submittedList.size());
            if(startIndex== (submittedList.size()-1)){
                if (submittedList.get(startIndex-1)< submittedList.get(startIndex)){
                    retList.add(submittedList.get(startIndex));
                }
            }
            else if (submittedList.get(startIndex)< submittedList.get(startIndex+1)){
                retList.add(submittedList.get(startIndex));
            }
            else{
                retList.add(submittedList.get(startIndex));
                break;
            }
        }
        return retList;
    }
    public static void main(String[] args) throws IOException {
        maximumProfit(Arrays.asList(100, 180, 260, 310, 40, 535, 695));
    }
}


