package com.prac.home.practice;

public class SwapNodesInPair {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);
        ListNode c= swapPairs(head);
        while (c!=null){
            System.out.println(c.val);
            c= c.next;
        }
    }
    static ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode p= head;
        ListNode newHead= head.next;
        ListNode q;
        while (true){
            q=p.next;
            ListNode temp = q.next;
            q.next= p;
            if (temp==null || temp.next==null){
                p.next= temp;
                break;
            }
            p.next= temp.next;
            p=temp;
        }
        return newHead;
    }
}
