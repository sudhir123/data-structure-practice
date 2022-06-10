package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * function takes BST root and Integer K as parameter and return the kth largest value in the BST. Duplicate also be considered in
 * list. 5,7, 7 -> second largest will be 7 not 5.
 */
public class FindKthValueInBST {
    // my understanding is extreme is largest .. if we do traverse in in-order traversal and get the kth value.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        List<Integer> list= new ArrayList<>();
        inOrderTraversal(tree, list);
        return list.get(list.size()-k);
    }

    public void inOrderTraversal(BST tree, List<Integer> array){
        if (tree==null) return;
        inOrderTraversal(tree.left, array);
        array.add(tree.value);
        inOrderTraversal(tree.right, array);
        return;
    }
}
