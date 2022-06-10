package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
/**
 * logic behind this is u are not dependent on input length, as this is fixed , so any operation any for loop n number of times
 * will ne constant time operation. first dot can be after first char , or after two ints or after three integers.
 * So does rest two. so lets fixed the first one we can move second after one char , two chars or after three chars.
 * now reaching on third loop. genrate all possible values of this. complete all loops and check at each modification
 * whether its a valid ip.
 * "1921680"
 */
public class ValidIpAddress {
    public static void main(String[] args) {
        ValidIpAddress v= new ValidIpAddress();
        v.validIPAddresses("1921680");
    }
    public ArrayList<String> validIPAddresses(String string) {
        char[] st= string.toCharArray();
        ArrayList<String> list = new  ArrayList<>();
        for (int firstDotPlacement=1; firstDotPlacement < Math.min(string.length(), 4); firstDotPlacement++){
            String s1 = string.substring(0,firstDotPlacement);
            if (validIPConditions(s1)) {

                for (int secondDotPlacement = firstDotPlacement + 1;
                            secondDotPlacement< firstDotPlacement + (Math.min( string.length()-firstDotPlacement, 4));
                                secondDotPlacement++) {

                    String s2 = string.substring(firstDotPlacement, secondDotPlacement);

                    if (validIPConditions(s2)) {
                        for (int thirdDotPlacement = secondDotPlacement + 1 ;
                             thirdDotPlacement< secondDotPlacement+ Math.min(string.length() -secondDotPlacement, 4);
                             thirdDotPlacement++ ) {
                            String s3 = string.substring(secondDotPlacement, thirdDotPlacement);
                            String s4 = string.substring(thirdDotPlacement, string.length());
                            if (validIPConditions(s3)&& validIPConditions(s4)){
                                list.add(s1+"."+s2+"."+s3+"."+s4);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    boolean validIPConditions(String str){
        if (str.equals("")) return false;
        if (str.startsWith("0")&&str.length()>1) return false;
        if (str.length()>3 || Integer.parseInt(str)>255) return false;
        //System.out.println("Valid String "+str);
        return true;
    }
    /*boolean validIPConditions(String s){
        String[] arr = s.split(".");
        for (String str: arr
             ) {
            if (str.startsWith("0")&&str.length()>1) return false;
            if (str.length()>3 || Integer.parseInt(str)>255) return false;
        }
        return true;
    }*/

}
