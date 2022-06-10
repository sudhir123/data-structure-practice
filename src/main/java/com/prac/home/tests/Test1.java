package com.prac.home.tests;


import java.util.LinkedList;
import java.util.Queue;

public class Test1 {

    static  class Node{
        int data;
        Node right;
        Node left;
        Node parent;
        Node(int data, Node parent){
            this.data= data;
            this.parent= parent;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5, null);
        root.left= new Node(1, root);
        root.right= new Node(2, root);

        root.left.left= new Node(3,root.left);
        root.left.right= new Node(4, root.left);

        root.right.left= new Node(7,root.right );
        root.right.right= new Node(9,root.right );

        treeStruct(root, 3);
    }


    static void treeStruct(Node root, int searchData){
        Queue<Node> mainQueu = new LinkedList<>();
        Queue<Node> chileQueue= new LinkedList<>();
        boolean level= false;
        Node par=null;
        mainQueu.add(root);
        while (!mainQueu.isEmpty()){
            Node parentNode = mainQueu.poll();
            if (parentNode.left!=null){
                chileQueue.add(parentNode.left);
            }
            if (parentNode.right!=null){
                chileQueue.add(parentNode.right);
            }
            if (parentNode.data==searchData){
                level= true;
                par= parentNode.parent;
            }
            if (level && par!=null && par!= parentNode.parent){
                System.out.println(parentNode.data);
            }
            if (mainQueu.isEmpty()){
                mainQueu.addAll(chileQueue);
                chileQueue= new LinkedList<>();
                level= false;
            }
        }
    }

}






















