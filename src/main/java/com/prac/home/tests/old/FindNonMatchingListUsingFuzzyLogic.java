package com.prac.home.tests.old;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * This challenge is to implement a basic spell checker. Some of the
 * code has already been written. Implement the printCorrections
 * function below to complete the challenge.
 */
public class FindNonMatchingListUsingFuzzyLogic {

    private static final String writingSample = "The race to " +
            "dominaet the electric-vehicle industry may be getting tighter as " +
            "Volkswagen, the German automobile giant and looming Tesla rival, " +
            "reveeled plans on Monday to reduce the cost of batterees and operate " +
            "a wide-ranging charging network. In its first-ever “Power Day,” " +
            "remeniscent of electric-car maker Tesla much-hyped “Battery Day,” " +
            "the German group that owns the Volkswagen, Audi and Porshe brands " +
            "said it would rely on six gigafactories in Europe to secure " +
            "supllies as the industry faces a looming shortage.";

    private static final String wordList = "a and as Audi " +
            "automobile batteries Battery be brands car charging cost Day " +
            "dominate electric Europe ever faces first German getting giant " +
            "gigafactories group hyped in industry it its looming maker may " +
            "Monday much network of on operate owns plans Porsche Power race " +
            "ranging reduce rely reminiscent revealed rival said secure " +
            "shortage six supplies Tesla that the tighter to vehicle Volkswagen " +
            "wide would";

    public static void main(String[] args) {
        FindNonMatchingListUsingFuzzyLogic spellChecker = new FindNonMatchingListUsingFuzzyLogic();
        spellChecker.printCorrections(writingSample, wordList);
    }

    /**
     * Needs to be implemented
     * @param writingSample is text that contains spelling errors
     * @param wordList contains the words in writingSample, but spelled correctly
     */
    private void printCorrections(String writingSample, String wordList) {

        /*
         * TODO:
         * Use wordList to determine which words in writingSample
         * are misspelled. Use parseWords() and fuzzyCompare()
         * to solve the problem. Output the misspelled words and
         * the correct spelling as shown below. The output should
         * be as follows:
         *
         * Replace "dominaet" with "dominate"
         * Replace "reveeled" with "revealed"
         * Replace "batterees" with "batteries"
         * Replace "remeniscent" with "reminiscent"
         * Replace "Porshe" with "Porsche"
         * Replace "supllies" with "supplies"
         */
        // converting to lists
        List<String > writingSampleList = parseWords(writingSample);
        List<String > completeWordList = parseWords(wordList);

        writingSampleList
                .parallelStream()
                .filter(x-> !completeWordList.contains(x))
                .collect(Collectors.toList())
                .parallelStream()
                .flatMap(st-> completeWordList
                        .parallelStream()
                        .filter(x -> fuzzyCompare(x, st) > .50)
                        .map(x -> "Replace " + st + " with " + x)
                )
                .forEach(System.out::println);
    }


    /**
     * @param text is a writing sample
     * @return a list of the words found in the text.
     * The words are forced to lower case.
     * ie. "The boy ran fast." -> ["the", "boy", "ran", "fast"]
     */
    private List<String> parseWords(String text) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group().toLowerCase());
        }
        return words;
    }

    /**
     * @param word1 is any word
     * @param word2 is any other word to compare with word1
     * @return a number between 0 and 1 where 1 is a perfect match
     * and 0 is not a match at all.
     */
    private float fuzzyCompare(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        int matchingChars = 0;
        int totalChars = Math.max(word1.length(), word2.length());
        int minChars = Math.min(word1.length(), word2.length());
        for(int i = 0; i< minChars; i++) {
            if(word1.charAt(i) == word2.charAt(i)) {
                matchingChars++;
            }
        }
        return (float) matchingChars/ (float) totalChars;
    }
}

