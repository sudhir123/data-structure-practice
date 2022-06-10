package com.prac.home.geeks4geeks;

public class MergeTwoSrtedLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    public static void main(String[] args) {
        Node h1= new Node(2);
        h1.next= new Node(9);
        h1.next.next= new Node(10);
        h1.next.next.next= new Node(15);
        h1.next.next.next.next= new Node(16);
        h1.next.next.next.next.next= new Node(17);
        h1.next.next.next.next.next.next= new Node(18);

        Node h2= new Node(2);
        h2.next= new Node(3);
        h2.next.next= new Node(8);
        h2.next.next.next= new Node(11);


        MergeTwoSrtedLinkedList m = new MergeTwoSrtedLinkedList();
        Node curr= m.sortedMerge(h1, h2);
        while (curr!=null){
            System.out.print(curr.data+"->");
            curr= curr.next;
        }
    }
    Node sortedMerge(Node head1, Node head2) {
        Node curr1= head1;
        Node curr2 = head2;
        Node prev=null;
        Node head3=null;
        while (curr1 !=null && curr2!=null){
            if (curr1.data<= curr2.data){
                if (head3==null){
                    head3= curr1;
                }
                while (curr1!=null && curr1.data <= curr2.data){
                    prev=curr1;
                    curr1= curr1.next;
                }
                prev.next= curr2;
            }else {
                if (head3==null){
                    head3= curr2;
                }
                while (curr2!=null && curr2.data <= curr1.data){
                    prev=curr2;
                    curr2= curr2.next;
                }
                prev.next= curr1;
            }
        }

        while (curr1 !=null){
            prev=curr1;
            curr1= curr1.next;
        }
        while (curr2 !=null){
            prev=curr2;
            curr2= curr2.next;
        }
        if (head1!=null && head2!=null){
            head3= head1.data<=head2.data?head1:head2;
        }else {
            if (head1!=null){
                head3= head1;
            }else {
                head3= head2;
            }
        }
        return head3;
    }
}
