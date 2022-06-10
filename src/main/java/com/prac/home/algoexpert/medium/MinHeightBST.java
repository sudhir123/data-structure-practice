package com.prac.home.algoexpert.medium;

import java.util.Arrays;
import java.util.List;

/**
 * function takes an array as an argument and return the root node of BST. Generate the BST with minimum height
 */
public class MinHeightBST {
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return minHeightBst(array, 0, array.size()-1);
    }

    static BST minHeightBst(List<Integer> array, int start, int end) {
        if (start>end) return null;
        int mid = (start+end)/2;
        BST root = new BST(array.get(mid));
        root.left= minHeightBst(array, start, mid-1);
        root.right = minHeightBst(array, mid+1, end);
        return root;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
    public static void main(String[] args) {
        BST root = minHeightBst(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22));
        System.out.println(root);
    }
}
