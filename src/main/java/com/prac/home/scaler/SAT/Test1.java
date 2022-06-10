package com.prac.home.scaler.SAT;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(subArrayWithSumZero(new int[]{Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE
,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE
,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE
                ,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE
                ,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE
                ,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE
                ,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE
                ,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE
                ,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE

        }));
    }

    static int subArrayWithSumZero( int [] A){
        Set<Long> set= new HashSet<>();
        long sum =0;
        for(int i=0; i< A.length; i++){
            sum+=A[i];
            if (set.contains(sum)|| A[i]==0|| sum==0){
                return 1;
            }
            set.add(sum);
        }
        return 0;
    }

}
