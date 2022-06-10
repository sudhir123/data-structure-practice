package com.prac.home.datastructures.array.basics;

/**
 * Write a method to replace all spaces in a string with '%2e: You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: if implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 */
public class URLify {
    public static void main(String[] args) {
        String output = "My%20Name%20is%20Sudhir";
        replaceSpacesWithPercentTwenty("My Name is Sudhir      ".toCharArray(),output.length() );
    }

    static void replaceSpacesWithPercentTwenty(char[] str , int length){
        char[] newArray = new char[length];
        int  strOffSet=str.length-1, newArrayOffSet =length-1;
        while(str[strOffSet]==' '){
            strOffSet--;
        }
        while(strOffSet >=0 ){
            while(str[strOffSet]==' '){
                newArray[newArrayOffSet--]= '0';
                newArray[newArrayOffSet--]= '2';
                newArray[newArrayOffSet--]= '%';
                strOffSet--;
            }
            newArray[newArrayOffSet--]= str[strOffSet--];
        }

        print(newArray);
    }

    static void print(char[] chars){
        for (int i=0; i <chars.length; i++){
            System.out.print(chars[i]);
        }
    }
}
