package com.prac.home.algoexpert.hard;

import com.prac.home.datastructures.linkedlist.ReversingLinkedListUsingRecurssive;

public class ReverseLinkedListNotOnlyPrinting {
    public static void main(String[] args) {
        LinkedList head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);
        head.next.next.next.next.next = newNode(6);
        head.next.next.next.next.next.next = newNode(7);
        printNode(reverseLinkedList(head));
    }
    static LinkedList newNode(int data){
        LinkedList new_node = new LinkedList(data);
        new_node.value = data;
        new_node.next = null;
        return new_node;
    }

    static void printNode(LinkedList headNode){
        LinkedList tempNode = headNode;
        while(tempNode.next!=null){
            System.out.println(tempNode.value);
            tempNode= tempNode.next;
        }
        System.out.println(tempNode.value);
    }
    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList p1= head;
        LinkedList p2= p1.next;
        p1.next=null;
        LinkedList p3 =null;
        while (p1!=null && p2!=null ){
            p3= p2.next;
            p2.next= p1;
            p1=p2;
            p2=p3;
        }
        head= p2!=null?p2:p1;

        return head;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
