package com.prac.home.practice;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        PalindromeLinkedList p = new PalindromeLinkedList();
        System.out.println(p.isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current!=null){
            list.add(current.val);
            current= current.next;
        }
        boolean isOdd = list.size()%2!=0;
        int i=0, j=0;
        if (isOdd){
            i=j=list.size()/2;

        }else {
            i=(list.size()/2)-1;
            j=(list.size()/2);
        }
        while (i>=0 && j <= list.size()-1){
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

}
