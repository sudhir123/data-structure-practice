package com.prac.home.algoexpert.hard;

import java.util.*;

public class BoggleBoard {
    public static void main(String[] args) {
        System.out.println(boggleBoard(new char[][]{
                {'t', 'h', 'i', 's', 'i', 's', 'a'},
                {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
                {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
                {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
                {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
                {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'N', 'O', 'T', 'R', 'E', '-', 'P'},
                {'x', 'x', 'D', 'E', 'T', 'A', 'E'}
        }, new String[]{"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"}));//
    }
    static void printSuffix(Trie s){
        TrieNode t = s.root;
        for (Character c: t.children.keySet()
             ) {
            System.out.println(c);
        }
    }
    public static List<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String str :
                words) {
            trie.add(str);
        }

        //printSuffix(trie);
        Set<String> finalWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int r=0; r< board.length; r++ ){
            for (int c=0; c< board[0].length; c++){
                explore(r,c,visited,board,trie.root,finalWords);
            }
        }
        List<String> strings= new ArrayList<>();
        strings.addAll(finalWords);
        return strings;
    }

    static void explore(int r, int c, boolean[][]visited, char[][]board, TrieNode trieNode, Set<String> finalWords){
        if (visited[r][c]) return;

        if (! trieNode.children.containsKey(board[r][c])) {
            return;
        }
        visited[r][c]=true;
        trieNode = trieNode.children.get(board[r][c]);
        if (trieNode.children.containsKey('*')){
            finalWords.add(trieNode.word);
        }
        List<Integer[]> neighbours = getNeighbour(r,c, board);
        for (Integer[] neighbour:neighbours
        ) {
            explore(neighbour[0],neighbour[1], visited, board, trieNode, finalWords);
        }
        visited[r][c]=false;
    }

    static List<Integer[]> getNeighbour(int i, int j, char[][]board){
        List<Integer[]> neighbours = new ArrayList<>();
        if (i >0 && j >0){
            neighbours.add(new Integer[]{i-1,j-1});
        }
        if (i >0 && j <board[0].length-1){
            neighbours.add(new Integer[]{i-1,j+1});
        }
        if (i <board.length-1 && j <board[0].length-1){
            neighbours.add(new Integer[]{i+1,j+1});
        }
        if (i <board.length-1 && j >0){
            neighbours.add(new Integer[]{i+1,j-1});
        }
        if (i >0 ){
            neighbours.add(new Integer[]{i-1,j});
        }
        if (i <board.length-1 ){
            neighbours.add(new Integer[]{i+1,j});
        }
        if (j >0 ){
            neighbours.add(new Integer[]{i,j-1});
        }
        if (j <board[0].length-1 ){
            neighbours.add(new Integer[]{i,j+1});
        }
        return neighbours;
    }

    static class TrieNode{
        public static Map<Character, TrieNode> children =new HashMap<>();
        String word="";
    }
    static class Trie{
        public TrieNode root;
        Character endChar;

        public Trie(){
            this.root= new TrieNode();
            this.endChar= '*';
        }
        public void add(String str){
            TrieNode node =this.root;
            for (int i=0; i< str.length(); i++){
                Character letter = str.charAt(i);
                if (!node.children.containsKey(letter)){
                    TrieNode newNode= new TrieNode();
                    node.children.put(letter, newNode);
                }
                node= node.children.get(letter);
            }
            node.children.put(this.endChar,null);
            node.word=str;
        }
    }
}
