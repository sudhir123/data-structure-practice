package com.prac.home.datastructures.trees;
/**
 * Binary Search Tree With Minimum Height. (increasing order) array with unique integer elements.
 * Minimum length of the tree is when its completely balanced.
 */
public class BinarySearchTreeWithMinimumHeight {
    class Node{
        int data;
        Node right, left;
        Node(int data){ this.data=data;}
    }
    int[] a= {1,2,3,4,5,6,7,8,9} ; // lets say off numbers

    Node createMinimumLength(int[] a,Node root, int i, int n){
        if(i<=n) {
            Node node = new Node(a[i]);
            System.out.println(a[i]);
            root = node;
            root.left = createMinimumLength(a, root.left, (2*i)+1, n);
            root.right = createMinimumLength(a, root.right, (2*i)+2, n);
        }
        return root;
    }
    Node createMinimalBST(int arr[] , int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        //System.out.println(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n. right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
    public static void main(String[] args) {
        BinarySearchTreeWithMinimumHeight b= new BinarySearchTreeWithMinimumHeight();
        //first way -> start of the array with 0th element and evey next 2m+1, and 2n+2 where at first iteration is 0 , are left and right
        //b.createMinimumLength(b.a, null, 0, b.a.length-1);

        // second way is to create minimum length is mid and left half and then right half. this  way we will reach to left first.

        b.createMinimalBST(b.a, 0, b.a.length-1 );
    }
}
