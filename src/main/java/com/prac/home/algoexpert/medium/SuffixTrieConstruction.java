package com.prac.home.algoexpert.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * basically its a tree kinda structure, but we don't have left of right. string -> babc -> b -> a-> b-> c-> *
 */
public class SuffixTrieConstruction {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i =0; i< str.length(); i++){
                insertSubStringStartingAt(i, str);
            }
        }

        void insertSubStringStartingAt(int idx, String str){
            TrieNode node= root;
            for (int j=idx; j<str.length(); j++){
                char letter = str.charAt(j);
                if (!node.children.containsKey(letter)){
                    node.children.put(letter, new TrieNode());
                }
                node= node.children.get(letter);
            }
            node.children.put(endSymbol, null);
        }
        void addTrieNode(char[] chars, int idx, TrieNode node){
            if (idx>=chars.length) {
                node.children.put(endSymbol, null);
                return;
            }
            if (node.children!=null ){
                TrieNode t = new TrieNode();
                node.children.put(chars[idx], t);
                addTrieNode(chars, idx+1, t);
            }
        }

        public boolean contains(String str) {
            char[] chars= str.toCharArray();

            if (root.children.get(chars[0])!=null){
                return searchTrieNode(chars,0, root );
            }
            /*TrieNode currentNode =root;
            for (int i =0; i< chars.length; i++){
                if (!currentNode.children.containsKey(chars[i])) {
                    return false;
                }
                currentNode= currentNode.children.get(chars[i]);
            }
            return currentNode.children.containsKey(endSymbol) ;*/
            return false;
        }

        boolean searchTrieNode(char[] chars, int idx, TrieNode root){
            if (idx>=chars.length) {
                return root.children.containsKey(endSymbol);
            }
            if (root.children.get(chars[idx])!=null){
                return searchTrieNode(chars, idx+1, root.children.get(chars[idx]));
            }
            return false;
        }
    }


    public static void main(String[] args) {
        SuffixTrie s= new SuffixTrie("testtest");
        System.out.println(s.contains("tes"));
    }
}

















