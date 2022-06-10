package com.prac.home.algoexpert.hard;

public class FindClosestValueInBST {
    public static void main(String[] args) {
        BST root = new BST(10);
        root.left= new BST(5);
        root.right= new BST(15);
        root.left.left= new BST(2);
        root.left.right= new BST(5);
        root.right.left= new BST(13);
        root.right.right= new BST(22);
        root.left.left.left= new BST(1);
        root.right.left.right= new BST(14);

        System.out.println(findClosestValueInBst(root, 12));
    }
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestNode(tree, target, tree.value).value;
        //return findValue(tree, target).result.value;
    }

    static BST findClosestNode(BST tree, int target, int closest){
        if (Math.abs(closest-target) > Math.abs(tree.value-target)){
            closest= tree.value;
        }
        if (target< tree.value && tree.left!=null){
            return findClosestNode(tree.left, target, closest);
        }else if (target> tree.value && tree.right!=null){
            return findClosestNode(tree.right, target, closest);
        }else {
            return tree;
        }
    }

    public static TreeInfo findValue(BST tree, int target) {
        if (tree==null) return new TreeInfo(null, Integer.MAX_VALUE);
        TreeInfo treeInfo ;

        if (target==tree.value){
            treeInfo= new TreeInfo(tree, 0);
        } else if (target<tree.value){
            treeInfo= findValue(tree.left, target);
            if (treeInfo.diff > Math.abs(tree.value-target)){
                treeInfo.result=tree;
                treeInfo.diff=Math.abs(tree.value-target);
                return treeInfo;
            }
        }else {
             treeInfo= findValue(tree.right, target);
            if (treeInfo.diff > Math.abs(tree.value-target)){
                treeInfo.result=tree;
                treeInfo.diff=Math.abs(tree.value-target);
                return treeInfo;
            }
        }
        return treeInfo;
    }

    static class TreeInfo{
        BST result;
        int diff;
        TreeInfo(BST result, int diff){
            this.result=result;
            this.diff= diff;
        }
    }
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
