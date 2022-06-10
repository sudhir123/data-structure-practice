package com.prac.home.algoexpert.medium;

import java.sql.SQLOutput;

/**
 * few cities connected in circlular road, which can be run clockwise. Each city has gas station. you can choose any city to fue
 * and run the car and got to next. keep on doing untill you be back at the starting point. That city is Valid city.
 * IN question it can be one only.
 * give an distances array where i city is distance[i] from i+1 city. Another array is a fuel array , which fuel[i]
 * is number of fue available at i city. for question sum f all elements are enought to travel to all the city.
 * another parameter is miles per gallon u can travel
 */
public class ValidStartingCity {

    /*public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        float remainingFuel=0; int i=0; int start=0;
        int nextIdx = 0;
        System.out.println("Start Idx ="+start);
        while (i <distances.length){
            float fuelRequired= (distances[nextIdx]/(float)mpg);
            System.out.println("Fuel Req :- "+ fuelRequired);
            float fuelCurrently= fuel[nextIdx]+remainingFuel;
            System.out.println("fuelCurrently := "+ fuelCurrently);
            if (fuelRequired < fuelCurrently){
                remainingFuel= fuelCurrently- fuelRequired;
                System.out.println("Remaining Fuel :- "+remainingFuel);
                nextIdx = getNextIdx(nextIdx, distances);
            }else {
                System.out.println("Break -------------------");
                nextIdx = getNextIdx(nextIdx, distances);
                start= nextIdx;
                System.out.println("Start Index now :- "+ start);
                i=0; remainingFuel=0;
            }
            i++;
        }
        return start;
    }

    int getNextIdx(int current , int[] distances){
        if (current==distances.length-1){
            current=0;
        }else {
            current+=1;
        }
        return current;
    }*/
    // O(n)
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int numberOdCities = distances.length;
        int milesRemaining=0;

        int indexOfStartingCity= 0;
        int milesRemainingAtStartingCity=0;
        for (int cityIdx =1; cityIdx< numberOdCities; cityIdx++){
            int distanceFromPreviousCity= distances[cityIdx-1];
            int fuelFromPreviousCity = fuel[cityIdx-1];
            milesRemaining+= (fuelFromPreviousCity* mpg) -distanceFromPreviousCity;

            if (milesRemaining< milesRemainingAtStartingCity){
                milesRemainingAtStartingCity= milesRemaining;
                indexOfStartingCity= cityIdx;
            }
        }
        return indexOfStartingCity;
    }


    public static void main(String[] args) {
        ValidStartingCity v= new ValidStartingCity();
        System.out.println(v.validStartingCity(
                new int []{30, 40, 10, 10, 17, 13, 50, 30, 10, 40},
                new int[] {1, 2, 0, 1, 1, 0, 3, 1, 0, 1},
                25));
    }
}
