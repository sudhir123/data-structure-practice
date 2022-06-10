package com.prac.home.datastructures.companies.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class AmazonMock1_PrintLeftViewOnly {
    static class Node {
        int data; Node left, right;
        Node(int item) {
            data = item;
        }
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        /*root.left= new Node(2);
        root.right= new Node(3);
        root.left.right= new Node(4);
        root.right.right= new Node(5);
        root.right.right.left= new Node(6);*/
        leftView(root);
    }

    static void leftView(Node root){
        Queue<Node> mainQueue = new LinkedList<>();
        Queue<Node> childQueue = new LinkedList<>();
        mainQueue.add(root);
        boolean onlyZerothElement=true;
        while (!mainQueue.isEmpty()){
            Node x = mainQueue.poll();
            if (x!=null) {
                if (onlyZerothElement) {
                    System.out.println(x.data);
                    onlyZerothElement = false;
                }
                if (x.left != null) {
                    childQueue.add(x.left);
                }
                if (x.right != null) {
                    childQueue.add(x.right);
                }
                if (mainQueue.isEmpty()) {
                    mainQueue.addAll(childQueue);
                    childQueue = new LinkedList<>();
                    onlyZerothElement = true;
                }
            }
        }

    }
}
