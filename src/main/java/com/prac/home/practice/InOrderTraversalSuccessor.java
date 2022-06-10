package com.prac.home.practice;
/**
 * Inorder Successor is NULL for the last node in Inorder traversal. In Binary Search Tree,
 * Inorder Successor of an input node can also be defined as the node with the smallest key greater than the key of the input node.
 * So, it is sometimes important to find next node in sorted order
 */
public class InOrderTraversalSuccessor {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value, BinaryTree left, BinaryTree right, BinaryTree parent) {
            this.value = value; this.left= left; this.right=right; this.parent=parent;
        }
    }

    // when we have parent given and populated. Its very simple get the left most node in case have nodex.right present
    // if nodex dont have right than we need to for parent , for parent again very simple, we need to go to parent above till the point
    // your current node is on right side of the parent.
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if (node.right!=null){
            return leftMostSuccessor(node);
        }
        return getRightParentSuccessor(tree, node);
    }

    public BinaryTree getRightParentSuccessor(BinaryTree tree, BinaryTree node){
        BinaryTree currentNode = node;
        while (currentNode!=null && currentNode.parent.right==currentNode){
            currentNode= currentNode.parent;
        }
        return currentNode.parent;
    }

    public BinaryTree leftMostSuccessor(BinaryTree node){
        while (node.left!=null){
            node= node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(
                1,
                new BinaryTree(
                        2,
                        new BinaryTree(
                                4,
                                    new BinaryTree( 6, null, null, null)
                                , new BinaryTree( 7, null, null, null),
                                null
                        ),
                        new BinaryTree(5, null, null, null)
                        , null),
                new BinaryTree(3, null, null, null)
                , null);

        InOrderTraversalSuccessor i =new InOrderTraversalSuccessor();
        System.out.println(i.findSuccessor(root, root.left.left.right).value);
    }
}


































