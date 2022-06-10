package com.prac.home.datastructures.linkedlist;

import lombok.Data;

import java.util.Stack;

/**
 * 1->2->3->4->5
 * 1->5->2->4->3
 */
public class ReversingLinkedListUsingRecurssive {

    /**
     * counter on list in recursive
     * @param headNode
     * @param i
     * @return
     */
    static Integer reverseLinkedList(Node headNode , int i) {
        if (headNode == null) return 0;
        else{
            i= reverseLinkedList(headNode.next,i)+1;
        }
        if(i%2!=0)
            System.out.println(headNode.data);
        return headNode.data;
    }

    static Node mergeTwoListInFormat(Node headNode, Node reverseHeadNode){
        Node temp =null, currentNode=null;
        while (headNode.data!=reverseHeadNode.data){
            if(temp==null){
                temp= newNode(headNode.data);
                currentNode=temp;
                currentNode.next=newNode(reverseHeadNode.data);
                currentNode= currentNode.next;
            }else {
                currentNode.next=newNode(headNode.data);
                currentNode=currentNode.next;
                currentNode.next=newNode(reverseHeadNode.data);
                currentNode= currentNode.next;
            }

            headNode= headNode.next;
            reverseHeadNode= reverseHeadNode.next;
        }
        currentNode.next=newNode(headNode.data);
        return temp;
    }

    /**
     * add list to another list in reverse order
     * @param headNode
     * @return
     */
    static Node reverseLinkedList(Node headNode ) {
        Node temp =headNode;
        Stack st = new Stack();
        while (temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }
        temp=null; Node currentNode =null;
        while (!st.isEmpty() ){
            if(currentNode==null){
                temp = newNode((Integer) st.pop());
                currentNode=temp;
            }else {
                currentNode.next = newNode((Integer) st.pop());
                currentNode= currentNode.next;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        Node head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);
        head.next.next.next.next.next = newNode(6);
        head.next.next.next.next.next.next = newNode(7);

        Node reverseListHeadNode = reverseLinkedList(head);
        //printNode(head);

        Node desireList=mergeTwoListInFormat(head, reverseListHeadNode);
        printNode(desireList);
    }

    @Data
    static class Node{
        Integer data; Node next;
    }
    static Node newNode(int data)
    {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }
    static void printNode(Node headNode){
        Node tempNode = headNode;
        while(tempNode.next!=null){
            System.out.println(tempNode.data);
            tempNode= tempNode.next;
        }
        System.out.println(tempNode.data);
    }
}
