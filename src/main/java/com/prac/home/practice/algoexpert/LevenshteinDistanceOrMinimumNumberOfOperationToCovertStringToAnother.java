package com.prac.home.practice.algoexpert;
// LevenshteinDistance Or Minimum Number Of Operation To Covert String To Another
// my understanding says that it is part of LCS
public class LevenshteinDistanceOrMinimumNumberOfOperationToCovertStringToAnother {
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc","yabd"));
    }

    public static int levenshteinDistance(String str1, String str2) {
        int commonLength= lcs(str1, str2);
        return str2.length()-commonLength;
    }

    static int lcs(String s1, String s2){
        s1=" "+s1; s2= " "+s2;
        String[][] dp= new String[s1.length()][s2.length()];
        int r=0, c=0;
        while (r< dp.length){
            dp[r][c]="";
            r++;
        }
        r=0;
        while (c< dp[0].length){
            dp[r][c]="";
            c++;
        }
        for (int row=1; row< dp.length; row++){

            for (int col=1; col< dp[0].length; col++){

                if (s1.charAt(row)== s2.charAt(col)){
                    dp[row][col]= dp[row-1][col-1]+ s1.charAt(row);
                }else {
                    String upper= dp[row-1][col];
                    String left= dp[row][col-1];
                    if (upper.length()>=left.length()){
                        dp[row][col]= dp[row-1][col];
                    }else {
                        dp[row][col]= dp[row][col-1];

                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1].length();
    }
}
