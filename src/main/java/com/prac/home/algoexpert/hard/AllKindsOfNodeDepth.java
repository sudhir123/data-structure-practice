package com.prac.home.algoexpert.hard;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Distance between node and root is called node's depth.
 * Write function that takes binary tree and returns the sum of all depth of all possible subtrees.
 */
public class AllKindsOfNodeDepth {

    public static int allKindsOfNodeDepths(BinaryTree root) {
        // solution1 #mythinking
        //return depthCounter(root);

        //return getTreeInfo(root).sumOfAllDepth;

        return allKindNodesDepthHelper(root, 0,0);
    }
    // #mythinking O(nlogn)
    /*static int depthCounter(BinaryTree root){
        if (root==null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        increment(root,map);
         *//*int sum=  (map.values().stream().reduce( Integer::sum)).get();
        int sum1=depthCounter(root.left);
        int sum2=depthCounter(root.right);
        return sum+sum1+sum2;*//*
        return (map.values().stream().reduce( Integer::sum)).get() + depthCounter(root.left)+depthCounter(root.right);

    }
    static void increment(BinaryTree root, Map<Integer, Integer> map){
        if (root==null){
            return;
        }
        if (map.get(root.value)==null){
            map.put(root.value, 0);
        }
        increment(root.left, map);
        if (root.left!=null) {
            map.put(root.value, map.get(root.value) + 1);
            map.put(root.value, map.get(root.left.value)+ map.get(root.value));
        }
        increment(root.right, map);
        if (root.right!=null ) {
            map.put(root.value, map.get(root.value) + 1);
            map.put(root.value, map.get(root.right.value)+ map.get(root.value));
        }
    }*/
    // solution2 without map O(nlogn)
    static int depthCounter(BinaryTree root){
        if (root==null) return 0;
        return  incrementWithoutMap(root,0)+ depthCounter(root.left)+depthCounter(root.right);
    }
    static int incrementWithoutMap(BinaryTree root ,int depth){
        if (root==null) return 0;
        return depth +incrementWithoutMap(root.left, depth+1) + incrementWithoutMap(root.right, depth+1);
    }

    // solution3 O(n) by algo expert
    static TreeInfo getTreeInfo(BinaryTree root){
        if (root==null) return new TreeInfo(0,0,0);
        TreeInfo left = getTreeInfo(root.left);
        TreeInfo right = getTreeInfo(root.right);
        // basically depth of each node is
        // increased by 1 when we go one level up. Lets say in tree depth of 4 from 2 is 1 but from 1 , which is one level up, is 2.
        // so does all nodes in subtree incresed by 1 , just by moving one level up. hence the number of nodes
        int sumOfLeftDepth= left.sumOfDepth + left.getNumNodesInTree();
        int sumOfRightDepth= right.sumOfDepth + right.getNumNodesInTree();

        int numNodesInTree= 1+ left.getNumNodesInTree()+ right.getNumNodesInTree();
        int sumOfDepth= sumOfLeftDepth+sumOfRightDepth;
        int sumOfAllDepth= sumOfDepth+ left.sumOfAllDepth+right.sumOfAllDepth;
        return new TreeInfo(numNodesInTree, sumOfDepth, sumOfAllDepth);
    }

    // solution4
     static int allKindNodesDepthHelper(BinaryTree root, int depthSum, int depth){
        if (root==null)
            return 0;

        depthSum = depthSum+ depth;
        return depthSum+ allKindNodesDepthHelper(root.left, depthSum, depth+1)+ allKindNodesDepthHelper(root.right, depthSum, depth+1);
     }

    @AllArgsConstructor
    @Data
    static class TreeInfo {
        int numNodesInTree;
        int sumOfDepth;
        int sumOfAllDepth;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }


    public static void main(String[] args) {
        AllKindsOfNodeDepth a=  new AllKindsOfNodeDepth();
        BinaryTree root = new BinaryTree(1);
        root.left= new BinaryTree(2);
        root.right= new BinaryTree(3);
        root.left.left=new BinaryTree(4);
        root.left.right=new BinaryTree(5);
        root.right.left= new BinaryTree(6);
        root.right.right= new BinaryTree(7);
        root.left.left.left=new BinaryTree(8);
        root.left.left.right=new BinaryTree(9);
        System.out.println(allKindsOfNodeDepths(root));
    }
}



























