package com.prac.home.algoexpert.easy;

import java.util.Arrays;

/**
 * given a non empty array of positive integers representing time to execute queries. At one time one query, there are multiple
 * queries and in any order.Second is waiting time. Lets says a query is scheduled to run at third, than its waiting time is sum of
 * time for first and second query.
 */
class MinimumWaitingTime{
    /*public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int[] sumArr= new int[queries.length];
        int sum=0;
        for (int i =1; i <queries.length; i ++){
            sum=sum+queries[i-1];
            sumArr[i]=sum;
        }
        int finalSum=0;
        for (int i =0; i<sumArr.length; i++ ){
            finalSum+=sumArr[i];
        }
        return finalSum;
    }*/

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWaitingTime =0;
        for (int i =0; i <queries.length; i ++){
            int duration = queries[i];
            int queriesLeft = queries.length -(i+1);
            totalWaitingTime+= duration*queriesLeft;
            // how this works is ... lets say we are forst element which takes 1 sec. Now all the element in the arrays
            // need to wait for 1sec. similarly 2nd query takes ..3sec... that means rest all emenet needs to wait for 3 sec.
            // adding all these will get us the actual waiting time.
        }
        return totalWaitingTime;
    }
    public static void main(String[] args) {
        MinimumWaitingTime m= new MinimumWaitingTime();
        System.out.println(m.minimumWaitingTime(new int[]{3, 2, 1, 2, 6}));
    }
}