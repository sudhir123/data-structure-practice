package com.prac.home.practice.algoexpert;

import lombok.Getter;
import lombok.Setter;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional
 * nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
public class FirstCommonAncestor {
    // with links to parent
    @Getter@Setter
    static class Node{
        int data;
        Node parent, right , left;
        Node(int data){this.data=data;}
    }

    public static void main(String[] args) {
        FirstCommonAncestor f = new FirstCommonAncestor();

        Node root = new Node(20);
        root.left= new Node(10);
        root.left.parent=root;
        root.right= new Node(30);
        root.right.parent=root;

        root.left.left= new Node(5);
        root.left.left.parent= root.left;
        root.left.right= new Node(15);
        root.left.right.parent=root.left;

        root.left.left.left=new Node(3);
        root.left.left.left.parent=root.left.left;
        root.left.left.right= new Node(7);
        root.left.left.right.parent=root.left.left;

        root.left.right.right= new Node(17);
        root.left.right.right.parent= root.left.right;

        Node node = f.commonAncestorWithSingleTraverse(root, root.left.left.left, new Node(188)) ;
        System.out.println(node.data);
    }

    Node commonAncestorWithSingleTraverse(Node root, Node p, Node q){
        if (root==null) return null;
        if (root==p || root==q)
            return root;

        Node x = commonAncestorWithSingleTraverse(root.left, p, q);
        if (x!=null && (x!=p && x!=q)){
            return x;
        }
        Node y = commonAncestorWithSingleTraverse(root.right, p, q);
        if (y!=null && (y!=p && y!=q)){
            return y;
        }
        if (x==y){
            return root;
        }else {

        }
return null;
    }
}






































































































