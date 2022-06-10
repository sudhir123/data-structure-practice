package com.prac.home.datastructures.trees;

/**
 * Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an algorithm to determine if T2 is a subtree of Tl.
 * A tree T2 is a subtree of T1 if there exists a node n in Tl such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical
 */


public class CheckSubTree {
    Node root;
    static class Node{
        int data;
        Node(int data){ this.data=data;}
        Node left, right;
    }
    /*
     * An in-order traversal will definitely not work. After all, consider a scenario in which we were using binary
     * search trees. A binary search tree's in-order traversal always prints out the values in sorted order. Therefore,
     * two binary search trees with the same values will always have the same in-order traversals, even if their
     * structure is different.
     * Not understood this statement so as per solution we will go with preOrderTravrsal
     *     as per login lets do preorder traversal of tree and store in array / print
     *     root -> left -> right
     * solution # 1
    */
    boolean checkIdSubtree(Node node1, Node node2){
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        preOrderTraversal(node1, s1);
        preOrderTraversal(node2, s2);

        System.out.println(s1);
        System.out.println(s2);

        if (s1.toString().indexOf(s2.toString())!=-1) return true;

        return false;
    }
    void preOrderTraversal(Node node, StringBuffer str){
        if (node==null) {str.append("X"); return;}
        str.append(node.data);
        preOrderTraversal(node.left, str);
        preOrderTraversal(node.right,str);
    }

    // solution 2 -> Solution1 has space complexity high to reduce that we will search while travering and call match tree when we find root of t2
    // in t1 . Technically O(N+ km) every time we find
    boolean searchMatchingTree(Node rootNode, Node searchNode){
        if (rootNode==null) return false;
        if (rootNode==searchNode) {
            return matchTree(rootNode, searchNode);
        }
        return (searchMatchingTree(rootNode.left, searchNode) || searchMatchingTree(rootNode.right, searchNode));
    }
    boolean matchTree(Node root, Node searchNode){
        if (root==null && searchNode==null) return true; // both at last node. Till this point everything is matching
        else if (root ==null || searchNode==null) return false;

        if (matchTree(root.left, searchNode.left) && matchTree(root.right,searchNode.right))
            return true;
        return false;
    }

    public static void main(String[] args) {
        CheckSubTree c=new CheckSubTree();
        c.root=new Node(1);
        c.root.left=new Node(2);
        c.root.right=new Node(3);
        c.root.left.left=new Node(4);
        // solution # 1
        // System.out.println(c.checkIdSubtree(c.root,c.root.left ));

        //solution# 2
        System.out.println(c.searchMatchingTree(c.root,c.root.left));
    }
}
