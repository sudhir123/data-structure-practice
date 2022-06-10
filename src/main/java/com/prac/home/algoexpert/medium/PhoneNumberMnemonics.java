package com.prac.home.algoexpert.medium;

import java.util.*;

/**
 * its based on mobile keypad. when you seach a number , like sudhir..u just use the s u d h... background number starts coming exacly.
 * In this question u will type number and it will show you all possible combination if name. 1 and 0 does not represent any text
 * abc -> 2 ..normal keypad
 */
public class PhoneNumberMnemonics {

    static Map<Character, String[]> keyMap = new HashMap<>();
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
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        String[] currentMenmonics = new String[phoneNumber.length()];
        Arrays.fill(currentMenmonics,"0");

        ArrayList<String > foundMnemonis = new ArrayList<>();
        phoneNumberMnemonicsHelper(0, phoneNumber,currentMenmonics,foundMnemonis);
        return foundMnemonis;
    }

    public void phoneNumberMnemonicsHelper(int idx, String phoneNumner , String[] currentMenmonics , ArrayList<String> foundMenmonics){
        if (idx==phoneNumner.length()){
            String mnemonics = String.join("",currentMenmonics);
            foundMenmonics.add(mnemonics);
        }else {
            char digit = phoneNumner.charAt(idx);
            String[] letters = keyMap.get(digit);
            for (String letter : letters
                 ) {
                currentMenmonics[idx]=letter;
                phoneNumberMnemonicsHelper(idx+1, phoneNumner, currentMenmonics, foundMenmonics);
            }
        }
    }

    /*public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        char[] arr = phoneNumber.toCharArray();
        int[] intArr = new int[arr.length];
        for (int i =0; i <arr.length; i++){
            intArr[i]= Integer.parseInt(""+arr[i]);
        }
        Map<Integer, char[]> keyMap = new HashMap<>();
        keyMap.put(0, new char[]{});
        keyMap.put(1, new char[]{});
        keyMap.put(2, new char[]{'a','b','c'});
        keyMap.put(3, new char[]{'d','e','f'});
        keyMap.put(4, new char[]{'g','h','i'});
        keyMap.put(5, new char[]{'j','k','l'});
        keyMap.put(6,new char[] {'m','n','o'});
        keyMap.put(7, new char[]{'p','q','r','s'});
        keyMap.put(8,new char[] {'t','u','v'});
        keyMap.put(9, new char[]{'w','x','y','z'});
        Set<String > list= new HashSet<>();

        conversion(intArr, arr, 0, keyMap,list);

        return new ArrayList<>(list);
    }
    public void conversion(int[] intArr ,char[] charArr ,int idx, Map<Integer, char[]> keyMap, Set<String > list){
        while (idx<intArr.length) {
            if (intArr[idx]> 1 && intArr[idx] < 10) {
                char[] st = keyMap.get(intArr[idx]);
                for (int i = 0; i < st.length; i++) {
                    charArr[idx] = st[i];
                    conversion(intArr, charArr, idx + 1, keyMap, list);
                    System.out.println(Arrays.toString(charArr));
                    list.add(charArr.toString());
                }
            }
            idx++;
        }
    }*/
    /*public void conversion(int[] intArr, Map<Integer, char[]> keyMap, ArrayList<String > list){
        for (int i =0; i <intArr.length; i ++){
            if (intArr[i]>1 && intArr[i]<10) {
                char[] c = keyMap.get(intArr[i]);
                for (int j =1; j < c.length; j++){
                    for (String s :list
                            ) {
                        char[] charArr=s.toCharArray();
                        charArr[i]= c[j];
                        String s1 =new String(charArr);
                        list.add(s1);
                    }
                }
            }
        }
    }*/
    //1905  idx =0

    public static void main(String[] args) {
        PhoneNumberMnemonics p = new PhoneNumberMnemonics();
        System.out.println(p.phoneNumberMnemonics("1905"));
    }
}
