package com.prac.home.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * store values in list in in-order fashion
 */
public class KthLargestValue {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        BST root =new BST(15);
        root.left= new BST(5);
        root.right= new BST(20);

        root.left.left= new BST(2);
        root.left.right= new BST(5);
        root.left.left.left= new BST(1);
        root.left.left.right= new BST(3);

        root.right.left= new BST(17);
        root.right.right= new BST(22);
        KthLargestValue k= new KthLargestValue();
        System.out.println(k.findKthLargestValueInBst(root, 3));

    }
    public int findKthLargestValueInBst(BST tree, int k) {
        List<Integer> treeValues = new ArrayList<>();
        find(tree, treeValues);
        for (Integer val : treeValues
             ) {
            if (k-1==0){
                return val;
            }
            k--;
        }
        return -1;
    }
    public void find(BST tree, List<Integer> treeValues) {
        if (tree==null){
            return ;
        }
        find(tree.right,treeValues);
        treeValues.add(tree.value);
        find(tree.left, treeValues);

    }
}
