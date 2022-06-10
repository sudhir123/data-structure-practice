package com.prac.home.algoexpert.easy;

import com.prac.home.algoexpert.hard.AllKindsOfNodeDepth;

/**
 * function to return the sum of nodes depth
 */
public class NodeDepth {
    public static int nodeDepths(BinaryTree root) {
       return nodeDepthsHelper(root, 0);
    }
   /* static int nodeDepthsHelper(BinaryTree root, int depth){
        if (root==null) return 0;
        return depth+nodeDepthsHelper(root.left, depth+1)+nodeDepthsHelper(root.right, depth+1);
    }*/

    static int nodeDepthsHelper(BinaryTree root, int depth){
        if (root==null) return 0;
        int depth1= nodeDepthsHelper(root.left, depth+1);
        int depth2 = nodeDepthsHelper(root.right, depth+1);
        return depth+depth1+depth2;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        NodeDepth nodeDepth =new NodeDepth();
        BinaryTree root = new BinaryTree(1);
        root.left= new BinaryTree(2);
        root.right= new BinaryTree(3);
        root.left.left=new BinaryTree(4);
        root.left.right=new BinaryTree(5);
        root.right.left= new BinaryTree(6);
        root.right.right= new BinaryTree(7);
        root.left.left.left=new BinaryTree(8);
        root.left.left.right=new BinaryTree(9);
        System.out.println(nodeDepths(root));
    }
    
}
