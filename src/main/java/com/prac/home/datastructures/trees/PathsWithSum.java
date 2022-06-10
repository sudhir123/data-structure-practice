package com.prac.home.datastructures.trees;

import java.util.HashMap;
import java.util.Map;

/**
 *You are given a binary tree in which each node contains an integer value (which might be positive or negative).
 * Design an algorithm to count the number of paths that sum to a given value. The path does not need to start or end
 * at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes). Question is about calculating how many such paths possible
 * not only tru of false. Remember only downward
 */
public class PathsWithSum {
    static class Node{
        int data ; Node right, left;
        Node(int data){ this.data=data;}
    }
    Node root;
    // solution #1 my thinking was first to give true or false.
    boolean m1(Node root){
        if (root==null) return false;
        if (!sumCalc(root,0)){
            return m1(root.left)|| m1(root.right);
        }
        return false;
    }
    boolean sumCalc(Node root, int sum){
        if (root==null) return false;
        sum = sum+root.data;
        if (sum==8){
            return true;
        }else {
            return sumCalc(root.left, sum) || sumCalc(root.right, sum);
        }
    }

    // actually solution #2

    int traverseNodes(Node root){
        if (root==null) return 0;
        int pathsFromRoot=  calculatePaths(root, 0, 10);
        int leftPathCount = traverseNodes(root.left);
        int rightPathCount = traverseNodes(root.right);

        return pathsFromRoot+leftPathCount+rightPathCount;
    }

    int calculatePaths(Node root, int currentSum, int targetedSum){
        if (root==null) return 0;
        currentSum= currentSum+root.data;
        int numberOfPaths=0;
        if (currentSum==targetedSum){
            numberOfPaths++;
        }
        numberOfPaths += calculatePaths(root.left, currentSum, targetedSum);
        numberOfPaths += calculatePaths(root.right, currentSum, targetedSum);
        return numberOfPaths;
    }

    // solution# 3 : not to repeat calculatePath
    int countPathsWithSum(Node root , int targetSum, int runningSum, Map<Integer, Integer> pathCount){
        if (root==null) return 0;
        runningSum= runningSum+root.data;
        int sum = runningSum - targetSum;  // this sum is basically runningsum but at different Index.
        int totalPaths= pathCount.getOrDefault(sum, 0);
        if (runningSum==targetSum){
            totalPaths++;
        }
        // put back value
        incrementPath(pathCount, runningSum, 1);
        totalPaths+= countPathsWithSum(root.left,targetSum, runningSum, pathCount);
        totalPaths+= countPathsWithSum(root.right,targetSum, runningSum, pathCount);
        incrementPath(pathCount, runningSum, -1);
        return totalPaths;
    }
    void incrementPath(Map<Integer, Integer> pathCount, int runningSum, int incrementby){
        int newCount= pathCount.getOrDefault(runningSum,0)+incrementby;
        if (newCount==0){
            pathCount.remove(runningSum);
        }else {
            pathCount.put(runningSum, newCount);
        }
    }

    public static void main(String[] args) {
        PathsWithSum p = new PathsWithSum();
        /*p.root= new Node(3);
        p.root.left= new Node(-4);
        p.root.left.right= new Node(1);
        p.root.left.right.left= new Node(-1);
        p.root.right= new Node(5);
        p.root.right.right= new Node(8);
        p.root.right.right.right= new Node(11);
        p.root.right.right.left= new Node(6);*/

        p.root= new Node(3);
        p.root.right= new Node(-4);
        p.root.right.right= new Node(1);
        p.root.right.right.right= new Node(-1);
        p.root.right.right.right.right= new Node(5);
        p.root.right.right.right.right.right= new Node(8);
        p.root.right.right.right.right.right.right= new Node(11);
        p.root.right.right.right.right.right.right.right= new Node(6);



        // Remember only downward
        System.out.println(p.countPathsWithSum(p.root,10, 0, new HashMap<Integer, Integer>()));
        //System.out.println(p.traverseNodes(p.root));
    }
}

























