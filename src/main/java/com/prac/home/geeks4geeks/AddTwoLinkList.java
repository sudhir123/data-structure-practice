package com.prac.home.geeks4geeks;

public class AddTwoLinkList {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head1= new Node(7);
        head1.next= new Node(7);
        head1.next.next= new Node(0);
        head1.next.next.next= new Node(3);
        head1.next.next.next.next= new Node(2);
        Node head2= new Node(2);
        head2.next= new Node(9);
        head2.next.next= new Node(6);
        head2.next.next.next= new Node(6);
        head2.next.next.next.next= new Node(0);
        Node current = addTwoLists(head1, head2 );
        while (current!=null){
            System.out.println(current.data);
            current= current.next;
        }
    }
    static Node addTwoLists(Node first, Node second){
        Node resHead=new Node(0);
        Node result = resHead;
        first= reverse(first);
        second= reverse(second);
        int sum; int carryFwd=0;
        Node prevResult=null;
        while (first!=null && second!=null ){
            sum= first.data+second.data+carryFwd;
            carryFwd= sum/10;
            int q= sum%10;
            result.next= new Node(q);
            prevResult= result;
            result= result.next;
            first= first.next;
            second= second.next;
        }
        while (first!=null){
            sum= first.data+carryFwd;
            carryFwd= sum/10;
            int q= sum%10;
            result.next= new Node(q);
            prevResult= result;
            result= result.next;
            first= first.next;
        }
        while (second!=null){
            sum= second.data+carryFwd;
            carryFwd= sum/10;
            int q= sum%10;
            result.next= new Node(q);
            prevResult= result;
            result= result.next;
            second= second.next;
        }
        if (carryFwd==1){
            result.next= new Node(carryFwd);
        }
        Node next= resHead.next;
        resHead.next= null;
        resHead= next;
        return reverse(resHead);
    }
    static Node reverse(Node head){
        Node p1= head;
        Node prev =null;
        while (p1!=null){
            Node next = p1.next;
            p1.next= prev;
            prev= p1;
            p1= next;
        }
        return prev;
    }
}
