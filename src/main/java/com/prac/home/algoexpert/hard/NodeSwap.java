package com.prac.home.algoexpert.hard;

public class NodeSwap {
    public static void main(String[] args) {
        LinkedList head= new LinkedList(1);
        //head.next= new LinkedList(2);
        //head.next.next= new LinkedList(3);
        LinkedList cur = nodeSwap(head);
        while (cur!=null){
            System.out.print(cur.value+"->");
            cur= cur.next;
        }
    }
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static LinkedList nodeSwap(LinkedList head) {
        if (head==null || head.next==null){
            return head;
        }
        LinkedList p =head;
        LinkedList newHead = p.next;
        LinkedList q;
        while (true){
            q= p.next;
            LinkedList temp = q.next;
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
