package com.prac.home.practice.algoexpert;

import com.prac.home.algoexpert.easy.RemoveDuplicateFromLinkedList;

import java.util.List;

public class RemoveDuplicatesFromLiskedList {
    public static void main(String[] args) {
        RemoveDuplicatesFromLiskedList r = new RemoveDuplicatesFromLiskedList();
        LinkedList head = new LinkedList(1);
        head.next= new LinkedList(1);
        head.next.next= new LinkedList(3);
        head.next.next.next= new LinkedList(4);
        head.next.next.next.next= new LinkedList(4);
        head.next.next.next.next.next= new LinkedList(4);
        head.next.next.next.next.next.next= new LinkedList(5);
        head.next.next.next.next.next.next.next= new LinkedList(6);

        r.print(r.removeDuplicatesFromLinkedList(head));
    }
    void print(LinkedList head){
        while (head!=null){
            System.out.print(head.value+"->");
            head= head.next;
        }
        System.out.print("null");
    }
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList head= linkedList;
        LinkedList current = linkedList;
        LinkedList prev= null;
        while (current!=null){
            if (prev!=null && prev.value==current.value){
                current= current.next;
                prev.next=current;
            }else {
                prev = current;
                current = current.next;
            }

        }
        return head;
    }
}
