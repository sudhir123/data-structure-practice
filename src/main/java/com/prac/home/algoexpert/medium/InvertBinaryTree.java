package com.prac.home.algoexpert.medium;
/**
 * write function to swap every left node in tree with its corresponding right node.
 */
public class InvertBinaryTree {
    public static void invertBinaryTree(BinaryTree tree) {
        if (tree==null) return;
        BinaryTree temp =tree.left;;
        tree.left = tree.right;
        tree.right= temp;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
