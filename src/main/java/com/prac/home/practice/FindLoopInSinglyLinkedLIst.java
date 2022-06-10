package com.prac.home.practice;

public class FindLoopInSinglyLinkedLIst {
    public static void main(String[] args) {

    }
    public static LinkedList findLoop(LinkedList head) {
        LinkedList firstPointer = head;
        LinkedList secondPointer = head;

        while (true){
            firstPointer= firstPointer.next;
            secondPointer= secondPointer.next.next;
            if (firstPointer==secondPointer){
                break;
            }
        }
        firstPointer=head;
        while (firstPointer!=secondPointer){
            firstPointer=firstPointer.next;
            secondPointer=secondPointer.next;
        }
        return firstPointer;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
