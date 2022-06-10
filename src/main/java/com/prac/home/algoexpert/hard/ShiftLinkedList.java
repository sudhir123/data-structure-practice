package com.prac.home.algoexpert.hard;

import java.util.List;

public class ShiftLinkedList {

    public static void main(String[] args) {

        LinkedList head1 =new LinkedList(1);
        head1.next=new LinkedList(2);
        head1.next.next=new LinkedList(3);
        head1.next.next.next=new LinkedList(4);

        print(shiftLinkedList(head1, 2));
    }

    static void print(LinkedList headOne){
        LinkedList currentHeadOne= headOne;
        while (currentHeadOne!=null){
            System.out.println(currentHeadOne.value);
            currentHeadOne= currentHeadOne.next;
        }
    }
    //#algoexpert
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        int length =1;
        LinkedList listTail = head;
        while (listTail.next!=null){
            listTail= listTail.next;
            length++;
        }
        int offset = Math.abs(k) % length;
        if (offset==0) return head;
        int newTrailPosition = k>0 ? length-offset : offset;
        LinkedList newTail = head;
        for (int i=1; i < newTrailPosition; i++){
            newTail= newTail.next;
        }
        LinkedList newHead = newTail.next;
        newTail.next=null;
        listTail.next= head;
        return newHead;
    }

    // cracking the coding interview solution ..not working for negative
    public static LinkedList shiftLinkedList_cracking_coding_interview(LinkedList head, int k) {
        if (k==0 ) return head;
        LinkedList first = head;
        LinkedList second =head;
        int length =0;
        while (first!=null){
            first= first.next;
            length++;
        }
        int offset = Math.abs(k)%length;
        int newOffset = k>0 ? length-offset:offset;
        int i=0;
        first=head;
        while (i!=newOffset){
            second= second.next;
            i++;
        }
        while (second!=null && second.next!=null){
            first= first.next;
            second=second.next;
        }
        second.next= head;
        head= first.next;
        first.next=null;
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
