package com.prac.home.geeks4geeks;

import java.util.List;

public class PairWiseSwap {
    static public class ListNode {
    int val;
 ListNode next;
     ListNode() {}ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode swapPairs(ListNode head) {
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
