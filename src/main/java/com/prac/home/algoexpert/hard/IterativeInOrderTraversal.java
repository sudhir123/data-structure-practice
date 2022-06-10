package com.prac.home.algoexpert.hard;


import java.util.function.Function;

public class IterativeInOrderTraversal {
    public static void main(String[] args) {
        BinaryTree root =new BinaryTree(1);
        root.left= new BinaryTree(2);
        root.left.parent= root;
        root.left.left= new BinaryTree(4);
        root.left.left.parent= root.left;
        root.left.left.right= new BinaryTree(9);
        root.left.left.right.parent= root.left.left;

        root.right= new BinaryTree(3);
        root.right.parent= root;
        root.right.left= new BinaryTree(6);
        root.right.left.parent= root.right;
        root.right.right= new BinaryTree(7);
        root.right.right.parent= root.right;
        iterativeInOrderTraversal(root, null);

    }
    public static void iterativeInOrderTraversal( BinaryTree tree, Function<BinaryTree, Void> callback) {
        meth1(tree, callback);
    }
    static void meth1(BinaryTree tree, Function<BinaryTree, Void> callback){
        BinaryTree previous = null;
        BinaryTree current =tree;
        while (current!=null ){
            BinaryTree nextNode ;
            if (previous==null || previous==current.parent) {
                if (current.left != null) {
                    nextNode = current.left;
                }else {
                    callback.apply(current);
                    nextNode= current.right != null? current.right: current.parent;
                }
            }else  if (previous == current.left) {
                callback.apply(current);
                nextNode= current.right!=null? current.right:current.parent;
            } else {
                nextNode= current.parent;
            }

            previous= current;
            current= nextNode;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}
