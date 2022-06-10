package com.prac.home.practice.algoexpert;

import java.util.List;

public class ShiftLinkedList {
    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next= new LinkedList(2);
        head.next.next.next= new LinkedList(3);
        head.next.next.next.next= new LinkedList(4);
        head.next.next.next.next.next= new LinkedList(5);
        LinkedList current = shiftLinkedList(head, 2);
        while (current!=null){
            System.out.print(current.value+"->");
            current=current.next;
        }
    }
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        int totalElements=1;
        LinkedList current= head;
        while (current.next!=null){
            current= current.next;
            totalElements++;
        }
        current.next= head;
        int count=1;
        while (totalElements-k!=count){
            head= head.next;
            count++;
        }
        LinkedList prev= head;
        head= head.next;
        prev.next=null;
        return head;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
