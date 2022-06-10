package com.prac.home.practice.algoexpert;

public class MaxPathSumInBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left= new BinaryTree(2);
        root.right= new BinaryTree(3);
        root.left.left= new BinaryTree(4);
        root.left.right= new BinaryTree(5);

        root.right.left= new BinaryTree(6);
        root.right.right= new BinaryTree(7);
        System.out.println(maxPathSum(root));
    }
    static class BinaryTree{
        int data;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int data){
            this.data=data;
        }
    }
    // its very complicated
    public static int maxPathSum(BinaryTree tree) {
        return maxSum(tree);
    }
    public static int maxSum(BinaryTree tree) {
        if (tree== null) return 0;

        int intrimSum=0;
        intrimSum+= Math.max(tree.data+maxSum(tree.left),  tree.data+maxSum(tree.right));

        return intrimSum;
    }
}
