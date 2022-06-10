package com.prac.home.datastructures.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

public class RecurssiveCount {
    static int count(Node headNode){
        if(headNode==null) return 0;
        else return count(headNode.next)+1;
    }

    public static void main(String[] args) {
        addNode(1);addNode(2);addNode(3);addNode(4);addNode(5);
        System.out.println(count(headNode));
    }
    @Data
    @AllArgsConstructor
    static class Node{
        Integer data; Node next;
    }
    static Node currentNode, headNode, currentNodeOdd, headNodeOdd, currentNodeEven, headNodeEven;

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
