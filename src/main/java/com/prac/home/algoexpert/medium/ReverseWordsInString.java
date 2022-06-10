package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Input String is collection of words, and has one more spaces. So we cannot directly convert to char array. Input is not restricted
 * to words, can contain special characters. returned string must contain all special chars and white spaces as is.
 * Function to reverse the order of the words, keeping word as is. Hi How Are you--> you Are How Hi
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString r = new ReverseWordsInString();

        System.out.println(r.reverseWordsInString("AlgoExpert is the best!"));
    }
    // best O(n) using substring while running and add this to list
    public String reverseWordsInString(String string) {
        List<String> list = new ArrayList<>();
        int startIdx=0;
        for (int i =0; i < string.length(); i ++){
            if (string.charAt(i)==' '){
                String st = string.substring(startIdx, i);
                list.add(st);
                startIdx=i;
            }else if (string.charAt(startIdx)==' '){
                list.add(" ");
                startIdx= i;
            }
        }
        String st = string.substring(startIdx);
        list.add(st);
        Collections.reverse(list);
        String s1 ="";
        for (String s: list
             ) {
            s1+=s;
        }
        return s1;
    }

    // O(lN) where l is the length of words.
    /*public String reverseWordsInString(String string) {
        Stack<Character> stack= new Stack<>();
        char[] charArray= new char[string.length()];
        int index = charArray.length-1;
        for (int i =0; i < string.length(); i++){
            if (string.charAt(i)==' '){
                index= reverse(stack, charArray, index);
                charArray[index]=string.charAt(i);
                index--;
            }else {
                stack.push(string.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            charArray[index]= stack.pop();
            index--;
        }
        return new String(charArray);
    }

    int reverse(Stack<Character> stack, char[] charArray, int index){
        while (!stack.isEmpty()){
            charArray[index]= stack.pop();
            index--;
        }
        return index;
    }*/
}
