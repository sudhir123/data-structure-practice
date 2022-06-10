package com.prac.home.geeks4geeks;

public class LongestCommonSubSeq {
    public static void main(String[] args) {
        System.out.println(lcs(3,2, "ABC","AC"));
    }
    static int lcs(int x, int y, String s1, String s2){
        String[][] dp = new String[x+1][y+1];
        for (int row=0; row< x+1; row++) {
            for (int col = 0; col < y + 1; col++) {
                dp[row][col]="";
            }
        }
        for (int row=1; row< x+1; row++){
            for (int col =1; col< y+1; col++){

                if (s1.charAt(row-1)== s2.charAt(col-1)){
                    dp[row][col]= dp[row-1][col-1]+s1.charAt(row-1);
                }else {
                    String left= dp[row][col-1];
                    String right = dp[row-1][col];
                    if (left.length()>= right.length()){
                        dp[row][col]= left;
                    }else {
                        dp[row][col]= right;
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1].length();
    }
}
