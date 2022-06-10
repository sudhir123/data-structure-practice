package com.prac.home.basic;

public class StringSubString {
    public static void main(String[] args) {
        String str = "981235";
        int firstDot=1; int secondDot= firstDot+1; int thirdDot= secondDot+1;
        System.out.println(str.substring(0,firstDot));
        System.out.println(str.substring(firstDot,secondDot));
        System.out.println(str.substring(secondDot,thirdDot));
        System.out.println(str.substring(thirdDot, str.length()));

    }
}
