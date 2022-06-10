package com.prac.home.geeks4geeks;

public class AmazonExamLinkedListOperations {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head= new Node(33);
            head.next= new Node(84);
            head.next.next= new Node(96);
            head.next.next.next= new Node(41);
            head.next.next.next.next= new Node(67);
            //head.next.next.next.next.next= new Node(60);
            //head.next.next.next.next.next.next= new Node(45);
        AmazonExamLinkedListOperations m = new AmazonExamLinkedListOperations();
         Node current = m.rotate(head,2);
         while (current!=null){
             System.out.println(current.data);
             current= current.next;
         }
        //System.out.println(m.getMiddle(head));
    }
    public int getMiddle(Node head) {
        Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public Node deleteMiddle(Node head){
        Node slow=head, fast=head;
        Node prev=null;
        while(fast!=null && fast.next!=null){
            prev= slow;
            slow= slow.next;
            fast = fast.next.next;
        }
        prev.next= slow.next;
        return slow;
    }

    Node sortedInsert(Node head1, int key) {
        Node prev=null;
        Node current = head1;
        while (current!=null && current.data<= key){
            prev= current;
            current= current.next;
        }
        if (prev==null){
            Node newNode = new Node(key);
            newNode.next=current;
            head1= newNode;
        }else {
            prev.next = new Node(key);
            prev = prev.next;
            prev.next = current;
        }
        return head1;
    }
    public Node reverseList(Node head){
        Node p1=head, p2=head.next, p3=null;
        while (p2!=null){
            p3= p2.next;
            p2.next= p1;
            p1=p2;
            p2=p3;
        }
        head=p2!=null?p2:p1;
        return head;
    }

    public Node rotate(Node head, int k) {
        Node current =head;
        int totalNodes=1;
        while (current.next!=null){
            current=current.next;
            totalNodes++;
        }
        current.next= head;

        int offset = Math.abs(k)%totalNodes;
        if (offset==0) return head;
        int count= k>0? totalNodes-offset : offset;
        Node prev=null;
        while (count!=0){
            prev= head;
            head= head.next;
            count--;
        }
        prev.next=null;
        return head;
    }
}
