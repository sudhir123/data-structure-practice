package com.prac.home.datastructures.linkedlist;

/**
 * two pointer fast and ... they will collide
 */
public class LoopDetection {
    static class Node{
        int data=0;        Node next;        Node(int data){ this.data=data;};
    }
    static void print(Node head){
        while(head.next!=null){
            System.out.println(head.data);            head=head.next;
        }
        System.out.println(head.data);
    }

    // meeting point
    static Node meetingPointDetection(Node headNode){
        Node slow=headNode,fast =headNode;
        while (fast!=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return slow;
        }
        return null;
    }

    // finding looping point in list

    static Node LoopPointDetection(Node headNode){
        Node slow=headNode,fast =headNode;
        while (fast!=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)  {slow=headNode; break;}
        }
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head1= new Node(1);
        head1.next= new Node(2);
        head1.next.next= new Node(3);
        Node nod4= head1.next.next.next= new Node(4);
        head1.next.next.next.next= new Node(5);
        head1.next.next.next.next.next= new Node(6);
        head1.next.next.next.next.next.next= new Node(7);
        head1.next.next.next.next.next.next.next= new Node(8);
        head1.next.next.next.next.next.next.next.next= new Node(9);
        head1.next.next.next.next.next.next.next.next.next= nod4;

        System.out.println(meetingPointDetection(head1).data);
        System.out.println(LoopPointDetection(head1).data);
    }
}
