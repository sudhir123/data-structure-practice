package com.prac.home.algoexpert.medium;
/**
 * doubly linked list needs to be created. No new node need to be created assume you have that node either in linkedlist or have some extra
 * random nodes. which needs to be inserted.
 */
public class LinkedListConstruction {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (head==null){
                head= node;
                tail=node;
            }else {
                insertBefore(head, node);
            }
        }

        public void setTail(Node node) {
            if (tail==null){
                setHead(node);
                return;
            }
            insertAfter(tail, node);
        }

        // move existing from list
        public void insertBefore(Node node, Node nodeToInsert) {
            if (nodeToInsert==head && nodeToInsert==tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev= node.prev;
            nodeToInsert.next= node;
            if (node.prev==null){
                head= nodeToInsert;
            }else {
                node.prev.next= nodeToInsert; // old node has some prev , that prev's next is supposed to point to nodeToInsert
            }
            node.prev= nodeToInsert;
        }

        // insert stand alone node
        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert==head && nodeToInsert==tail) return;
            remove(nodeToInsert);
            nodeToInsert.next= node.next;
            nodeToInsert.prev= node;
            if (node.next==null){
                tail= nodeToInsert;
            }else {
                node.next.prev= nodeToInsert;
            }
            node.next= nodeToInsert;
        }

        // position counted from 1.
        public void insertAtPosition(int position, Node nodeToInsert) {
            int i = 1;
            if (position==1){
                setHead(nodeToInsert);
                return;
            }
            Node current = head;
            while (i != position) {
                current = current.next;
                i++;
            }
            if (current!=null){
                insertBefore(current,nodeToInsert);
            }else {
                setTail(nodeToInsert);
            }
        }

        // remove all nodes
        public void removeNodesWithValue(int value) {
            Node current = head;
            while (current != null) {
                Node next = current.next;
                if (current.value == value) {
                    remove(current);
                }
                current=next;
            }
        }

        // remove only single node
        public void remove(Node node) {
            if (node==head){
                head= head.next;
            }
            if (node==tail){
                tail= tail.prev;
            }
            removeWithBindings(node);
        }

        public void removeWithBindings(Node node){
            if (node.prev!=null){
                node.prev.next= node.next;
            }
            if (node.next!=null){
                node.next.prev= node.prev;
            }
            node.prev=null;
            node.next=null;
        }

        public boolean containsNodeWithValue(int value) {
            Node current = head;
            while (current != null) {
                if (current.value == value) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        void print(Node head) {
            Node current = head;
            System.out.println();
            System.out.println();
            while (current != null) {
                System.out.print(current.value + "-->");
                current = current.next;
            }
        }

        // Do not edit the class below.
        static class Node {
            public int value;
            public Node prev;
            public Node next;

            public Node(int value) {
                this.value = value;
                this.prev=null;
                this.next=null;
            }
        }


        public static void main(String[] args) {
            Node head = new Node(1);
            head.next = new Node(2);
            head.next.prev = head;
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
            doublyLinkedList.head = head;

            Node t = new Node(2);
            doublyLinkedList.setHead(t);
            doublyLinkedList.print(doublyLinkedList.head);
        }
    }

}