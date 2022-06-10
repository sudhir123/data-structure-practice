package com.prac.home.datastructures.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Remove Duplicate From Unsorted LinkedList. If allowed to use different datastructure then hashset/ hashmap best in O(n)
 * if not allowed then O(n^2)
 */
public class RemoveDuplicateFromUnsortedLinkedList {

   static Node currentNode, headNode;



    static void removeDuplicate(Node headNode){
        Node currentNode = headNode;
        while (currentNode!=null){
            Node runner = currentNode;
            while (runner.next!=null) {
                if (runner.next.data == currentNode.data) {
                    runner.next = runner.next.next;
                } else {
                    runner= runner.next;
                }
            }
            currentNode= currentNode.next;
        }
    }
    static void deleteDups(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
                current =current.next;
            }
        }
    }


    public static void main(String[] args) {
        /*LinkedList l = new LinkedList(Arrays.asList(1,2,3,4,5,4));
        System.out.println(l);
        System.out.println(removeDuplicate(l));*/

        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(1);
        addNode(1);
        addNode(1);
        addNode(1);
        addNode(2);



        //printNode(headNode);

        removeDuplicate(headNode);

        printNode(headNode);

    }

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
    }

    @Data
    @AllArgsConstructor
    static class Node{
        Integer data;
        Node next;
    }

    static LinkedList removeDuplicate(LinkedList<Integer> linkedList){

        for(int i=0; i < linkedList.size(); i++){

            for(int j=0; j < linkedList.size(); j++){
                if(i!=j && linkedList.get(i)== linkedList.get(j)){
                    linkedList.remove(j);
                }
            }
        }

        return linkedList;
    }
}