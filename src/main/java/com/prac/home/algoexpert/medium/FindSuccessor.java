package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * we have given a binary tree, and random node from tree. we need ot find the successor of that node, which mean what is next node
 * will be using in-order traversal.
 */
public class FindSuccessor {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if (node.right!=null){
            // for any random node .. straight is if it has right node then right or if right has left then leftmost in right
            return getLeftMostChild(node.right); // confirm case
        }else {
            return getRightMostParent(node);
        }
    }
    BinaryTree getLeftMostChild(BinaryTree root){
        while (root!=null && root.left!=null){
            root= root.left;
        }
        return root;
    }

    BinaryTree getRightMostParent(BinaryTree tree){
        BinaryTree currentNode = tree;
        while (currentNode.parent!=null && currentNode.parent.right==currentNode){
            currentNode= currentNode.parent;
        }
        return currentNode.parent;
    }


   public static void main(String[] args) {
        FindSuccessor f = new FindSuccessor();
        BinaryTree root= new BinaryTree(1);
       root.left= new BinaryTree(2);
       root.left.parent=root;
       root.right=new BinaryTree(3);
       root.right.parent=root;


       root.left.left=new BinaryTree(4);
       root.left.left.parent=root.left;

       root.left.right=new BinaryTree(5);
       root.left.right.parent= root.left;

       root.left.right.left= new BinaryTree(6);
       root.left.right.left.parent= root.left.right;
       root.left.right.right= new BinaryTree(7);
       root.left.right.right.parent=root.left.right;

       root.left.right.right.left=new BinaryTree(8);
       root.left.right.right.left.parent= root.left.right.right;

       System.out.println(f.findSuccessor(root, root.left.right).value);
    }
}























