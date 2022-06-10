package com.prac.home.datastructures.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

/**
 * You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .Thatis,617 + 295.
 * Output: 2 - > 1 - > 9. That is, 912.
 */
public class SumLinkedList {


    /**
     * best way to do it recursive
     */
    static Node sumOfNodesInReverse(Node n1Head, Node n2Head, int carry){
        if(n1Head==null && n2Head==null && carry==0) return null;


        int sum = n1Head.data+ n2Head.data+carry;
        int nextNodeData= sum%10;
        carry= sum>9?1:0;
        Node temp = new Node(nextNodeData, null);
        if(n1Head!=null && n2Head!=null){
            Node more = sumOfNodesInReverse(n1Head.next, n2Head.next, carry);
            temp.next=more;
        }
        return temp;
    }

    /**
     * another version. Lets say digits are not in reverse order and carry out sum in normal order
     * eg - 1-> 2-> 3  +  3->5->7 =   4-> 8-> 0
     * logic will be earlier we carry out sum and pass carry to next calculation and put the node in tail.
     * in this logic we put node at head.
     */

    static class Partial{
        Node node=null;
        int carry=0;
    }

    static  Node addLists(Node n1Head, Node n2Head){
        Partial partial= sumOfNodesInForwardOrder(n1Head,n2Head);
        if(partial.carry==0){
            return partial.node;
        }else {
            return insertBefore(partial.node,partial.carry);
        }
    }

    static Partial sumOfNodesInForwardOrder(Node n1Head, Node n2Head){

        if(n1Head==null && n2Head==null ) {
            return new Partial();
        }
        Partial partial= sumOfNodesInForwardOrder(n1Head.next,n2Head.next);

        int val = n1Head.data+ n2Head.data + partial.carry;

        Node fullResult = insertBefore(partial.node, val % 10);

        partial.node=fullResult;
        partial.carry= val>=10?1:0;

        return partial;
    }

    static Node insertBefore(Node node, int data){
        Node node1= new Node(data,null);
        if(node!=null){
            node1.next=node;
        }
        return node;
    }
    /*static Node sumOfNodes(Node n1Head, Node n2Head){
        int carry=0; Node tempNode=null;
        while(n1Head!=null && n2Head!=null){

            int sum = n1Head.data + n2Head.data + carry;
            int nodeData = sum%10;
            carry= (sum>9 && nodeData!=0) ?1:0;

            if(head3==null){
                head3= new Node(nodeData,null);
                tempNode=head3;
            }else {
                tempNode.next= new Node(nodeData,null);
                tempNode= tempNode.next;
            }
            n1Head=n1Head.next;
            n2Head= n2Head.next;
        }
        // if any mode n1 nodes or n2 nodes are pending then traverse those
        return head3;
    }*/

    /*
    there is a better way like we do in actual sum
    static CreateLinkedList.Node numberInReverseOrder(int num1, int num2){

    }
    static int sumOfNodesInReverse(Node head){
        int i=1, sum=0;
        while (head!=null){
            sum=sum+(head.data*i);
            i= i *10;
            head=  head.next;
        }
        return sum;
    }*/

    public static void main(String[] args) {
        /*
        addNode(2);
        addNode(1);
        addNode(6);
        printNode(headNode);
        System.out.println(sumOfNodesInReverse(headNode));*/

        // 912 is the number you will give to meth and will return you head node with 2-> 1-> 9
        headNode= new Node(7,null);
        headNode.next= new Node(1,null);
        headNode.next.next= new Node(4,null);

        head2= new Node(5,null);
        head2.next= new Node(9,null);
        head2.next.next= new Node(5,null);

        //printNode( sumOfNodesInReverse(headNode, head2,0));
        printNode(addLists(headNode,head2));

    }

    @Data
    @AllArgsConstructor
    static class Node{
        Integer data; Node next;
    }
    static Node currentNode, headNode,head2, head3;

    static Node addNode(Integer data){
        if(headNode==null){
            headNode= new Node(data, null);
            currentNode= headNode;
        }else {
            currentNode.next= new Node(data, null);
            currentNode= currentNode.next;
        }
        return currentNode;
    }
    static void printNode(Node headNode){
        Node tempNode = headNode;
        while(tempNode.next!=null){
            System.out.println(tempNode.data);
            tempNode= tempNode.next;
        }
        System.out.println(tempNode.data);
    }
}
