package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CompareLeafTraversal {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        CompareLeafTraversal c = new CompareLeafTraversal();
        BinaryTree root1= new BinaryTree(1);
        root1.left=new BinaryTree(2);
        root1.right=new BinaryTree(3);
        root1.left.left=new BinaryTree(4);
        root1.left.right=new BinaryTree(5);
        root1.right.right=new BinaryTree(6);
        root1.left.right.left=new BinaryTree(7);
        root1.left.right.right=new BinaryTree(8);

        BinaryTree root2= new BinaryTree(1);
        root2.left=new BinaryTree(2);
        root2.right=new BinaryTree(3);
        root2.left.left=new BinaryTree(4);
        root2.left.right=new BinaryTree(7);
        root2.right.right=new BinaryTree(5);
        root2.right.right.left=new BinaryTree(8);
        root2.right.right.right=new BinaryTree(6);
        System.out.println(c.compareLeafTraversal(root1, root2));
    }
    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        Stack<BinaryTree> stack1= new Stack<>();
        stack1.push(tree1);
        Stack<BinaryTree> stack2= new Stack<>();
        stack2.push(tree2);
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            BinaryTree currentNode1= nextLeafNode(stack1);
            BinaryTree currentNode2= nextLeafNode(stack2);
            if (currentNode1.value!=currentNode2.value){
                return false;
            }
        }
        if (stack1.isEmpty()&& stack2.isEmpty()){
            return true;
        }else {
            return false;
        }

    }
    public BinaryTree nextLeafNode( Stack<BinaryTree> stack){
        BinaryTree currentNode = stack.pop();
        while (currentNode!=null && !isLeafNode(currentNode)){
            if (currentNode.right!=null){
                stack.push(currentNode.right);
            }
            if (currentNode.left!=null){
                stack.push(currentNode.left);
            }
            currentNode= stack.pop();
        }
        return currentNode;
    }
    public boolean isLeafNode(BinaryTree tree){
        if (tree.left==null && tree.right==null)
            return true;
        else
            return false;
    }



    // not a better way time complexity is O(n+m) and space also O(n+m). We can do better in terms of space O(h1+h2)

    /*List<Integer> list1= new ArrayList<>();
    List<Integer> list2= new ArrayList<>();
    traversal(tree1, list1);
    traversal(tree2, list2);
    System.out.println("list1: "+list1);
    System.out.println("list2: "+list2);
    return list1.size()!=list2.size();*/
    public BinaryTree traversal(BinaryTree tree, List<Integer> leafNodes){
        if (tree==null)
            return null;

        BinaryTree left = traversal(tree.left, leafNodes);
        BinaryTree right = traversal(tree.right, leafNodes);
        if (left==null && right==null){
            leafNodes.add(tree.value);
        }
        return tree;
    }
}
