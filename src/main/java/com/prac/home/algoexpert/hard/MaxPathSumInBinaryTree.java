package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * function that takes a binary tree and return the max path sum.
 */
public class MaxPathSumInBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left=new BinaryTree(2);
        root.right= new BinaryTree(3);
        root.left.left=new BinaryTree(4);
        root.left.right=new BinaryTree(5);
        root.right.left=new BinaryTree(6);
        root.right.right=new BinaryTree(7);
        System.out.println(maxPathSum(root));

    }
    public static int maxPathSum(BinaryTree tree) {
        return maxPathSumHelper(tree).get(1);
    }


    static List<Integer> maxPathSumHelper(BinaryTree root){
        if (root==null) return new ArrayList<>(Arrays.asList(0, Integer.MIN_VALUE));
        List<Integer> leftMaxSumArray=  maxPathSumHelper(root.left);
        Integer leftMaxSumBranch= leftMaxSumArray.get(0);
        Integer leftMaxPathSum= leftMaxSumArray.get(1);

        List<Integer> rightMaxSumArray= maxPathSumHelper(root.right);
        Integer rightMaxSumBranch= rightMaxSumArray.get(0);
        Integer rightMaxPathSum= rightMaxSumArray.get(1);

        int maxChildSumBranch = Math.max(leftMaxSumBranch, rightMaxSumBranch);
        int maxSumBranch = Math.max(maxChildSumBranch+ root.value, root.value);
        int maxSumAsRootNode= Math.max(maxSumBranch, leftMaxSumBranch+ rightMaxSumBranch+ root.value);
        int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode) );
        return new ArrayList<>(Arrays.asList(maxSumBranch, maxPathSum));
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
