package com.prac.home.datastructures.trees;

/**
 * a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one
 */
public class CheckIfTreeIsBalanced {
    // #mythinking says create ArrayList<LinkedList<Nodes>. Now any two index will have difference of 1. Lets see.
    class Node{
        int data;
        Node right, left;
        Node(int data){ this.data=data;}
    }
    int getHeight(Node root){
        if (root==null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }

    // this approach is too much of checking on ear node and again and again.
    boolean checkBalancedTree(Node root){
        if (root==null) return true; // yes its balanced tree valid case
        int height= getHeight(root.left)-getHeight(root.right);
        if(Math.abs(height)>1){
            return false;
        }else{
            return checkBalancedTree(root.left)&&checkBalancedTree(root.right);
        }
    }

    // better approach to avoid checking node again and again.
    // why we are doing Max(left, right)+1. because  lets say node is alast node at the level and below that is right and left
    // are null , so in case of null we are returning -1 and Max(-1,-1) =-1 +1  to make it 0 so that it tells that below this
    // there is no node. and parent has this child only which will be +1.
    //This code runs in 0 (N) time and 0 (H) space, where H is the height of the tree.
    int checkBalancedTreeWithBetterSpaceAndTimeComplexity(Node root){
        if (root==null) return -1;
        int leftHeight=checkBalancedTreeWithBetterSpaceAndTimeComplexity(root.left);
        if (leftHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight=checkBalancedTreeWithBetterSpaceAndTimeComplexity(root.right);
        if (rightHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int diff = leftHeight-rightHeight;
        if(Math.abs(diff)>1){
            return Integer.MAX_VALUE;
        }else{
            return Math.max(leftHeight, rightHeight)+1;
        }
    }
}




















