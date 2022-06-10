package com.prac.home.leetcode;

public class RemoveNthNodeFromEnd {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        ListNode head= new ListNode(4);
        head.next= new ListNode(6);
        head.next.next= new ListNode(8);
        head.next.next.next= new ListNode(9);
        head.next.next.next.next= new ListNode(10);

        ListNode head2= new ListNode(1);
        head2.next= new ListNode(3);
        head2.next.next= new ListNode(5);
        head2.next.next.next= new ListNode(7);
        head2.next.next.next.next= new ListNode(11);

        RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
        /*ListNode current = r.removeNthFromEnd(head, 2);*/
        ListNode[] lists= new ListNode[]{head, head2};
        //ListNode current = r.mergeSortTwoList(head, head2);
        ListNode current = r.mergeKLists(lists);
        while (current!=null){
            System.out.print(current.val+"->");
            current= current.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        ListNode current=lists[0];
        for (int i=1; i< lists.length; i++){
            current= mergeSortTwoList(current, lists[i]);
        }
        return current;
    }

    public ListNode mergeSortTwoList(ListNode h1, ListNode h2) {
        ListNode cr1= h1;
        ListNode cr2 = h2;
        ListNode prev=null;
        while (cr1!=null && cr2!=null){
            if (cr1.val < cr2.val){
                while (cr1!=null&& cr1.val < cr2.val){
                    prev= cr1;
                    cr1= cr1.next;
                }
                prev.next= cr2;
            }else {
                while (cr2!=null&& cr2.val <= cr1.val){
                    prev= cr2;
                    cr2= cr2.next;
                }
                prev.next= cr1;
            }
        }
        while (cr1!=null){
            prev= cr1;
            cr1= cr1.next;
        }
        while (cr2!=null){
            prev= cr2;
            cr2= cr2.next;
        }
        if (h1!=null && h2 !=null ){
            if (h1.val< h2.val){
                return h1;
            }else {
                return h2;
            }
        }else {
            if (h1==null){
                return h2;
            }else {
                return h1;
            }
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=1;
        ListNode second =head;
        ListNode first =head;
        while (count<=n){
            second= second.next;
            count++;
        }
        if (second==null){
            head= head.next;
            return head;
        }
        while (second.next!=null){
            first= first.next;
            second= second.next;
        }
        first.next= first.next.next;
        return head;
    }

}
