package com.prac.home.geeks4geeks;

public class SortZerosOnesTwos {
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    static Node segregate(Node head){
       Node zeroD=new Node(0);
       Node oneD= new Node(0);
       Node twoD= new Node(0);
       Node zero=zeroD;
       Node one= oneD;
       Node two= twoD;
       Node current = head;
       while (current!=null){
           if (current.data==0){
               zero.next=current;
               zero= zero.next;
               current= current.next;
           }else if (current.data==1){
               one.next=current;
               one= one.next;
               current= current.next;
           }else {
               two.next=current;
               two= two.next;
               current= current.next;
           }
       }
       if (oneD.next!=null){
           zero.next= oneD.next;
           one.next= twoD.next;
       }else {
           zero.next= twoD.next;
       }
       two.next=null;
       head=zeroD.next;
       return head;
    }

    public static Node addOne(Node head){
        head= reverse(head);
        Node current  = head;
        int carryFwd=0; int sum=0;
        Node prev =null;
        while (current!=null ){
            if (current==head){
                sum = current.data+1;
            }else {
                sum= current.data+carryFwd;
            }
            carryFwd= sum/10;
            int q= sum%10;
            current.data= q;
            prev= current;
            current= current.next;
        }
        if (carryFwd==1 ){
                prev.next = new Node(carryFwd);
        }
        head=reverse(head);
        return head;
    }

    public static Node reverse(Node head){
        Node p1=head;
        Node prev = null;

        while (p1!=null && p1.next!=null){
            Node next = p1.next;
            p1.next= prev;
            prev= p1;
            p1=next;

        }
        if (p1==null){
            p1= prev;
        }else {
            p1.next= prev;
        }
        head= p1;
        return head;
    }

    public static void main(String[] args) {
        Node head= new Node(9);
        head.next= new Node(9);
        head.next.next= new Node(9);
        head.next.next.next= new Node(9);
        Node current= addOne(head);
        while (current!=null){
            System.out.print(current.data+"->");
            current= current.next;
        }
    }
}
