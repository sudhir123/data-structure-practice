package com.prac.home.datastructures.array.basics;

/**
 * basically count how many 5's ...remember 25 -> 5*5 ... and also 10 , 20 ...
 */
public class CountZerosInFactorial {
    // #mythinking. Multiples of 5. but not a good way two loops
    static int countZeros(int number){
        int counter =0;
        for (int i =1; i <= number; i++){
            counter=counter+divideByFive(i, 0);
        }
        return counter;
    }
    static int divideByFive(int number, int counter){
        //if (number%5==0)
         //   counter= divideByFive(number/5,counter=counter+1);
        // another way
        while (number%5==0){
            counter++;
            number= number/5;
        }
        return counter;
    }
    // lets try in 1 loop
    static int countZerosSolution2(int number){
        int counter =0;
        for (int i =5; i <= number; i=i*5){
            counter=counter+number/i;
        }
        return counter;
    }

    public static void main(String[] args) {
        //System.out.println(countZeros(25));
        //System.out.println(divideByFive(25,0));

        System.out.println(countZerosSolution2(125));
    }
}
