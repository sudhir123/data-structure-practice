package com.prac.home.datastructures.array.basics;

/**
 * One edit means -> either add one character , or delete one character or replace one character , to make it other.
 * PALE -> PLE -> one edit is just add 'A'  PALE -> PBLE -> one edit is replace->B to A
 * so basically means either length difference is 0 or 1. If 0 than case of replace. keep on comparing if u find diff mark diff
 * as true ... keep on comparing if no other return true
 */
public class TwoStringsOneEditAway {

    static boolean oneEditReplace(String s1, String s2){
        int i =0; boolean oneEditReplace= false;
        while (i < s1.length()){
            if(s1.charAt(i)!= s2.charAt(i)){
                if(oneEditReplace){
                    return false;
                }
                oneEditReplace=true;
            }
            i++;
        }
        return oneEditReplace;
    }

    static boolean oneEditAddDelete(String s1, String s2){
        int index1=0, index2=0; boolean oneEditAddDelete=false;
        while (index1<s1.length() && index2<s2.length()){
            if(s1.charAt(index1)!=s2.charAt(index2)){
                if (index1 != index2) {
                    return false;
                }
                index2++;
            }else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    static boolean oneEditlnsert(String s1, String s2) {
        int index1 =0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "PALE", s2 ="PAL";
        if (s1.length()==s2.length())
            System.out.println(oneEditReplace(s1, s2));
        else
            System.out.println(oneEditAddDelete(s1,s2));
    }
}
