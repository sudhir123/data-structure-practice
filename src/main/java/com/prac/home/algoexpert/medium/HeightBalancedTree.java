package com.prac.home.algoexpert.medium;

/**
 * function to return true or false , if the height is balanced. Height is balanced if difference between left and subtree is max 1
 * 12-NOV-2021
 */
public class HeightBalancedTree {
    static class TreeInfo{
        boolean isBalanced;
        int height;
        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced=isBalanced;
            this.height = height;
        }
    }
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
        public BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.value = value;
            this.left= left;
            this.right=right;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
         return getTreeInfo(tree).isBalanced;
    }

    TreeInfo getTreeInfo(BinaryTree tree){
        if (tree==null)
            return new TreeInfo(true, -1);

        TreeInfo leftInfo = getTreeInfo(tree.left);
        TreeInfo rightInfo = getTreeInfo(tree.right);

        boolean isBalanced = leftInfo.isBalanced
                && rightInfo.isBalanced
                && Math.abs( leftInfo.height - rightInfo.height) <=1;

        // while saving maximum height on any node will always be max(left, right)+1
        // on top of this height , u calculate the condition.
        int heightDiff = Math.max( leftInfo.height , rightInfo.height)+1;

        return new TreeInfo(isBalanced, heightDiff);
    }

    public static void main(String[] args) {
        HeightBalancedTree h =new HeightBalancedTree();
        BinaryTree tree= new BinaryTree(1,
                new BinaryTree(2,
                        new BinaryTree(4,null, null),
                        new BinaryTree(5,
                                new BinaryTree(7,null, null),
                                new BinaryTree(8,null,null))),
                new BinaryTree(3, null,
                        new BinaryTree(6,
                                new BinaryTree(9,null, null),
                                new BinaryTree(10,null, null)))
                );
        h.heightBalancedBinaryTree(tree);
    }
}































