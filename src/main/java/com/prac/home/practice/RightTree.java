package com.prac.home.practice;

import java.util.*;

public class RightTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.right= new TreeNode(4);
        //root.right.right= new TreeNode(5);
        RightTree r = new RightTree();
        System.out.println(r.rightSideView(root));
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        traverse(root, tree);
        return tree;
    }
    public void traverse(TreeNode root, List<Integer> tree) {
        if (root==null) return;
        Queue<Queue<TreeNode>> mainQueue= new LinkedList();
        Queue q = new LinkedList();
        q.add(root);
        mainQueue.add(q);
        while (!mainQueue.isEmpty()){
            Queue<TreeNode> currentQueue = mainQueue.poll();
            int size = 0;
            int n = currentQueue.size();
            Queue childQueue = new LinkedList();
            if(!currentQueue.isEmpty()) {
                mainQueue.add(childQueue);
            }
            while (!currentQueue.isEmpty()) {
                TreeNode currentRoot = currentQueue.poll();
                if (size==n-1){
                    tree.add(currentRoot.val);
                }
                if (currentRoot.left != null) {
                    childQueue.add(currentRoot.left);
                }
                if (currentRoot.right != null) {
                    childQueue.add(currentRoot.right);
                }

                size++;
            }
        }
    }
}






















