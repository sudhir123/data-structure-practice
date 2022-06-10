package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * write a 3 functions takes BST and an empty array. One function traverse in IN Order , another in pre order and last in post order
 */
public class BSTTraversal {
    public static void main(String[] args) { //10,5,2,1,
        root = new BST(10);
        root.left = new BST(5);
        root.right = new BST(15);
        root.right.right = new BST(22);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.left.left.left = new BST(1);
        System.out.println(postOrderTraverse(root, new ArrayList<>()));
    }
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null)
            return array;
        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);
        return array;
    }


    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;
        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);
        return array;
    }
    //1, 2, 5, 5, 22, 15, 10
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;
        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);

        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    static BST root;


}
