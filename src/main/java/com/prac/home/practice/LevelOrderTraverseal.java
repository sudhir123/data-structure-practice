package com.prac.home.practice;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverseal {
    static class TreeNode {
        int val;        TreeNode left;        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        LevelOrderTraverseal l = new LevelOrderTraverseal();
        System.out.println(l.levelOrder(root)        );
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Queue<TreeNode>> mainQueue= new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> rootQueue = new LinkedList<>();
        List<Integer> rootList = new ArrayList<>();
        rootQueue.add(root);
        rootList.add(root.val);

        mainQueue.add(rootQueue);
        result.add(rootList);

        while (!mainQueue.isEmpty()){
            //result.add(mainQueue.peek());
            rootQueue = mainQueue.poll();
            Queue<TreeNode> childQueue= new LinkedList<>();
            List<Integer> childList= new ArrayList<>();
            while (!rootQueue.isEmpty()){
                TreeNode node= rootQueue.poll();
                if (node.left!=null){
                    childList.add(node.left.val);
                    childQueue.add(node.left);
                }
                if (node.right!=null){
                    childList.add(node.right.val);
                    childQueue.add(node.right);
                }
            }
            if (!childQueue.isEmpty()){
                mainQueue.add(childQueue);
                result.add(childList);
            }

        }
        return result;
    }

}