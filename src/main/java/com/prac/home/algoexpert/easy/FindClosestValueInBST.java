package com.prac.home.algoexpert.easy;

import java.util.Map;

/**
 * function that takes Binary Search Tree and target Value. Find the closest Value in the tree for that target Value.
 * BST property-> each value is smaller in left for every node. and each value is greater in right bst for every node.
 */
public class FindClosestValueInBST {
    static BST root;
    public static int findClosestValueInBst(BST tree, int target) {
        //return findCloseDifference(tree, target, tree).value;
        return findCloseDifference(tree, target, tree.value);
    }

    /*public static BST findCloseDifference(BST tree, int target, BST lastCloseNode) {
        if (tree==null) return lastCloseNode;
        int currentDiff= Math.abs(target-tree.value);
        int lastDiff = Math.abs(target-lastCloseNode.value);

        if (target > tree.value ) {
            if (lastDiff > currentDiff) {
               return findCloseDifference(tree.right, target, tree);
            }else {
               return findCloseDifference(tree.right, target, lastCloseNode);
            }
        }else {
            if (lastDiff > currentDiff) {
               return findCloseDifference(tree.left, target, tree);
            }else {
              return   findCloseDifference(tree.left, target, lastCloseNode);
            }
        }
    }*/

    public static int findCloseDifference(BST tree, int target, int lastCloseValue) {
        if (tree==null) return lastCloseValue;
        int currentDiff= Math.abs(target-tree.value);
        int lastDiff = Math.abs(target-lastCloseValue);

        if (target > tree.value ) {
            if (lastDiff > currentDiff) {
                return findCloseDifference(tree.right, target, tree.value);
            }else {
                return findCloseDifference(tree.right, target, lastCloseValue);
            }
        }else {
            if (lastDiff > currentDiff) {
                return findCloseDifference(tree.left, target, tree.value);
            }else {
                return   findCloseDifference(tree.left, target, lastCloseValue);
            }
        }
    }
    public static void main(String[] args) {
        root= new BST(10);
        root.left= new BST(5);
        root.right= new BST(15);
        root.left.left= new BST(2);
        root.left.right= new BST(5);
        root.left.left.left= new BST(1);

        root.right.left= new BST(13);
        root.right.right= new BST(22);
        root.right.left.right= new BST(14);
        System.out.println(findClosestValueInBst(root, 12));

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
