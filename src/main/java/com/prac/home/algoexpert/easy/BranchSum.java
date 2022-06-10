package com.prac.home.algoexpert.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * funtion that takes binary tree and return a list of it branch sum in order , left most to right most. Branch is considered only from root
 * to leaf.
 */
public class BranchSum {

    static BinaryTree root;
    
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> list = new ArrayList<>();
        sumNodeValues(root, list, 0) ;
        return list;
    }

    static void sumNodeValues(BinaryTree root, List<Integer> list, int sum){
        if (root==null) return;
        sum=sum+root.value;
        if (root.right==null && root.left==null) {
            list.add(sum);
            return;
        }
        sumNodeValues(root.left, list, sum);
        sumNodeValues(root.right, list, sum);
    }

    public static void main(String[] args) {
        root= new BinaryTree(1);
        root.left= new BinaryTree(2);
        root.right= new BinaryTree(3);
        root.left.left= new BinaryTree(4);
        root.left.right= new BinaryTree(5);
        root.right.left= new BinaryTree(6);
        root.right.right= new BinaryTree(7);
        root.left.left.left= new BinaryTree(8);
        root.left.left.right= new BinaryTree(9);
        root.left.right.left= new BinaryTree(10);

        /*root= new BinaryTree(0);
        root.right= new BinaryTree(1);
        root.right.right= new BinaryTree(10);
        root.right.right.right= new BinaryTree(100);*/

        System.out.println(branchSums(root));
    }
}













