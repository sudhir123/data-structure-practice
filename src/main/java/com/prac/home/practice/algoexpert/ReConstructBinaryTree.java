package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ReConstructBinaryTree {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
    // left 2n+1 and right 2n+2 n from 0 to n-1
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        BST root = null;
        for (Integer num: preOrderTraversalValues
             ) {
            if (root==null){
                root= reconstruct(root , num);
            }else {
                reconstruct(root , num);
            }
        }
        return root;
    }

    public BST reconstruct( BST root, int number) {
        if (root==null){
            return new BST(number);
        }
        if (number < root.value){
            root.left= reconstruct(root.left, number);
        }else {
            root.right=reconstruct(root.right, number);
        }
        return root;
    }

    public static void main(String[] args) {
        ReConstructBinaryTree r = new ReConstructBinaryTree();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);list.add(4);list.add(2);list.add(1);list.add(5);list.add(17);list.add(19);list.add(18);
        BST root = r.reconstructBst(list);
        System.out.println(root.value);
    }
}
