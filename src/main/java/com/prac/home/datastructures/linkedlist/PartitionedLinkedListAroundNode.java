package com.prac.home.datastructures.linkedlist;

/**
 * small elements are left but order needs to be mailtained
 */
public class PartitionedLinkedListAroundNode {

    /* Link list Node */
    static class Node
    {
        int data;
        Node next;
    }

    // A utility function to create a new node
    static Node newNode(int data)
    {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }

    // Function to make two separate lists and return head after concatenating
    static Node partition(Node head, int x) {
        Node beforeStart= null;
        Node beforeEnd= null;
        Node afterStart= null;
        Node afterEnd= null;

        while (head!=null){
            Node nextNode = head.next;
            head.next=null;
            if(head.data<x){
                if(beforeStart==null){
                    beforeStart= newNode(head.data);
                    beforeEnd=beforeStart;
                }else {
                    beforeEnd.next= newNode(head.data);
                    beforeEnd= beforeEnd.next;
                }
            }else {
                if(afterStart==null){
                    afterStart=newNode(head.data);;
                    afterEnd=afterStart;
                }else {
                    afterEnd.next=newNode(head.data);
                    afterEnd=afterEnd.next;
                }
            }
            head=nextNode;
        }

        /*while (node!=null){
            Node nextNode= node.next;
            node.next=null;
            if(node.data<x){
                if (beforeEnd==null){
                    beforeStart=node;
                    beforeEnd=beforeStart;
                }else {
                    beforeEnd.next= node;
                    beforeEnd= node;
                }
            }else {
                if(afterStart==null){
                    afterStart=node;
                    afterEnd=afterStart;
                }else {
                    afterEnd.next=node;
                    afterEnd= node;
                }
            }
            node=nextNode;
        }*/
        beforeEnd.next=afterStart;
        return beforeStart;
    }

    /* Function to print linked list */
    static void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = newNode(3);
        head.next = newNode(5);
        head.next.next = newNode(8);
        head.next.next.next = newNode(5);
        head.next.next.next.next = newNode(10);
        head.next.next.next.next.next = newNode(2);
        head.next.next.next.next.next.next = newNode(1);

        printList(head);
        System.out.println();
        int x = 5;
        head = partition(head, x);
        printList(head);

    }
}
