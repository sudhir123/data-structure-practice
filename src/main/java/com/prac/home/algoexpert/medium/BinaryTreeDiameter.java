package com.prac.home.algoexpert.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * write function that takes Binary Tree and retruns the longest path, even if path does not pass from root.
 * basically at any node length from left extreme to right
 *
 * Question is asking about the diameter of tree -> diameter is longest path from the tree
 *  path is collection od connected nodes, and  basically number of edges between first node and last node of that tree.
 *  basically goal is find the longest path. Longest path involves traversal , which DFS in this case.
 *  so basically what info we need to get our  problem's , we need to know diameter of left sub tree or diameter of right subtree
 *  or longest path from that node ()using that node
 *  basically think in this from any point a diameter will at the other end of point is on circle. there can be n numbe rof cirecles
 *  paissing from a pont. thinking of longest diameter here is either left or right or or point is on raidius point means
 *  passing from that node. now we no why max (LD, RD, path)
 *
 * few pointers -> to know the longest path -> we need to know the maximum height
 * diameter to any node is Max(LD, RD, longest path)
 */
public class BinaryTreeDiameter {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    static class TreeInfo{
        int diameter;
        int height;
        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
    public int binaryTreeDiameter(BinaryTree tree) {
        return getTreeInfo(tree).diameter;
    }

    TreeInfo getTreeInfo(BinaryTree tree){
        if (tree==null){
            return new TreeInfo(0,0);
        }
        // depth first search
        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int longestPath = leftTreeInfo.height+rightTreeInfo.height; // this gives us number of edges contained in path
        int longestDiaIntrim = Math.max(leftTreeInfo.diameter,rightTreeInfo.diameter);
        int longestDia = Math.max(longestDiaIntrim, longestPath);
        int loongestheaignt = Math.max(leftTreeInfo.height,rightTreeInfo.height)+1;

        return new TreeInfo(longestDia,loongestheaignt);
    }

    // every node is connected max two nodes. in this example 3 is connected to 3 nodes ...parent left and right. we can consider 3 in two cases
    // 1 where 3 is parent of left nad right and 2) 3 is in path from its parent. we can not consider 4 3 1 2 as path.
    /*public int binaryTreeDiameter(BinaryTree tree) {
        Map<Integer, Integer> map = new HashMap<>();
        treeMapTracker(tree, map);
        int max=0;
        for (Integer key : map.keySet()
             ) {
            if (max<map.get(key)) max=map.get(key);
        }
        return max;
    }

    public void treeMapTracker(BinaryTree tree, Map<Integer, Integer> map) {
        if (tree!=null && tree.left!=null && tree.right!=null){
            // eligible for path
            map.put(tree.value, treeTraverse(tree));
        }else{
            return;
        }
        treeMapTracker(tree.left, map);
        treeMapTracker(tree.right, map);
    }

    int treeTraverse(BinaryTree tree ){
        int leftCounter= traverseLeft(tree,0);
        int rightCounter= traverseRight(tree.right,0);
        return leftCounter+rightCounter;
    }

    int traverseLeft(BinaryTree tree, int counter){
        if (tree.left!=null){
           counter+= traverseLeft(tree.left, counter+1);
        }
        return counter;
    }

    int traverseRight(BinaryTree tree, int counter){
        if (tree.right!=null){
            counter+= traverseRight(tree.right, counter+1);
        }
        return counter;
    }*/

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left= new BinaryTree(3);
        root.right= new BinaryTree(2);

        root.left.left= new BinaryTree(7);
        root.left.left.left= new BinaryTree(8);
        root.left.left.left.left= new BinaryTree(9);
        root.left.right= new BinaryTree(4);
        root.left.right.right= new BinaryTree(5);
        root.left.right.right.right= new BinaryTree(6);

        BinaryTreeDiameter b= new BinaryTreeDiameter();
        System.out.println(b.binaryTreeDiameter(root));
    }
}





























