package com.prac.home.algoexpert.medium;
/**
 * sum two linked list like normal number. Two lists can be of differnt length. 0th digit in sum is head node for the list
 */
public class SumOfLinkList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        int remainderFromLastSum= 0; LinkedList head=null; LinkedList current=null; int sum=0;
        while (linkedListOne!=null && linkedListTwo!=null){
            sum = remainderFromLastSum+ linkedListOne.value+ linkedListTwo.value;

            if (head==null){
                head= new LinkedList(sum%10);
                current=head;
            }else {
                current.next= new LinkedList(sum%10);
                current= current.next;
            }
            remainderFromLastSum= sum/10;
            linkedListOne= linkedListOne.next;
            linkedListTwo= linkedListTwo.next;
        }
        while (linkedListOne!=null){
            sum= remainderFromLastSum+ linkedListOne.value;
            current.next= new LinkedList(sum%10);
            remainderFromLastSum= sum/10;
            linkedListOne= linkedListOne.next;
            current= current.next;
        }
        while (linkedListTwo!=null){
            sum= remainderFromLastSum+ linkedListTwo.value;
            current.next= new LinkedList(sum%10);
            remainderFromLastSum= sum/10;
            linkedListOne= linkedListOne.next;
            current= current.next;
        }
        if (remainderFromLastSum!=0){
            current.next= new LinkedList(remainderFromLastSum);
        }
        return head;
    }

    static void print(LinkedList head) {
        LinkedList current = head;
        System.out.println();
        System.out.println();
        while (current != null) {
            System.out.print(current.value + "-->");
            current = current.next;
        }
    }

    public static void main(String[] args) {

        LinkedList h1 = new LinkedList(2);
        h1.next= new LinkedList(4);
        h1.next.next= new LinkedList(7);
        h1.next.next.next= new LinkedList(1);

        LinkedList h2 = new LinkedList(9);
        h2.next= new LinkedList(4);
        h2.next.next= new LinkedList(5);

        print(sumOfLinkedLists(h1, h2));
    }
}





























