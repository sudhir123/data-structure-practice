package com.prac.home.geeks4geeks;

public class PrintOneRearAndOneFromEndLinkedList {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        PrintOneRearAndOneFromEndLinkedList p = new PrintOneRearAndOneFromEndLinkedList();
        p.reorderList(head);
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next==null){
            return null;
        }
        ListNode first = head, second= head;
        ListNode prev= head;
        while (second!=null && second.next!=null){
            prev= first;
            first= first.next;
            second= second.next.next;
        }
        prev.next= first.next;
        first.next=null;
        return head;
    }
    public void reorderList(ListNode head) {
        // reverse half nodes
        ListNode first = head, second= head;
        while (second!=null && second.next!=null){
            first= first.next;
            second= second.next.next;
        }

        ListNode lastHeadNode = reverse(first);
        first= head;
        while (lastHeadNode!=null && lastHeadNode.next!=null){
            ListNode firstNext= first.next;
            ListNode lastHeadNodeNext = lastHeadNode.next;
            first.next= lastHeadNode;
            lastHeadNode.next= firstNext;
            lastHeadNode= lastHeadNodeNext;
            first= firstNext;
        }
        ListNode current = head;
        while (current!=null){
            System.out.println(current.val);
            current= current.next;
        }
    }
    public ListNode reverse(ListNode firstNode){
        ListNode current = firstNode;
        ListNode prev=null;
        while (current!=null){
            ListNode next = current.next;
            current.next=prev;
            prev= current;
            current =next;
        }
        return prev;
    }
}
