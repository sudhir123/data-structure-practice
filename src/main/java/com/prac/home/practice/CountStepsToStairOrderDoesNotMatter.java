package com.prac.home.practice;

public class CountStepsToStairOrderDoesNotMatter {
    public static void main(String[] args) {

    }
    Long countWays(int m) {
        if (m==0 || m==1 ) return 1l;

        return countWays(m-2)+1;
    }
}
