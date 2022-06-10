package com.prac.home.algoexpert.hard;

import java.util.LinkedList;
import java.util.Queue;

public class RightSiblingTree {

    public static BinaryTree rightSiblingTree(BinaryTree root) {
        sibling(root);
        return root;
    }

    static void sibling(BinaryTree node){

        Queue<BinaryTreeInfo> mainQueue = new LinkedList<>();
        mainQueue.add(new BinaryTreeInfo(node, false, false));

        while (!mainQueue.isEmpty()){
            Queue<BinaryTreeInfo> childQueue= new LinkedList<>(mainQueue);

            mainQueue= new LinkedList<>();

            BinaryTreeInfo tempNode=null;
            while (!childQueue.isEmpty()){
                BinaryTreeInfo treeInfo= childQueue.poll();
                if (treeInfo.node.left!=null && treeInfo.node.right!=null){
                    mainQueue.add(new BinaryTreeInfo(treeInfo.node.left, true, true));
                    mainQueue.add(new BinaryTreeInfo(treeInfo.node.right, true, true));
                }else if (treeInfo.node.left!=null){
                    mainQueue.add(new BinaryTreeInfo(treeInfo.node.left, true, false));
                }else if (treeInfo.node.right!=null){
                    mainQueue.add(new BinaryTreeInfo(treeInfo.node.right, false, true));
                }

                if (tempNode==null){
                    tempNode= treeInfo;
                }else {
                    if (tempNode.nextNode && treeInfo.prevNode){
                        tempNode.node.right= treeInfo.node;
                    }
                }
                if (childQueue.isEmpty()){
                    treeInfo.node.right=null;
                }

                tempNode= treeInfo;
            }
        }
    }

    static class BinaryTreeInfo{
        BinaryTree node;
        boolean prevNode;
        boolean nextNode;
        BinaryTreeInfo(BinaryTree node, boolean prevNode, boolean nextNode){
            this.node= node;
            this.prevNode= prevNode;
            this.nextNode= nextNode;
        }
    }
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }



    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);

        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);

        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);

        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);

        root.left.right.right = new BinaryTree(10);

        root.right.left.left = new BinaryTree(11);

        root.right.right.left = new BinaryTree(12);
        root.right.right.right = new BinaryTree(13);

        root.right.left.left.left = new BinaryTree(14);

        rightSiblingTree(root);

    }
}
