package com.prac.home.geeks4geeks;

public class HeightOfBinaryTree {
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left= new Node(2);
        root.right= new Node(3);

        /*root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.left.right.right= new Node(6);

        root.right= new Node(7);
        root.right.right= new Node(8);
        root.right.right.right= new Node(9);
        root.right.right.right.right= new Node(10);*/
        System.out.println(height(root));
    }
    static int height(Node node) {
        if (node==null) return 0;
        int leftHeight = height(node.left)+1;
        int rightHeight= height(node.right)+1;
        return Math.max(leftHeight, rightHeight);
    }
}
