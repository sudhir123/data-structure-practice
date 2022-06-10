package com.prac.home.geeks4geeks;

public class RearrangeLinkedList {
    // in cocept for zeros one and two. we will be having odd and even
    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node h= new Node(0);
        h.next= new Node(1);
        h.next.next= new Node(1);
        h.next.next.next= new Node(0);

        RearrangeLinkedList r = new RearrangeLinkedList();
        r.rearrangeEvenOdd(h);
        while (h!=null){
            System.out.println(h.data);
            h= h.next;
        }
    }
    /*void rearrangeEvenOdd(Node head)
    {
        Node odd = new Node(0);
        Node even = new Node(0);
        Node oddHead= odd;
        Node evenHead= even;
        Node current = head;
        while (current!=null){
            if (current.data%2==0){
                even.next= new Node(current.data);
                even= even.next;
            }else {
                odd.next= new Node(current.data);
                odd= odd.next;
            }
            current= current.next;
        }
        oddHead= oddHead.next;
        evenHead= evenHead.next;
        odd.next= evenHead;
        //head= oddHead;
        while (oddHead!=null){
            head.data= oddHead.data;
            oddHead= oddHead.next;
            head= head.next;
        }
    }*/
    void rearrangeEvenOdd(Node head)
    {
        Node temp = head;
        Node res = new Node(0);
        Node ans = res;
        int count = 1;
        while(temp != null)
        {
            if(count%2 != 0)
            {
                res.next = new Node(temp.data);
                res = res.next;
            }
            count++;
            temp = temp.next;
        }
        Node temp1 = head;
        int count1 = 1;
        while(temp1 != null)
        {
            if(count1%2 == 0)
            {
                res.next = new Node(temp1.data);
                res = res.next;
            }
            count1++;
            temp1 = temp1.next;
        }
        Node tempNode = ans.next;
        while(tempNode != null)
        {
            head.data = tempNode.data;
            head = head.next;
            tempNode = tempNode.next;
        }
    }

}
