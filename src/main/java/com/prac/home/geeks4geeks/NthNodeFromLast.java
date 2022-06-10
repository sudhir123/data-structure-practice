package com.prac.home.geeks4geeks;

public class NthNodeFromLast {
    static class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    public static boolean detectLoop(Node head){
        Node first =head;
        Node second = head;
        while (second!=null && second.next!=null){
            first= first.next;
            second= second.next.next;
            if (first==second){
                return true;
            }
        }
        return false;
    }
    public static void removeLoop(Node head){
        Node first =head;
        Node second = head;
        while (second!=null && second.next!=null){
            first= first.next;
            second= second.next.next;
            if (first==second){
                first=head;
                break;
            }
        }
        Node prev =null;
        while (first!=second){
            prev= second;
            first= first.next;
            second= second.next;
        }
        if (prev!=null){
            prev.next=null;
        }
    }
    int getNthFromLast(Node head, int n){
        Node first =head;
        Node second = head;
        int count =1;
        while (count<=n){
            second= second.next;
        }
        while (second!=null){
            first= first.next;
            second= second.next;
        }
        return first.data;
    }
}
