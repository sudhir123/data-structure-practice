package com.prac.home.algoexpert.medium;

import java.util.Map;

/**
 * singly linked list ...remove node from end. no new structure needs to be created. modify current one.
 */
public class RemoveKthNodeFromEnd {
    // best solution
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList first = head;
        LinkedList second= head; int count =1;
        while (count<k){
            second= second.next;
            count++;
        }
        if (second==null){
            head.next= head.next.next;
            return;
        }
        while (second.next!=null){
            first= first.next; /// this means we reached the prev node of the node we need to remove
            second= second.next;
        }
        first.next= first.next.next;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
    static void print(LinkedList head) {
        LinkedList current = head;
        System.out.println();
        System.out.println();
        while (current != null) {
            System.out.print(current.value + "-->");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next= new LinkedList(1);
        head.next.next= new LinkedList(2);
        head.next.next.next= new LinkedList(3);
        head.next.next.next.next= new LinkedList(4);
        head.next.next.next.next.next= new LinkedList(5);
        head.next.next.next.next.next.next= new LinkedList(6);
        head.next.next.next.next.next.next.next= new LinkedList(7);
        head.next.next.next.next.next.next.next.next= new LinkedList(8);
        head.next.next.next.next.next.next.next.next.next= new LinkedList(9);
        print(head);
        removeKthNodeFromEnd(head, 10);
        print(head);
    }
}
