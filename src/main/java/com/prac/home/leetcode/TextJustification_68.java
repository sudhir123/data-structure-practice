package com.prac.home.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class TextJustification_68 {

    public static void main(String[] args) {
        TextJustification_68 t= new TextJustification_68();
        System.out.println(t.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to",
                "explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        int[] wordLengthAtEachIndex = new int[words.length];
        StringBuilder stringBuilder= new StringBuilder();
        wordLengthAtEachIndex[0]= words[0].length();
        stringBuilder.append(words[0]);
        for (int i=1; i < words.length; i++){
            String word =words[i];
            wordLengthAtEachIndex[i]= word.length()+1; // + is for space
            stringBuilder.append(" "+words[i]);
        }
        String string= stringBuilder.toString();
        int start=0; //start index for substring
        int sum=0;
        List<String > result = new ArrayList<>();
        for (int i=0; i < wordLengthAtEachIndex.length; i++){
            sum+=wordLengthAtEachIndex[i];
            if ( sum> maxWidth){
                sum-=wordLengthAtEachIndex[i];
                result.add(string.substring(start, start+sum));
                start=start+sum+1;
                sum=0;
                i--;
            }
        }
        return result;
    }
}


























