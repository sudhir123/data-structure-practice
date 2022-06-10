package com.prac.home.geeks4geeks;

public class SubtractLinkedList {

    static Node subTwoLists(Node l1, Node l2){
        Node first =null; Node second= null;
        Node headL1=l1; Node headL2= l2;
        int fistCount=0; int secCount=0;
        while (l1!=null){
            fistCount++;
            l1=l1.next;
        }
        while (l2!=null){
            secCount++;
            l2=l2.next;
        }
        if (fistCount>secCount){
            first=headL1;
            second=headL2;
        }else if (secCount> fistCount){
            first=headL2;
            second=headL1;
        }else {
            while (l1!=null && l2!=null){
                if (first.data>second.data){
                    first=headL1;
                    second=headL2;
                    break;
                }else if (first.data< second.data){
                    first=headL2;
                    second=headL1;
                    break;
                }
            }
        }
        // lets say first is larger and second is smaller.
        Node third=new Node(0);
        Node thirdhead= third;
        first= reverse(first);
        second= reverse(second);
        int sub=0;
        int borrow=0;
        while (first!=null && second!=null){
            if (borrow==1){
                first.data= first.data-1;
            }
            if (first.data>= second.data){
                sub = first.data- second.data;
                third.next= new Node(sub);
                borrow=0;
            }else {
                Integer newFirstData=0;
                borrow=1;
                newFirstData= 10+first.data;
                sub = newFirstData- second.data;
                third.next= new Node(sub);
            }
            third= third.next;
            first= first.next;
            second= second.next;
        }
        if (borrow==1){
            first.data= first.data-1;
        }
        while (first!=null){
            third.next= new Node(first.data);
            third= third.next;
            first= first.next;
        }

        thirdhead = thirdhead.next;
        thirdhead= reverse(thirdhead);
        while (thirdhead!=null && thirdhead.data==0){
            thirdhead= thirdhead.next;
        }
        return thirdhead;
    }

    static Node reverse(Node head){
        Node p1= head;
        Node prev=null;
        while (p1!=null){
            Node next = p1.next;
            p1.next= prev;
            prev= p1;
            p1=next;
        }
        return prev;
    }
    public static void main(String[] args) {
        Node h1= new Node(1);
        h1.next= new Node(0);
        h1.next.next= new Node(0);
        Node h2= new Node(1);
        h2.next= new Node(2);
        Node result = subTwoLists(h1, h2);
        while (result!=null){
            System.out.println(result.data);
            result= result.next;
        }
    }
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
