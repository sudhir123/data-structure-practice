package com.prac.home.practice;

import java.util.*;

/**
 * u be given an number n , with that you can generate 2^n-1 integers in binary. Problem is to arrange those numbers in sucha way they follow below
 * 4 conditions. Each number is differed by only 1 digit with preveious and next.last and first also by one digit
 * example n=2 2^2-1 -> 3 .. 0,1,2,3 [ 00 ,01, 10, 11] but first and last in this case will be 2 digit differnce , so order will be
 * [00,01, 11, 10] o/p
 */
public class GreyCode {
    public static void main(String[] args) {
        GreyCode g = new GreyCode();
        System.out.println(g.grayCode(3));
    }
    /*
    way to solve this problem is we just need to add o and 1 as prefix to the n-1 bit solution.
    / so basically starr with 1 bit solution which is 0,1 right , not make another reverse list, now add to to one list and add 1 to another
    and merge them.
     */
    List<Integer> grayCode(int n) {
        // declare 1 bit solution
        List<String> result= new ArrayList<>();
        result.add("0");
        result.add("1");
        int bit = 1;
        while (bit<n) {
            bitSolution(result);
            bit++;
        }
        List<Integer> finalResult = new ArrayList<>();
        for (String num:result
             ) {
            char[] chars= num.toCharArray();
            int factor=1;
            int sum=0;
            for (int i=chars.length-1; i>=0 ;i--){
                if (i==chars.length-1){
                    factor=1;
                }else {
                    factor=factor*2;
                }
                sum= sum+ (chars[i]-'0')* factor;
            }
            finalResult.add(sum);
        }
        return finalResult;
    }
    public void bitSolution(List<String> result){
        List<String> copy= new ArrayList<>(result);
        List<String> reverse= new ArrayList<>(result);
        Collections.reverse(reverse);
        for (int i=0; i < result.size(); i++){
            copy.set(i, "0"+copy.get(i));
            reverse.set(i, "1"+reverse.get(i));
        }
        result.clear();
        result.addAll(copy);
        result.addAll(reverse);
    }

    //not correct way of solving this.
    /*public List<Integer> grayCode(int n) {
        List<List<Integer>> result =  new ArrayList<>();
        List<Integer> inputArray= new ArrayList<>();
        for (int i=0; i< n ; i++){
            inputArray.add(0);
        }
        permutations(inputArray, 0, result);
        return null;
    }*/
    static void permutations(List<Integer> array, int i, List<List<Integer>> result){
        /*if (i==array.size()-1){
            allPerms.add(new ArrayList(array));
        }*/
        for (int j = i; j<array.size(); j++){
            permutations(array, j+1, result);
            result.add(new ArrayList(array));
            flip(j,array);
        }
    }
    static void flip(int j, List<Integer> array) {
        if (array.get(j)==0){
            array.set(j,1);
        }else {
            array.set(j,0);
        }
    }

    static void swap(int i, int j , List<Integer> array){
        int temp = array.get(i);
        array.set(i,  array.get(j));
        array.set(j, temp);
    }
}
