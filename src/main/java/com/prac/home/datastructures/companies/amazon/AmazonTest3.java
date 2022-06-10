package com.prac.home.datastructures.companies.amazon;

import java.text.DecimalFormat;
import java.util.*;

public class AmazonTest3 {
    public static void main(String[] args) {
        //System.out.println(findRepeat(1,3));
        System.out.println(project(new long[]{36 ,20, 33, 29, 7 ,33, 8, 40, 5 ,2 ,16}, new long[]{46, 11, 10, 45, 3 ,38, 32, 8 ,15 ,26},2 ));
    }
    static int findRepeat(int p , int q){
        Double d = ((double) 7/(double) 3);
        DecimalFormat df = new DecimalFormat("#.#########");
        String numberD = String.valueOf(df.format(d));
        numberD = numberD.substring((numberD.indexOf("."))+1);
        System.out.println(numberD);
        Long l = new Long(numberD );
        Map<Integer, Integer> map = new HashMap<>();

        return l.intValue();
    }

    static
    long project(long algoExperts[], long Developers[], int n){
        long[] newAlgo= new long[algoExperts.length-1];
        long min= Integer.MAX_VALUE;
        int minIdx= -1;

        for (int i=0; i< Developers.length; i++){
            long value1= Developers[i]* algoExperts[i];
            long value2= Developers[i]* algoExperts[i+1];
            if (min> value1 || min> value2){
                minIdx=i;
                min= value1>value1? value2:value1;
            }
        }



        List<Long> lis = new ArrayList<>();
        for (int i=0; i< algoExperts.length; i++){
            if (i!=minIdx){
                lis.add(algoExperts[i]);
            }
        }
        for (int i=0; i< newAlgo.length; i++){
            newAlgo[i]= lis.get(i);
        }
        long sum=0;
        for (int i=0; i< newAlgo.length; i++){
            sum= sum+(newAlgo[i]*Developers[i]);
        }
        return sum;
    }
}
