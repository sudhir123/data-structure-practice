package com.prac.home.algoexpert.easy;
/**
 * Remove duplicates. Modify the same list. All are in sorted order
 */
public class RemoveDuplicateFromLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList head = linkedList;
        LinkedList temp = linkedList.next;
        while (linkedList!=null && temp!=null){
            while (temp!=null&& (linkedList.value== temp.value)){
                temp=temp.next;
            }
            linkedList.next= temp;
            linkedList= linkedList.next;
        }
        return head;
    }

    void print(LinkedList head){
        while (head!=null){
            System.out.print(head.value+"->");
            head= head.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        RemoveDuplicateFromLinkedList r = new RemoveDuplicateFromLinkedList();
        LinkedList head = new LinkedList(1);
        head.next= new LinkedList(1);
        head.next.next= new LinkedList(3);
        head.next.next.next= new LinkedList(4);
        head.next.next.next.next= new LinkedList(4);
        head.next.next.next.next.next= new LinkedList(4);
        head.next.next.next.next.next.next= new LinkedList(5);
        head.next.next.next.next.next.next.next= new LinkedList(6);

        r.print(r.removeDuplicatesFromLinkedList(head));
    }
}
