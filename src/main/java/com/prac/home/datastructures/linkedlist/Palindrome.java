package com.prac.home.datastructures.linkedlist;

import lombok.AllArgsConstructor;

import java.util.Stack;

public class Palindrome {


    static class PartialNode{
        int data;
        Node head, tail;
    }

    // meth 1 reverse and compare
    /*static PartialNode revers(Node head){
        if(head==null){
            return new PartialNode();
        }
        PartialNode partialNode = revers(head.next);
        if(partialNode.head==null){
            partialNode.head = new Node(head.data);
            partialNode.tail=partialNode.head;
        }else{
            partialNode.tail.next= new Node(head.data);
            partialNode.tail= partialNode.tail.next;
        }
        return partialNode;
    }*/

    static Boolean compare(Node n1, Node n2){
        while (n1!=null && n2!=null){
            if(n1.data!=n2.data){
                return false;
            }
            n1=n1.next; n2=n2.next;
        }
        return true;
    }

    // meth1 by book
    static Node reverseAndClone(Node node) {
        Node head=null;
        while (node!=null){
            Node temp = new Node(node.data);
            temp.next=head;
            head=temp;
            node=node.next;
        }
        return head;
    }

    /**
     * meth 2 by book. Logic 1/2 of the list is copy of another 1/2. we will push 1/2 data to stack and for another 1/2 pop
     * and match
     */
    /*static boolean isPalindromeByStack(Node head){
        Stack stack= new Stack();
        Node slow= head, fast=head;
        while (fast!=null && fast.next !=null){
            stack.push(slow.data);
            slow=slow.next;
            fast= fast.next.next;
        }
        if(fast!=null && fast.next==null){
            stack.push(slow.data);
        }
        while (!stack.isEmpty()){
            if(slow.data!=(int)stack.pop()){
                return false;
            }
            slow= slow.next;
        }
        return true;
    }*/

    /**
     * meth 3 Recursive approach my thinking to have two pointers one at head another leads to end and then compare.
     * actually we will create class and in recursive we return node and length -> length -2 ... to tarack middle point
     */
    @AllArgsConstructor
    static class Result{
        Node head;boolean val;
    }

    static Result isPalindromeByRecursive(Node head, int length){
        if(head==null && length<=0){ //even
            return new Result(head,true);
        }else if(length==1){ //odd
            return new Result(head.next,true);
        }

        Result result= isPalindromeByRecursive(head.next, length-2);
        if (!result.val || result.head == null) {
            return result;
        }
        result.val= (head.data==result.head.data);
        result.head= result.head.next;

        return result;
    }

    static int lengthOfList(Node n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }
    static boolean isPalindrome(Node head) {
         int length = lengthOfList(head);
         Result p = isPalindromeByRecursive(head, length);
         return p.val;
    }
    static class Node{
        int data=0;
        Node next;
        Node(int data){ this.data=data;};
    }
    public static void main(String[] args) {
        Node head= new Node(1);
        head.next= new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next= new Node(5);
        //head.next.next.next.next.next= new Node(1);

        //PartialNode partialNode =revers(head);
        //Node head2= reverseAndClone(head);
       //System.out.println(compare(head, head2));
       // System.out.println(isPalindromeByStack(head));
        //print(partialNode.head);
        System.out.println(lengthOfList(head));
        System.out.println(isPalindrome(head));
    }

    static void print(Node head){
        while(head.next!=null){
            System.out.println(head.data);
            head=head.next;
        }
        System.out.println(head.data);
    }
}
