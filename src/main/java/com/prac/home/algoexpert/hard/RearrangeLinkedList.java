package com.prac.home.algoexpert.hard;

public class RearrangeLinkedList {
    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        LinkedList start=null, startHead= null, equal=null, equalHead=null, end=null, endHead=null;

        LinkedList current = head;
        while (current!=null){
            if (current.value< k){
                if (start==null){
                    start= new LinkedList(current.value);
                    startHead= start;
                }else {
                    start.next= new LinkedList(current.value);
                    start= start.next;
                }
            }

            else if (current.value== k){
                if (equal==null){
                    equal= new LinkedList(current.value);
                    equalHead= equal;
                }else {
                    equal.next= new LinkedList(current.value);
                    equal= equal.next;
                }
            }

            else if (current.value> k){
                if (end==null){
                    end= new LinkedList(current.value);
                    endHead= end;
                }else {
                    end.next= new LinkedList(current.value);
                    end= end.next;
                }
            }

            current= current.next;
        }

        if (startHead!=null){
            start.next= equalHead;
        }
        if (equalHead!=null){
            equal.next= endHead;
        }else {
            if (startHead!=null){
                start.next= endHead;
            }
        }
        if (startHead!=null){
            return startHead;
        }else if (equalHead!=null){
            return equalHead;
        }else {
            return endHead;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(6);
        head.next= new LinkedList(0);
        head.next.next= new LinkedList(5);
        head.next.next.next= new LinkedList(2);
        head.next.next.next.next= new LinkedList(1);
        head.next.next.next.next.next= new LinkedList(4);

        LinkedList c= rearrangeLinkedList(head, 3);
        while (c!=null){
            System.out.println(c.value);
            c= c.next;
        }
    }
    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
