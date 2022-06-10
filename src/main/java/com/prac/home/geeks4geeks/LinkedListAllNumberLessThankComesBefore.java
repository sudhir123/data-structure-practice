package com.prac.home.geeks4geeks;

public class LinkedListAllNumberLessThankComesBefore {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
            this.next=null;
        }
    }
    public static void main(String[] args) {
        Node head= new Node(5);
        head.next= new Node(10);
        head.next.next= new Node(20);
        head.next.next.next= new Node(6);
        head.next.next.next.next= new Node(3);
        Node current = arrange(head, 20);
        while (current!=null){
            System.out.println(current.data);
            current= current.next;
        }
    }

    static Node arrange(Node head, int k){
        Node less= null, lessHead=null, more=null, moreHead=null, equal= null, equalHead=null;
        Node currnet = head;

        while (currnet!=null){
            if (currnet.data< k){
                if (less==null){
                    less= new Node(currnet.data);
                    lessHead= less;
                }else {
                    less.next= new Node(currnet.data);
                    less= less.next;
                }
            }else if (currnet.data==k){
                if (equal==null){
                    equal= new Node(currnet.data);
                    equalHead= equal;
                }else {
                    equal.next= new Node(currnet.data);
                    equal= equal.next;
                }
            }else {
                if (more==null){
                    more= new Node(currnet.data);
                    moreHead= more;
                }else {
                    more.next= new Node(currnet.data);
                    more= more.next;
                }
            }
            currnet= currnet.next;
        }
        if (less!=null){
            less.next= equalHead;
        }
        if (equal!=null){
            equal.next= moreHead;
        }
        if (lessHead!=null){
            return lessHead;
        }else if (equalHead!=null){
            return equalHead;
        }else {
            return moreHead;
        }
    }
}
