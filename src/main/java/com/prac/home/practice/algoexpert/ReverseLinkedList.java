package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    // basically reverse the pointers
    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList p1=head;
        LinkedList p2= p1.next;
        p1.next=null;
        LinkedList p3=null;
        while (p1!=null && p2!=null){
            p3= p2.next;
            p2.next= p1;
            p1= p2;
            p2= p3;
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
