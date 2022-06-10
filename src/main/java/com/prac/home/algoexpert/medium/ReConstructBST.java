package com.prac.home.algoexpert.medium;

import java.util.ArrayList;

/**
 *  pre -order is root, left , right. given a non empty array representing pre-order. Write function that creates relevant BST.
 *  11-NOV-2021 Thursday
 */
public class ReConstructBST {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
    // worst way this will give O(n^2)
    /*public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        int i =0; BST root= null;
        while (i< preOrderTraversalValues.size()){
            root= insertBst(root , preOrderTraversalValues.get(i));
            i++;
        }
        return root;
    }

    BST insertBst(BST root, int value){
        if (root==null){
            root=new BST(value);
        }
        else if (root.value > value){
             root.left= insertBst(root.left,value);
        }else {
            root.right= insertBst(root.right,value);
        }
        return root;
    }*/

    // best way pick a value adjust it , while running to next value in recursive way, so that you will not come out
    // and redo code. this can only be done by setting upper bound and lower bound.
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        TreeInfo idxTracking = new TreeInfo(0);
        return reconstructBst(preOrderTraversalValues, idxTracking, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    static class TreeInfo{
        int runningIdx;
        public TreeInfo(int runningIdx) {
            this.runningIdx = runningIdx;
        }
        public int getRunningIdx() {
            return runningIdx;
        }
        public void setRunningIdx(int runningIdx) {
            this.runningIdx = runningIdx;
        }
    }

    BST reconstructBst(ArrayList<Integer> preOrderTraversalValues, TreeInfo idxTracking, Integer lowerVal, Integer upperVal){
        if (idxTracking.getRunningIdx()> preOrderTraversalValues.size()-1) {
            return null;
        }
        Integer rootVal = preOrderTraversalValues.get(idxTracking.getRunningIdx());
        if (rootVal < lowerVal || rootVal>= upperVal){
            return null;
        }
        BST root = new BST(rootVal);

        idxTracking.setRunningIdx(idxTracking.getRunningIdx()+1);
        root.left= reconstructBst(preOrderTraversalValues,idxTracking, lowerVal, rootVal );
        root.right= reconstructBst(preOrderTraversalValues,idxTracking, rootVal, upperVal );

        return root;
    }

    public static void main(String[] args) {
        ReConstructBST r = new ReConstructBST();
        int[] a= new int[]{2, 0, 1, 4, 3, 3};
        ArrayList<Integer> arrayList= new ArrayList<>();
        for (int i : a)
        {
            arrayList.add(i);
        }

        BST root = r.reconstructBst(arrayList);
        System.out.println(root.value);


    }
}
































