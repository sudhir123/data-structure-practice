package com.prac.home.datastructures.array.basics;

/**
 * complexity O(n) two for loops O(2n)
 */
public class NonRepeatingCharacterInAString {

    public static int[] checkNonRepeatingChar(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int offset = ch - 97;
            arr[offset] = arr[offset] + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        String str = "alskalkslakslakslkalkslakslakslkalsklaksmlakslkalsklakslkaslkalkslakslakslakslkalkslakslkasl";


        isUniqueChars(str);

        int[] arr = checkNonRepeatingChar(str);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                i = i + (int) 'a';
                System.out.println((char) i);
            }
        }

        /**
         * Another way
         */

        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                System.out.println(str.charAt(i));
            }
        }
    }

    /**
     * Another and best way
     * Lets say string is only made of ASCII characters
     * maximum possible unique characters are 128 in ASCII ... if extended ascii it will be 256
     * time complexity is O(128) maximum -> O(1)
     */

    public static boolean checkIfRepeatingChar(String str) {
        if (str.length() > 128) return true;
        boolean[] booleans = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            if (booleans[str.charAt(i)]) return true;
            booleans[str.charAt(i)] = false;
        }
        return false;
    }

    /**
     * One more way where we can even reduce the space complexity
     */
    static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            System.out.println((1 << val));
            if ((checker & (1 << val)) > 0)
                return false;
            checker |=(1<<val);
        }
            return true;
    }
}
