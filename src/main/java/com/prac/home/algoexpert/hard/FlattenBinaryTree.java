package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * flatter binary tree is structure that is identical to double linked list. only diff is double linked list has prev and next
 * here in we left and right.
 */
public class FlattenBinaryTree {
    public static void main(String[] args) {
        BinaryTree root =new BinaryTree(1);
        root.left= new BinaryTree(2);
        root.right= new BinaryTree(3);
        root.left.left= new BinaryTree(4);
        root.left.right= new BinaryTree(5 );
        root.right.left= new BinaryTree(6);
        root.left.right.left= new BinaryTree(7);
        root.left.right.right= new BinaryTree(8);
        flattenBinaryTree(root);
    }
    // time O(N) space O(d)
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        root= flattenTree(root)[0];
        return root;
    }

    public static BinaryTree[] flattenTree(BinaryTree root) {
        BinaryTree leftMost;
        BinaryTree rightMost;
        if (root.left==null){
            leftMost= root;
        }else {
            BinaryTree[] binaryTrees= flattenTree(root.left);
            connectNodes(binaryTrees[1], root);
            leftMost= binaryTrees[0];
        }

        if (root.right==null){
            rightMost= root;
        }else {
            BinaryTree[] binaryTrees= flattenTree(root.right);
            connectNodes(root, binaryTrees[0]);
            rightMost= binaryTrees[1];
        }
        return new BinaryTree[]{leftMost, rightMost};
    }

    static void connectNodes(BinaryTree left, BinaryTree right){
        left.right= right;
        right.left= left;
    }



    /* time  O(N) and space O(N)
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        List<BinaryTree> nodes = new ArrayList<>() ;
        meth1(root, nodes);
        BinaryTree tree =null;
        for (int i=0; i < nodes.size(); i++) {
            if (i==0){
                tree= new BinaryTree(nodes.get(0).value);
                root= tree;
            }else {
                BinaryTree temp = tree;
                tree.right= new BinaryTree(nodes.get(i).value);
                tree= tree.right;
                tree.left= temp;
            }
        }
        return root;
    }*/

    static void meth1(BinaryTree node, List<BinaryTree> trees){
        if (node==null) {
            return;
        }
        meth1(node.left,trees);
        System.out.println(node.value);
        trees.add(node);
        meth1(node.right, trees);
    }
    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
