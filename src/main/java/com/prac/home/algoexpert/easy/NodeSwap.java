package com.prac.home.algoexpert.easy;

import lombok.Data;

/**
 * function to swap the adjacent element of LinkedList return the head of LinkedList. 0->1->2->3->4->5   ret 1->0->3->2->5->4
 */

public class NodeSwap {
    @Data
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList nodeSwap(LinkedList head) {
        LinkedList current = head, previous = head;
        while (current!=null){

            LinkedList nextNode = current.next;
            if (nextNode!=null){
                if (current==head){
                    head= nextNode;
                }
                previous.next=nextNode;
                current.next= nextNode.next;
                nextNode.next= current;

            }
            previous=current;
            current= current.next;
        }
        return head;
    }

    // this is O(n) time and O(n) space. To understand think of this as single tree.
    // secondlast node will point to null and last ode points to secondlast. swap done.
    LinkedList nodeSwapRecursive(LinkedList node){
        if (node==null || node.next==null) return node;
        LinkedList nextNode = node.next; // this could be last
        node.next= nodeSwapRecursive(node.next.next);
        nextNode.next= node;
        return nextNode;
    }



    public static void main(String[] args) {
        NodeSwap n = new NodeSwap();
        LinkedList head = new LinkedList(0);
        head.next= new LinkedList(1);
        head.next.next= new LinkedList(2);
        head.next.next.next= new LinkedList(3);
        head.next.next.next.next= new LinkedList(4);
        head.next.next.next.next.next= new LinkedList(5);
        //System.out.println(n.nodeSwap(head));
        System.out.println(n.nodeSwapRecursive(head));
    }
}
