package com.prac.home.practice.algoexpert;

public class FindKthSmallestValueInBST {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class BSTInfo{
        int numberOfNodeVisited;
        int lastVisitedNodeValue;
        BSTInfo(int numberOfNodeVisited, int lastVisitedNodeValue){
            this.numberOfNodeVisited= numberOfNodeVisited;
            this.lastVisitedNodeValue= lastVisitedNodeValue;
        }
    }
    public int findKthSmallestValueInBst(BST tree, int k) {
        BSTInfo bstInfo =new BSTInfo(0,-1);
        findKth(tree, k, bstInfo);
        return bstInfo.lastVisitedNodeValue;
    }

    public void findKth(BST tree, int k, BSTInfo bstInfo) {
        if (tree==null || bstInfo.numberOfNodeVisited>=k) return;
        findKth(tree.left, k, bstInfo);
        if (bstInfo.numberOfNodeVisited<k) {
            bstInfo.numberOfNodeVisited+=1;
            bstInfo.lastVisitedNodeValue= tree.value;;
            findKth(tree.right, k, bstInfo);
        }
    }
    // main
    public static void main(String[] args) {
        FindKthSmallestValueInBST f = new FindKthSmallestValueInBST();
        BST root= new BST(15);
        root.left= new BST(5);
        root.right= new BST(20);
        root.left.left= new BST(2);
        root.left.right= new BST(5);
        root.left.left.left= new BST(1);
        root.left.left.right= new BST(3);
        root.right.left= new BST(17);
        //root.right.right= new BST(22);
        System.out.println(f.findKthSmallestValueInBst(root, 3));
    }
}
