package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RightSmallerThan {
    public static void main(String[] args) {
        System.out.println(rightSmallerThan(Arrays.asList(8, 5, 11, -1, 3, 4, 2)));
    }

    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if (array.size()==0) return new ArrayList<>();
        //meth1(array, result);
        return meth2(array);
    }
    static List<Integer> meth2(List<Integer> array) {
        int lastIdx = array.size()-1;
        SpecialBST root = new SpecialBST(array.get(lastIdx), lastIdx,   0);
        for (int idx =lastIdx-1; idx>=0; idx--){
            root.insert(array.get(idx), idx);
        }
        List<Integer> result = new ArrayList<>(array);
        traverse(root, result);
        return result;
    }

    static void traverse(SpecialBST root, List<Integer> result){
        if (root==null) return;
        result.set(root.idx, root.numberSmallerAtTheTimeOfInsert);
        traverse(root.left, result);
        traverse(root.right, result);
    }
    static class SpecialBST{
        int data;
        int leftSubTreeSize;
        int numberSmallerAtTheTimeOfInsert;
        int idx;
        SpecialBST left, right;
        SpecialBST(int data, int idx, int numberSmallerAtTheTimeOfInsert){
            this.data= data;
            this.idx= idx;
            this.numberSmallerAtTheTimeOfInsert=numberSmallerAtTheTimeOfInsert;
            leftSubTreeSize=0;
        }

        void insert( int val, int idx){
            insertHelper(val, idx, 0);
        }
        void insertHelper(int val, int idx, int numberSmallerAtInsertTime){
            if (val < this.data){
                leftSubTreeSize++;
                if (left==null){
                    left= new SpecialBST(val, idx, numberSmallerAtInsertTime);
                }else {
                    left.insertHelper(val, idx, numberSmallerAtInsertTime);
                }
            }else {
                numberSmallerAtInsertTime+=leftSubTreeSize;
                if (val > this.data){
                    numberSmallerAtInsertTime++; // why because we have taken in consideration the size of left subtree of prarent
                    // now current Val is greater then parent so parent also needs to be added to small count
                }
                if (right==null){
                    right= new SpecialBST(val, idx, numberSmallerAtInsertTime);
                }else {
                    right.insertHelper(val,idx, numberSmallerAtInsertTime );
                }
            }
        }
    }
    // meth1 was running from left to right, which is 50% success.  meth2 trying right to left
    /*static List<Integer> meth1(List<Integer> array,List<Integer> result) {
        Node root = new Node(array.get(0),0, 0);
        for (int idx=1;idx< array.size(); idx++){
                insert(root,idx, array.get(idx));
        }
        traverse(root, result);
       // Collections.reverse(result);
        return result;
    }
    static void traverse(Node root, List<Integer> result){
        if (root==null) return;
        result.set(root.idx, root.leftSubTreeSize);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    static Node insert(Node root,int idx,  int val ){
        if (root==null){
            root= new Node(val,idx,0);
            return root;
        }

        if (root.data > val){
            root.leftSubTreeSize+=1;
            root.left= insert(root.left,idx,  val);
            incrementRight(root.right);
        }else {
            //root.count+=1;
            root.right= insert(root.right,idx, val);
        }
        return root;
    }

    static void incrementRight(Node root){
        if (root==null) return;
        root.leftSubTreeSize+=1;
    }*/

}
