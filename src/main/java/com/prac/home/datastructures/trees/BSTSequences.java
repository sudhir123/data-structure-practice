package com.prac.home.datastructures.trees;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A binary search tree was created by traversing through an array from left to right and inserting each element. Given a binary search
 * tree with distinct elements, print all possible arrays that could have led to this tree.
 */
public class BSTSequences {
    @Getter
    @Setter
    static class TreeNode{
        int data;
        TreeNode  right , left;
        TreeNode(int data){this.data=data;}
    }
    TreeNode root;

    public static void main(String[] args) {
        BSTSequences s =new BSTSequences();
        s.root= new TreeNode(50);
        s.root.left= new TreeNode(20);
        s.root.right= new TreeNode(60);
        s.root.left.left= new TreeNode(10);
        s.root.left.left.left= new TreeNode(5);
        s.root.left.left.right= new TreeNode(15);
        s.root.left.right= new TreeNode(25);
        s.root.right.right= new TreeNode(70);
        s.root.right.right.left= new TreeNode(65);
        s.root.right.right.right= new TreeNode(80);

        List<LinkedList<Integer>> lists= s.allSequences(s.root);
        System.out.println(lists.size());
    }

    List<LinkedList<Integer>> allSequences(TreeNode root){
        List<LinkedList<Integer>>results= new ArrayList<>();
        if (root==null){
            LinkedList<Integer> list = new LinkedList<>();
            results.add(list);
            return results;
        }
        LinkedList<Integer> rootPrefix=new LinkedList<>();
        rootPrefix.add(root.data);

        List<LinkedList<Integer>> leftSeq = allSequences(root.left);
        List<LinkedList<Integer>> rightSeq= allSequences(root.right);

        if (leftSeq.size()!=0 && rightSeq.size()!=0){
            for (LinkedList<Integer> left : leftSeq){
                for (LinkedList<Integer> right: rightSeq) {
                    List<LinkedList<Integer>>weaveListOfLinkedLists= new ArrayList<>();
                    weaveLists(left, right,  weaveListOfLinkedLists, rootPrefix);
                    results.addAll(weaveListOfLinkedLists);
                }
            }
        }
        return results;
    }
    void weaveLists(LinkedList<Integer> left ,
               LinkedList<Integer> right ,
               List<LinkedList<Integer>>results,
               LinkedList<Integer> prefix ){

        if (left.size()==0 || right.size()==0 ){
            LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
            result.addAll(left);
            result.addAll(right);
            results.add(result);
            return;
        }
        int head= left.removeFirst();
        prefix.addLast(head);
        weaveLists(left,right, results,prefix );
        prefix.removeLast();
        left.addFirst(head);

        int head2= right.removeFirst();
        prefix.addLast(head2);
        weaveLists(left,right, results,prefix );
        prefix.removeLast();
        right.addFirst(head2);
    }
}

