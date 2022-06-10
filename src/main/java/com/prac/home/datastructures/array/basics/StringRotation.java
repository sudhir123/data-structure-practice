package com.prac.home.datastructures.array.basics;

/**
 * Logic -> S1= S+S1 , now check for S2 in this ... must be a match
 */
public class StringRotation {
    public static void main(String[] args) {
        System.out.println(isSubString("Suduhuiuru","Suduhuiuru"));
    }
    static boolean isSubString(String s1, String s2){
        String s3 = s1+s1;
        int i=0, j=0;
        while (i<s3.length()){
            if(s2.charAt(j)==s3.charAt(i)){
                while (s2.charAt(j++)==s3.charAt(i++)){
                    if(j==s2.length()){
                        return true;
                    }
                }
                j=0;
            }
            i++;
        }
        // another way
        /*if(s3.indexOf(s2)!=-1){
            return true;
        }*/
        return false;
    }
}
