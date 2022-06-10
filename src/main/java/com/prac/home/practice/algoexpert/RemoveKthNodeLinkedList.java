package com.prac.home.practice.algoexpert;

public class RemoveKthNodeLinkedList {
    public static void main(String[] args) {
        LinkedList head= new LinkedList(1);
        head.next= new LinkedList(2);
        head.next.next= new LinkedList(3);
        head.next.next.next= new LinkedList(4);
        head.next.next.next.next= new LinkedList(5);
        head.next.next.next.next.next= new LinkedList(6);
        removeKthNodeFromEnd(head, 3);
        LinkedList current= head;
        while (current!=null){
            System.out.println(current.value);
            current=current.next;
        }
    }
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList fist =head;
        LinkedList second = head;
        while (k!=0){
            second= second.next;
            k--;
        }
        if (second==null){

        }
        while (second.next!=null){
            fist=fist.next;
            second= second.next;
        }
        fist.next= fist.next.next;
    }



    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
