package com.prac.home.datastructures.trees;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you 'll have D linked lists).
 */
public class ListOfDepthsProblem {
    int[] a= {1,2,3,4,5,6,7,8,9} ;

    // returns root of the tree using Mid element (minimum length)/// used for length of tree
    Node createTreeFromExistingArray(int[] a, int start, int end, int counter,ArrayList<LinkedList<Integer>> lists){
        if(end<start) {
            return null;
        }
        int mid = (start+end) /2;
        Node n = new Node(a[mid]);
        if(lists.size()==counter){
            lists.add(counter, new LinkedList<Integer>());
        }
        lists.get(counter).add(n.data);
        counter++;
        n.left= createTreeFromExistingArray(a,start, mid-1,counter, lists);
        n.right= createTreeFromExistingArray(a,mid+1, end, counter, lists);
        return n;
    }

    // lets say we have root element to tree now how we create list with all nodes at same level
    void createListsOfNodesAtSameLevelWithRootNode(Node root, int level, ArrayList<LinkedList<Node>> arrayLists ){
        if (root==null) return;
        if(arrayLists.size()==level){
            LinkedList<Node> l = new LinkedList<>();
            arrayLists.add(l);
        }else{
            arrayLists.get(level).add(root) ;
        }
       // System.out.print("level "+level +" and data "+root.data);System.out.println();
        createListsOfNodesAtSameLevelWithRootNode(root.left, level+1, arrayLists);
        createListsOfNodesAtSameLevelWithRootNode(root.right, level+1, arrayLists);
    }

    // another way is using Breadth First traverse. Nodes at same level will be traversed first
    // run in O(n ) but its space efficient then recursion
    ArrayList<LinkedList<Node>> createListsOfNodesAtSameLevelWithBreadthFirstTraverse(Node root){

        ArrayList<LinkedList<Node>> arrayList= new ArrayList<>();
        LinkedList<Node> current= new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()){
            arrayList.add(current);
            LinkedList<Node> parent =current;
            current= new LinkedList<>();
            for (Node n :
                 parent) {
                if(n.left!=null) {
                    current.add(n.left);
                }
                if(n.right!=null){
                    current.add(n.right);
                }
            }
        }
        return arrayList;
    }



    public static void main(String[] args) {
        ListOfDepthsProblem l = new ListOfDepthsProblem();
        ArrayList<LinkedList<Integer>> list=new ArrayList<>();
        Node root= l.createTreeFromExistingArray(l.a, 0, l.a.length-1, 0, list);
        //l.printCreatedListOfList(list);

        //ArrayList<LinkedList<Node>> arrayLists=new ArrayList<>();
       //l.createListsOfNodesAtSameLevelWithRootNode(root, 0, arrayLists);

        ArrayList<LinkedList<Node>> arrayListWithBFT = l.createListsOfNodesAtSameLevelWithBreadthFirstTraverse(root);
        l.printCreatedListOfListWithNodes(arrayListWithBFT);

    }
    void printCreatedListOfListWithNodes(ArrayList<LinkedList<Node>> list){
        list.stream().forEach(x-> {
            x.stream().forEach(y-> System.out.print(" Data: " +y.data+" "));
            System.out.println();
        });
    }

    void printCreatedListOfList(ArrayList<LinkedList<Integer>> list){
        list.stream().forEach(x-> {
            x.stream().forEach(y-> System.out.print(" Data: " +y+" "));
            System.out.println();
        });
    }


    class Node{
        int data;
        Node right, left;
        Node(int data){ this.data=data;}
    }
}
