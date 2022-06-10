package com.prac.home.practice.algoexpert;

public class MergedLinkedList {
    public static void main(String[] args) {
        LinkedList one = new LinkedList(2);
        one.next = new LinkedList(6);
        one.next.next = new LinkedList(7);
        one.next.next.next = new LinkedList(8);

        LinkedList two = new LinkedList(1);
        two.next = new LinkedList(3);
        two.next.next = new LinkedList(4);
        two.next.next.next = new LinkedList(5);
        two.next.next.next.next = new LinkedList(9);
        two.next.next.next.next.next = new LinkedList(10);

        LinkedList result = mergeLinkedLists(one, two);
        System.out.println(result.value);
    }
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        if (headOne==null && headTwo==null){
            return null;
        }
        LinkedList currentOne =headOne, currentTwo= headTwo;
        LinkedList prev =null;
        while (currentOne!=null && currentTwo!=null){

            if (currentOne.value<= currentTwo.value) {

                while (currentOne!=null && currentOne.value <= currentTwo.value) {
                    prev = currentOne;
                    currentOne = currentOne.next;
                }
                prev.next= currentTwo;
                prev= prev.next;
            }else {
                while (currentTwo!=null && currentTwo.value < currentOne.value){
                    prev = currentTwo;
                    currentTwo = currentTwo.next;
                }
                prev.next= currentOne;
                prev= prev.next;
            }
        }
        return headOne.value<= headTwo.value?headOne:headTwo;
    }
}
