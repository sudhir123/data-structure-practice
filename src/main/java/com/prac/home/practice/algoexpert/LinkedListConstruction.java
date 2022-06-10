package com.prac.home.practice.algoexpert;

public class LinkedListConstruction {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev= head.next;

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.setHead(head);
        doublyLinkedList.setHead(head.next.next);
        doublyLinkedList.print(doublyLinkedList.head);
        Node t = new Node(2);
        Node t1 = new Node(6);
        Node t2 = new Node(10);
        doublyLinkedList.insertBefore(head.next,t );
        doublyLinkedList.print(doublyLinkedList.head);
        doublyLinkedList.insertAfter(head.next,t1 );
        doublyLinkedList.print(doublyLinkedList.head);
        doublyLinkedList.setTail(t2);
        doublyLinkedList.print(doublyLinkedList.head);
    }
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        void print(Node head) {
            Node current = head;
            System.out.println();
            while (current != null) {
                System.out.print(current.value + "-->");
                current = current.next;
            }
        }

        public void setHead(Node node) {
            if (head==null){
                head= node;
                tail=node;
                return;
            }
            insertBefore(head, node);
        }

        public void setTail(Node node) {
            if (tail==null){
                setHead(node);
                return;
            }
            insertAfter(tail, node);
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (nodeToInsert==head || nodeToInsert==tail) return;
            remove(nodeToInsert);
            Node prev = node.prev;
            nodeToInsert.prev= prev;
            nodeToInsert.next= node;
            if (prev==null){
                head= nodeToInsert;
            }else {
                prev.next= nodeToInsert;
            }
            node.prev= nodeToInsert;

        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert==head || nodeToInsert==tail) return;
            Node next = node.next;
            node.next= nodeToInsert;
            nodeToInsert.prev= node;
            nodeToInsert.next= next;
            if (next!=null){
                next.prev= nodeToInsert;
            }
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position==1){
                setHead(nodeToInsert);
                return;
            }
            Node current = head;
            int  count=1;
            while (count!= position){
                current= current.next;
                count++;
            }
            if (current!=null){
                insertBefore(current, nodeToInsert);
            }else {
                setTail(nodeToInsert);
            }

        }

        public void removeNodesWithValue(int value) {
            Node current= head;
            while (current!=null) {
                while (current != null && current.value!=value) {
                    current= current.next;
                }
                if (current.value==value){
                    Node toBeRemoved= current;
                    current= current.prev;
                    remove(toBeRemoved);
                }
            }
        }

        public void remove(Node node) {
            if (node==head){
                head=head.next;
            }
            if (node==tail){
                tail= tail.prev;
            }
            removeWithBindings(node);
        }
        public void removeWithBindings(Node node) {
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
            while (current!=null ){
                if (current.value==value){
                    return true;
                }
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
