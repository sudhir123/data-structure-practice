package com.prac.home.practice;
/**
 * Given two strings 'str' and a wildcard pattern 'pattern' of length N and M respectively,  You have to print '1' if the wildcard pattern is matched with str else print '0' .
 * The wildcard pattern can include the characters ‘?’ and ‘*’
 * ‘?’ – matches any single character
 * ‘*’ – Matches any sequence of characters (including the empty sequence)
 */
public class WildcardPatternMatching {
    public static void main(String[] args) {
        WildcardPatternMatching w=new WildcardPatternMatching();
        //System.out.println(w.wildCard("ba*a?","baaabab"));// 1
        //System.out.println(w.wildCard("a*ab","baaabab")); // 0
        System.out.println(w.wildCard("?*?","b")); //0
    }
    // not so bad but not correct at all. lets try with recusion and then apply dp.
    int wildCard(String pattern, String str){
        Boolean[][] dp =new Boolean[str.length()][pattern.length()];
        if (wm(pattern,str, 0, 0, dp)){
            return 1;
        }else {
            return 0;
        }
    }

    public boolean wm(String p, String s, int pIdx, int sIdx, Boolean[][] dp){
        if (pIdx== p.length() && sIdx==s.length()) return true;
        if (sIdx==s.length()) {
            // could be a now pattern at the character where all are '*'
            for (int j =pIdx; j< p.length(); j++){
                if (p.charAt(j)!='*'){
                    return false;
                }
            }
            return true;
        }
        if (pIdx== p.length() && sIdx!=s.length()) return false;
        if (dp[sIdx][pIdx]!=null) return dp[sIdx][pIdx];

        boolean ans=false;
        if (p.charAt(pIdx)=='*'){
            if (wm(p,s, pIdx+1, sIdx,dp)){
                ans=true;
            }
            if (wm(p,s, pIdx+1, sIdx+1,dp)){
                ans=true;
            }
            if (wm(p,s, pIdx, sIdx+1,dp)){
                ans=true;
            }
        }else if (p.charAt(pIdx)=='?' ){
            if (wm(p,s, pIdx+1, sIdx+1,dp)){
                ans=true;
            }
        }else {
            if (p.charAt(pIdx)==s.charAt(sIdx) && wm(p,s, pIdx+1, sIdx+1,dp)){
                ans=true;
            }
        }
        dp[sIdx][pIdx]= ans;
        return ans;
    }
}
