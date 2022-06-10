package com.prac.home.practice;

public class LinkedListPalindrom {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
    static boolean isPalindrome(ListNode head) {
        // my understanding is reverse and create new and compare
        // better is reverse 1/2 of the linkedList and than compare
        ListNode fist=head;
        ListNode sec = head;
        while (sec!=null && sec.next!=null){
            fist=fist.next;
            sec= sec.next.next;
        }
        ListNode endNode= reverse(fist);
        sec= head;
        while (sec!=null && endNode!=null){
            if (sec.val!=endNode.val){
                return false;
            }
            sec= sec.next;
            endNode= endNode.next;
        }
        return true;
    }
    static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev=null;
        while (curr!=null ) {
            ListNode next =curr.next;
            curr.next= prev;
            prev= curr;
            curr= next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(2);
        head.next.next.next.next= new ListNode(1);
        System.out.println(isPalindrome(head));
        /*ListNode curr = reverse(head);
        while (curr!=null){
            System.out.println(curr.val);
            curr=curr.next;
        }*/
    }
}
