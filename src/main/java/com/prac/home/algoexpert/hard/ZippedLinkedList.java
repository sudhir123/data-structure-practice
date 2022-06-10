package com.prac.home.algoexpert.hard;

public class ZippedLinkedList {
    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next= new LinkedList(2);
        head.next.next= new LinkedList(3);
        head.next.next.next= new LinkedList(4);
        head.next.next.next.next= new LinkedList(5);

        LinkedList curr= zipLinkedList(head);
        while (curr!=null){
            System.out.print(curr.value+"-");
            curr=curr.next;
        }
    }
    static LinkedList zipLinkedList(LinkedList linkedList) {
        // 1/2 reverse and than work on each node side by side
        LinkedList first= linkedList;
        LinkedList second = linkedList;
        while (second!=null && second.next!=null){
            first= first.next;
            second= second.next.next;
        }
        LinkedList endHead = reverse(first);
        LinkedList frontHead= linkedList;
        LinkedList prev=null;
        while (frontHead!=null && endHead!=null && frontHead !=endHead){
            if (prev==null){
                prev= frontHead;
            }else {
                prev.next= frontHead;
                prev= prev.next;
            }
            frontHead= frontHead.next;
            prev.next= endHead;
            endHead= endHead.next;
            prev= prev.next;
        }
        return linkedList;
    }

    // reverse
    static LinkedList reverse(LinkedList head){
        LinkedList curr = head;
        LinkedList prev =null;
        while (curr!=null){
            LinkedList next = curr.next;
            curr.next= prev;
            prev= curr;
            curr= next;
        }
        return prev;
    }
}
