package com.prac.home.practice.algoexpert;

import java.util.List;

public class NodeSwap {
    public static class LinkedList {        public int value;        public LinkedList next;        public LinkedList(int value) {            this.value = value;            this.next = null;        }}

    public LinkedList nodeSwap(LinkedList head) {
        //head= nodeSwapRecursion(head);
        head= nodeSwapIterative(head);
        return head;
    }
    // meth1 without recursion
    // problem was when we do the first operation we will have head as 1 and which points to 0 and 0 points to 2. All perfect.
    // but soon after second operation our 0th node points to wrong node which is still 2 even after swap.
    public LinkedList nodeSwapIterative(LinkedList head) {
        LinkedList first= head,
                second = head.next;
        int i=0;
        LinkedList prev =null;
        while (first!=null && second!=null){
            swapTwoNodes(first, second);
            if (prev!=null){
                 prev.next= second;
            }
            if (i==0){
                head= second;
                i++;
            }
            prev= first;// tail
            first= first.next;
            if (first!=null){
                second=first.next;
            } else {
                second=null;
            }
        }
        return head;
    }

    // meth1 with recursion
    public LinkedList nodeSwapRecursion(LinkedList first) {
       if (first==null){
           return null;
       }
       LinkedList second = first.next;
       if (second==null){
           return first;
       }
       second.next = nodeSwapRecursion(second.next);
       return swapTwoNodes(first, second);
    }

    LinkedList swapTwoNodes(LinkedList first, LinkedList second){
        first.next= second.next;
        second.next=first;
        return second;
    }

    public static void main(String[] args) {
        NodeSwap n = new NodeSwap();
        NodeSwap.LinkedList head = new NodeSwap.LinkedList(0);
        head.next= new NodeSwap.LinkedList(1);
        head.next.next= new NodeSwap.LinkedList(2);
        head.next.next.next= new NodeSwap.LinkedList(3);
        head.next.next.next.next= new NodeSwap.LinkedList(4);
        head.next.next.next.next.next= new NodeSwap.LinkedList(5);
        //System.out.println(n.nodeSwap(head));
        System.out.println(n.nodeSwap(head));
    }
}
