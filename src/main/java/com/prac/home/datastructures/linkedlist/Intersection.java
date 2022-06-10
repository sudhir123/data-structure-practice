package com.prac.home.datastructures.linkedlist;

/**
 * This algorithm takes O(A + B) time, where A and B are the lengths of the two linked lists. It takes O( 1)
 * additional space
 */
public class Intersection {
    static class Node{
        int data=0;        Node next;        Node(int data){ this.data=data;};
    }
    static void print(Node head){
        while(head.next!=null){
            System.out.println(head.data);            head=head.next;
        }
        System.out.println(head.data);
    }
    static class LinkedListProperties{
        int length;
        Node tail;
    }
    static LinkedListProperties lengthAndTail(Node head){
        LinkedListProperties lp = new LinkedListProperties();
        while (head.next!=null){
            lp.length++;
            head= head.next;
        }
        lp.length++; lp.tail=head;
        return lp;
    }
    static boolean compareTail(LinkedListProperties lp1, LinkedListProperties lp2){
        if (lp1.tail==lp2.tail){
            return true;
        }
        return false;
    }
    static Node findIntersection(Node head1, Node head2){
        LinkedListProperties l1= lengthAndTail(head1);
        LinkedListProperties l2= lengthAndTail(head2);

        if(l1.length>l2.length){
            int diff= l1.length-l2.length;
            while(diff-->0){
                head1= head1.next;

            }

            while (head1!=null){
                if(head1.next== head2.next){
                    return head1.next;
                }
                head1= head1.next; head2=head2.next;
            }
        }
        return null;
    }



    public static void main(String[] args) {
        Node head1= new Node(1);
        head1.next= new Node(2);
        head1.next.next= new Node(3);
        Node sameRefNode = new Node(7);
        head1.next.next.next= sameRefNode;
        sameRefNode.next= new Node(8);
        sameRefNode.next.next= new Node(9);
        sameRefNode.next.next.next= new Node(10);

        Node head2= new Node(4);
        head2.next= new Node(5);
        head2.next.next= sameRefNode;

        LinkedListProperties lp1= lengthAndTail(head1);
        LinkedListProperties lp2= lengthAndTail(head2);

        System.out.println(compareTail(lp1,lp2));
        print(findIntersection(head1, head2));

    }
}
