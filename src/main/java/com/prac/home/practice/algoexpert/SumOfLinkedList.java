package com.prac.home.practice.algoexpert;

public class SumOfLinkedList {
    public static void main(String[] args) {
        LinkedList one = new LinkedList(2);
        /*one.next= new LinkedList(4);
        one.next.next= new LinkedList(7);
        one.next.next.next= new LinkedList(1);*/

        LinkedList two = new LinkedList(9);
        /*two.next= new LinkedList(4);
        two.next.next= new LinkedList(5);*/
        SumOfLinkedList s = new SumOfLinkedList();
        System.out.println(s.sumOfLinkedLists(one, two).value);
    }
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList result= null; LinkedList resultHead=null;
        int carryFwd=0;
        while (linkedListOne!=null && linkedListTwo!=null){
            int sum = linkedListOne.value+ linkedListTwo.value+carryFwd;
            carryFwd= sum>10?1:0;
            int res = carryFwd==0? sum:sum-10;
            if (resultHead==null){
                resultHead= new LinkedList(res);
                result= resultHead;
            }else {
                result.next= new LinkedList(res);
                result= result.next;
            }
            linkedListOne= linkedListOne.next;
            linkedListTwo= linkedListTwo.next;
        }
        while (linkedListOne!=null){
            int sum = linkedListOne.value+carryFwd;
            carryFwd= sum>10?1:0;
            int res = carryFwd==0? sum:sum-10;
            result.next= new LinkedList(res);
            result= result.next;
            linkedListOne= linkedListOne.next;
        }
        while (linkedListTwo!=null){
            int sum = linkedListTwo.value+carryFwd;
            carryFwd= sum>10?1:0;
            int res = carryFwd==0? sum:sum-10;
            result.next= new LinkedList(res);
            result= result.next;
            linkedListTwo= linkedListTwo.next;
        }
        if (carryFwd>0){
            result.next= new LinkedList(carryFwd);
        }
        return resultHead;
    }
}

























