package com.prac.home.datastructures.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * provided only middleNode. simply copy data of the next node to this and delete next node.
 */
public class DeleteMiddleNodeOfSinglyLinkedList {


    static Node deleteMiddleNode(Node anyNode){
        if(anyNode.next==null){
            // that means its a last node
            anyNode=null;
        }else {
            Node node = anyNode.next;
            anyNode.data = node.data;
            anyNode.next = node.next;
        }
        return anyNode;
    }


    public static void main(String[] args) {
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);
        addNode(6);
        addNode(7);
        Node nodeToBeDeleted= addNode(8);

        printNode(headNode);
        System.out.println();
        deleteMiddleNode(nodeToBeDeleted);
        printNode(headNode);

    }

    @Data
    @AllArgsConstructor
    static class Node{
        Integer data; Node next;
    }
    static Node currentNode, headNode;

    static Node addNode(Integer data){
        if(headNode==null){
            headNode= new Node(data, null);
            currentNode= headNode;
        }else {
            currentNode.next= new Node(data, null);
            currentNode= currentNode.next;
        }
        return currentNode;
    }
    static void printNode(Node headNode){
        Node tempNode = headNode;
        while(tempNode.next!=null){
            System.out.println(tempNode.data);
            tempNode= tempNode.next;
        }
        System.out.println(tempNode.data);
    }
}
