package com.prac.home.datastructures.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * last 3rd element in singly linkedlist. Two ways one loop and get the size and then loop again.
 * another is recursive. reach till last element and let it complete and while coming back increment counter.
 */
public class KthElementFromLast {
    @Data
    @AllArgsConstructor
    static class Node{
        Integer data; Node next;
    }
    @Data
    @AllArgsConstructor
    static class Index{
        Integer idx;
    }
    static Node currentNode, headNode;

    public static void main(String[] args) {
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);
        addNode(6);
        addNode(7);
        addNode(8);

        /*
        Index index= new Index(0);
        System.out.println(findKthElementFromLast(headNode, 3, index).data);
        */

        System.out.println(nthToLast(headNode,3).data);

    }
    static int findKthElementFromLast( Node headNode, int kthElement){
        if(headNode==null) return 0;
        int index =findKthElementFromLast( headNode.next, kthElement)+1;
        if(index==kthElement){
            System.out.println(headNode.data); // at this point if we return than means we are returning some
            // value to the earlier call, which will be incremented and return some other call
            // at the end data to final call will be wrong.
        }
        return index;
    }

    /**
     * best is to return a class , which has that counter. Modification to above meth is in this way
     * we will keep on returning nulll till the point we received the actual node. once that been assigned it will keep
     * on returning the desired node.
     */
    static Node findKthElementFromLast( Node headNode, int kthElement, Index index){
        if(headNode==null) return null;

        Node node =findKthElementFromLast( headNode.next, kthElement, index);
        index.idx=index.idx+1;
        if(index.idx==kthElement){
            return headNode;
        }
        return node;
    }

    /**
     * so far the best way. simply wow. first node points to head , second node head +k, which k ks node from the last.
     * lets say 3rd node from last. make two pointers , first is at start and second is start +k ,
     * when second will reach last first will reach kth from last. desired one... make last to point head and first one is the head.
     * will be behind 3 nodes, which is we are searching.
     * @param head
     * @param k
     * @return
     */
    static Node nthToLast( Node head, int k) {
        Node p1 =head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
            if ( p1 == null)
                return null;
            p1 = p1. next;
        }
        while (p1 != null) {
            p1 =p1. next;
            p2 = p2.next;
        }
        return p2;
    }

    static Node addNode(Integer data){
        if(headNode==null){
            headNode= new KthElementFromLast.Node(data, null);
            currentNode= headNode;
        }else {
            currentNode.next= new Node(data, null);
            currentNode= currentNode.next;
        }
        return currentNode;
    }
}
