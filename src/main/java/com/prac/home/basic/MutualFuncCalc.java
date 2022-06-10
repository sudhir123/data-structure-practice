package com.prac.home.basic;

public class MutualFuncCalc {
    static int yealyInvest = 20000;
    static int total =0;
    public static void main(String[] args) {
        for(int year=1; year <=20; year++){
            total= total+ ((yealyInvest+5000)*12);
        }
        System.out.println(total); // 60 lacks -> 10 cr
    }
}
