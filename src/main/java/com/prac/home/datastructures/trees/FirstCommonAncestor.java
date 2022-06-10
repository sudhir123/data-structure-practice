package com.prac.home.datastructures.trees;

import lombok.Getter;
import lombok.Setter;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional
 * nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
public class FirstCommonAncestor {
    // with links to parent
    @Getter@Setter
    static class Node{
        int data;
        Node parent, right , left;
        Node(int data){this.data=data;}
    }

    public static void main(String[] args) {
        FirstCommonAncestor f = new FirstCommonAncestor();
        // solution 1
       /* Node root = new Node(1);
        root.left= new Node(2);
        root.left.parent=root;
        root.right= new Node(3);
        root.right.parent=root;

        root.left.left= new Node(4);
        root.left.left.parent= root.left;
        root.left.right= new Node(5);
        root.left.right.parent=root.left;

        root.right.left= new Node(6);
        root.right.left.parent= root.right;
        root.right.right= new Node(7);
        root.right.right.parent= root.right;

        root.right.right.left= new Node(8);
        root.right.right.left.parent=root.right.right;

        Node node = f.commonAncestor(root.right.right.left, root.left.right);
        System.out.println(node.data);*/
        Node root = new Node(3);
        root.left= new Node(5);
        //root.left.parent=root;
        root.right= new Node(1);
        //root.right.parent=root;

        root.left.left= new Node(6);
        //root.left.left.parent= root.left;
        root.left.right= new Node(2);
        //root.left.right.parent=root.left;

        root.right.left=new Node(0);
        //root.left.left.left.parent=root.left.left;
        root.right.right= new Node(8);
        //root.left.left.right.parent=root.left.left;

        root.left.right.left= new Node(7);
        root.left.right.right= new Node(4);


        //solution 2 IS TO GO TO PARENT AND TRACK ANOTHER SUBTREE if finds another node than come back to the node is parent
        //Node node = f.commonAncestorTrackSubtree(root.left, root.right) ;
        //System.out.println(node.data);

        //solution 3
        //Node node = f.commonAncestorByFindingSingleTree(root, root.left, root.right) ;

        // solution 3 without connecting to parent node -- even simpler. Just check if p and q are on same side , different side.
        // that means if from root they are on different side ..then done root is parent. if they are on right or on left ... go for that side only


        Node node = f.commonAncestorWithSingleTraverse(root, root.left,new Node(10)) ;
        System.out.println(node.data);
    }

    Node commonAncestorWithSingleTraverse(Node root, Node p, Node q){
        if (root==null) return null;

        if (root==p && root==q){
            return root;
        }
        Node x= commonAncestorWithSingleTraverse(root.left, p,q);
        /*if (x!=null &&( x!=p && x!=q)){
            return x;
        }*/
        Node y= commonAncestorWithSingleTraverse(root.right, p,q);
        /*if (y!=null &&( y!=p && y!=q)){
            return y;
        }*/

        if ( x!=null && y!=null) {
            return root;
        }else if(root==p || root==q) {
            return root;
        }else {
            return x!=null?x:y;
        }
    }








    /*Node commonAncestorWithSingleTraverse(Node root, Node p, Node q){
        if (root==null) return null;
        if (root==p && root==q) return root; // all are same

        Node x = commonAncestorWithSingleTraverse(root.left, p,q);
        if (x!=null && x!=p && x!=q ){ // why becuase once you returned with matching node than it should not match with any other node
            return x;                   // like child match in this case 3 than parent and all should not match and returned 3 every time.
        }
        Node y = commonAncestorWithSingleTraverse(root.right, p, q);
        if (y!=null && y !=p && y !=q){
            return y;
        }

        if (x!=null && y !=null){
            return root; // parent node
        }else if (root==p || root== q){
            return root;
        }else {
            return x!=null ?x :y;
        }
    }*/
    //solution 4 -> ( 3 is good but we are traversing subtree multiple times. Lets make if single traverse)
    /*Node commonAncestorWithSingleTraverse(Node root, Node p, Node q){
        if (root==null) return null;
        if (root==p && root==q) return root;

        Node x = commonAncestorWithSingleTraverse(root.left, p, q );
        if (x!=null  && x != p && x != q){
            return x;
        }
        Node y = commonAncestorByFindingSingleTree(root.right, p, q);
        if (y !=null && y != p && y != q){
            return y;
        }

        if (x !=null && y !=null ) return root;
        else if (root==p || root==q) return root;
        else {
            return x == null ? y : x;
        }
    }*/


    // solution 3
    Node commonAncestorByFindingSingleTree( Node root, Node x, Node y){
        if (root==null || root==x || root==y){
            return root;
        }
        boolean isXOnLeft= cover(root.left, x);
        boolean isYOnLeft= cover(root.right, y);
        if (isXOnLeft && isYOnLeft) return root;

        return isXOnLeft ?commonAncestorByFindingSingleTree(root.left,x,y): commonAncestorByFindingSingleTree(root.right,x,y);
    }

    boolean cover(Node root , Node x){
        if (root==null) return false;
        if (root==x) return true;
        return cover(root.left, x) || cover(root.right, x);
    }

    // solution 2
    Node commonAncestorTrackSubtree(Node node1,Node node2) {
        if (node1==null) return null;
        Node parent = node1.parent;
        if(parent.right==node1){
            if (traverseTree(parent.left, node2)){
                return parent;
            }
        }else{
            if (traverseTree(parent.right, node2)){
                return parent;
            }
        }
        return  commonAncestorTrackSubtree(parent, node2);
    }

    boolean traverseTree(Node root, Node x){
        if (root==null) return false;
        if (x==root) return true;
        if (traverseTree(root.left,x) || traverseTree(root.right, x)){
            return true;
        }
        return false;
    }

    //solution 1
    Node commonAncestor(Node node1,Node node2) {
        int delta = depthFromRoot(node1) - depthFromRoot(node2);
        Node shallowerNode = delta>0 ? node2 : node1;
        Node deeperNode = delta>0 ? node1:node2;
        deeperNode = goUpBy(deeperNode,delta);

        while (shallowerNode.parent!= deeperNode.parent){
            shallowerNode=shallowerNode.parent;
            deeperNode= deeperNode.parent;
        }
        return shallowerNode.parent;
    }
    Node goUpBy(Node node, int delta){
        while (delta >0){
            node= node.parent;
            delta--;
        }
        return node;
    }
    int depthFromRoot(Node node){
        int depth=0;
        while (node.parent!=null){
            node= node.parent;
            depth++;
        }
        return depth;
    }
}






































































































