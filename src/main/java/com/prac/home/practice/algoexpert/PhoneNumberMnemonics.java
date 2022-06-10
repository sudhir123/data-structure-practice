package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberMnemonics {
    static Map<Character, String[]> keyMap= new HashMap<>();
    static {
        keyMap.put('0', new String[]{"0"});
        keyMap.put('1', new String[]{"1"});
        keyMap.put('2', new String[]{"a", "b", "c"});
        keyMap.put('3', new String[]{"d", "e", "f"});
        keyMap.put('4', new String[]{"g", "h", "i"});
        keyMap.put('5', new String[]{"j", "k", "l"});
        keyMap.put('6', new String[]{"m", "n", "o"});
        keyMap.put('7', new String[]{"p", "q", "r", "s"});
        keyMap.put('8', new String[]{"t", "u", "v"});
        keyMap.put('9', new String[]{"w", "x", "y", "z"});
    }
    public static void main(String[] args) {
        PhoneNumberMnemonics p = new PhoneNumberMnemonics();
        System.out.println(p.phoneNumberMnemonics("23"));
    }
    public List<String> phoneNumberMnemonics(String digits) {
        if (digits==null || digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<String>();
        numbers(digits, 0, new char[digits.length()], result);
        return result;
    }
    public void numbers(String digits, int i, char[] str , List<String> result){
        if (i==digits.length()){
            result.add(new String(str));
        }else {
            String [] arr = keyMap.get(digits.charAt(i));
            for (String  s:arr
                 ) {
                str[i]=s.charAt(0);
                numbers(digits, i+1, str, result);
            }
        }
    }
}
