package com.prac.home.datastructures.trees;

import java.util.Random;

/**
 * in this problem we need to implement RandomNodeGenerator, which is basically return the random from tree with 1/N prob that means
 * equal prob for each Node, treating each node equally, which also means if left tree has mode Nodes then prob of getting Random node is more
 * from Left side. For that best is to track the size of Nodes at each nodes(basically its subtree)
 */
public class BSTRandomNode {
    static class Node{
        int data;
        Node(int data){ this.data = data; size=1;}
        Node left, right;
        int size;

        void insertNode(int d){
            if (d<data){
                if (left==null) {
                    left=new Node(d);
                }else {
                    left.insertNode(d);
                }
            }else {
                if (right==null) {
                    right=new Node(d);
                }else {
                    right.insertNode(d);
                }
            }
            size++;
        }
        void printData( ){
            System.out.println(data);
            if (left!=null)
                left.printData();
            if (right!=null)
                right.printData();
        }

        Node find(int d){
            if (data==d) return this;
            else if (d<data)
                return left!=null ? left.find(d): null;
            else if (d> data)
                return right!=null? right.find(d):null;

            return null;
        }

        int size() {
            return size;
        }

        // solution1
        Node getRandomNode(){
            int leftSize = left == null? 0: left.size();
            Random r =new Random();
            int index = r.nextInt(size);
            if (index < leftSize){
                return left.getRandomNode();
            }else if (index==leftSize){
                return this;
            }else {
                return right.getRandomNode();
            }
        }

        // solution2  -> we will not have Random call again and again for every Node. We have it once and then use
        // logic to get on right or left side. But for that we need to know size of total tree that is size at root node.
        // which we have
        Node getRandomNodeSolution2(){
            Random r = new Random();
            int i = r.nextInt(size);
            return getIthNodeFromTree(i);
        }

        Node getIthNodeFromTree(int i){
            int leftSize= left==null ? 0: left.size;
            if (i < leftSize){
                return left.getIthNodeFromTree(i);
            }else if (leftSize==i){
                return this;
            }else {
                return right.getIthNodeFromTree(i-(leftSize+1));
            }
        }


    }

    Node root;

    public static void main(String[] args) {
        BSTRandomNode b =new BSTRandomNode();
        b.root= new Node(20);
        b.root.insertNode(10);
        b.root.insertNode(30);
        b.root.insertNode(5);
        b.root.insertNode(15);
        b.root.insertNode(17);
        b.root.insertNode(3);
        b.root.insertNode(7);
        b.root.insertNode(35);


        /*b.root.left= new Node(10);
        b.root.right= new Node(30);
        b.root.left.left= new Node(5);
        b.root.left.right= new Node(15);
        b.root.left.right.right= new Node(17);
        b.root.left.left.left= new Node(3);
        b.root.left.left.right= new Node(7);*/

        //b.root.printData();
        //System.out.println(b.root.find(30).data);
        //System.out.println(b.root.left.right.getRandomNode().data);

        // solution2
        System.out.println(b.root.getRandomNodeSolution2().data);
    }
}
