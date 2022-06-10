package com.prac.home.datastructures.companies.amazon;

import java.util.*;

public class AmazonTest2 {
    /*public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
       *//* root.right.left = new Node(6);
        root.right.right= new Node(7);*//*

        AmazonTest2 a= new AmazonTest2();
        System.out.println(a.isPossible(root));
    }*/
    static class  Node{
        int data;
        Node left, right;
       Node(int data){
           this.data=data;
       }
    }
    boolean isPossible(Node root){
        List<Integer> list = new ArrayList<>();
        getLeafNodeDepth(root, 0, list);
        list.sort((o1, o2) -> o1>o2?1:-1);
        if (list.get(list.size()-1)- list.get(0)>1){
            return false;
        }
        return true;
    }
    void getLeafNodeDepth(Node root, int depth, List<Integer> list){
        if (root==null) return ;
        if (root.left==null && root.right==null){
            list.add(depth);
        }
        getLeafNodeDepth(root.left, depth+1, list);
        getLeafNodeDepth(root.right, depth+1, list);
    }

    // this is kinda finding anagram starting position..sliding window concept
    static boolean valid(String p,String s){
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i< p.length(); i++){
            if (map.containsKey(p.charAt(i))){
                map.put(p.charAt(i), map.get(p.charAt(i))+1);
            }else {
                map.put(p.charAt(i), 1);
            }
        }
        int count= map.size();
        int i=0, j=0;
        while (j< s.length()){
            if (j-i+1 < p.length() ){
                if (map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), map.get(s.charAt(j))-1);
                    if (map.get(s.charAt(j))==0){
                        count--;
                    }
                }
                j++;
            }else {
                if (map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), map.get(s.charAt(j))-1);
                    if (map.get(s.charAt(j))==0){
                        count--;
                    }
                }
                j++;
                if (count==0){
                    return true;
                }
                if (map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    if (map.get(s.charAt(i))==1){
                        count++;
                    }
                }
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(valid("zyxabc", "fghcxabyzbvf")); //true
        System.out.println(valid("estsgk", "getsskny"));  //true
        System.out.println(valid("hqyc", "chyyqhef"));  // false
    }
}
