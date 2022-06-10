package com.prac.home.practice.algoexpert;

import com.prac.home.algoexpert.medium.SuffixTrieConstruction;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieProg {
    public static void main(String[] args) {
        SuffixTrie s= new SuffixTrie("babc");
        System.out.println(s.contains("abc"));
    }
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i=0; i< str.length(); i++){
                insert(i, str);
            }
        }

        public void insert(int idx , String s){
            TrieNode root;
            for (int i=idx; i< s.length(); i++){
                char ch= s.charAt(i);
            }
        }

        public boolean contains(String str) {
            // Write your code here.
            return false;
        }
    }
}













