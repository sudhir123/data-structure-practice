package com.prac.home.datastructures.trees;
/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent
 *
 * Logic:- A node’s inorder successor is the node with the least value in its right subtree, i.e., its right subtree’s leftmost child.
 * If the right subtree of the node doesn’t exist, then the inorder successor is one of its ancestors.
 * To find which ancestors are the successor, we can move up the tree towards the root until we encounter a node
 * that is left child of its parent. If any such node is found, then inorder successor is its parent; otherwise,
 * inorder successor does not exist for the node.
 * Logically in an inorder traversal. we print Left than root and than to right ... so as per this any node ,next traversal will be right
 * but in right now left most node element , because we move left with recursion
 */
public class Successor {
    Node root;

    static class Node{
        int data; Node left, right;
        Node(int data){ this.data=data;}
    }
    //so with above logic , we need one method where we traverse most left , another we travel most right

    Node leftMost(Node root){
        while (root!=null && root.left!=null){
            root= root.left;
        }
        return root;
    }
    Node rightMost(Node root){
        while (root!=null && root.right!=null){
            root= root.right;
        }
        return root;
    }

    void traverse(Node root, Node x){
        if (root==null) return ;
        Node temp;
        if (x.right!=null){
            temp = leftMost(x.right);
        }else {
            // right null then parent' parent is a successor
            temp = rightMost(root);
            if (temp==x){
                return; // because if it right most node all parent is printed already
            }else {
                inOrderTraversal(x, root);
            }
        }
    }

    Node inOrderTraversal( Node n, Node root){
        if (root==null) return null;
        Node temp = null;
        if (n==root || ((temp =inOrderTraversal(n, root.left))!=null) ||((temp =inOrderTraversal(n, root.right))!=null)){
            if (temp!=null){
                if (root.left==temp){
                    System.out.println(root.data);
                    return null;
                }
            }
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Successor s = new Successor();
        s.root= new Node(1);
        s.root.left= new Node(2);
        s.root.right= new Node(3);
        s.root.left.left= new Node(4);
        s.root.left.right= new Node(5);
        s.root.left.right.right= new Node(7);
        s.root.right.right= new Node(6);
        s.traverse(s.root,s.root.left.right.right);
    }
}



















