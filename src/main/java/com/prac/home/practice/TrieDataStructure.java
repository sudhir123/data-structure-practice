package com.prac.home.practice;

import java.util.HashMap;
import java.util.Map;

public class TrieDataStructure {
    public static void main(String[] args) {
        SuffixTrie s= new SuffixTrie("babc");
        System.out.println(s.root.children);
    }
    // node or TrieNode ... just name of class
    static class TrieNodePrac{
        static Map<Character, TrieNodePrac> children = new HashMap<>();
    }
    static class SuffixTrie{
        TrieNodePrac root = new TrieNodePrac();
        Character endSymbol ='*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i =0; i <str.length(); i++){
                TrieNodePrac node= root;
                for (int j=i; j< str.length();j++){
                    Character character= str.charAt(j);
                    if (!node.children.containsKey(character)){
                        node.children.put(character, new TrieNodePrac());
                    }
                    node = node.children.get(character);
                }
                node.children.put(endSymbol, null);
            }
        }

        public boolean contains(String str) {
            TrieNodePrac node= root;
            for (int i =0; i <str.length(); i++){
                Character character= str.charAt(i);
                if (node.children.containsKey(character)) {
                    node = node.children.get(character);
                }else {
                    return false;
                }
            }
            return node.children.containsKey(endSymbol);
        }
    }
}
