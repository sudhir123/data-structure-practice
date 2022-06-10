package com.prac.home.algoexpert.medium;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        return validBST(tree, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    static boolean validBST(BST tree, Integer min, Integer max){
        if (tree==null)
            return true;
        if ((min !=null && min >tree.value) || (max!=null && max<= tree.value )) return false;
        if (!validBST(tree.left, min, tree.value) || !validBST(tree.right, tree.value, max)){
            return false;
        }
        return true;
    }

    static Integer lastPrinted=0;
    static boolean checkBSTSolution2(BST root){
        if (root==null)
            return true;
        if (!checkBSTSolution2(root.left))
            return false;
        if (lastPrinted!=null && root.value<=lastPrinted)
            return false;
        lastPrinted= root.value;
        if (!checkBSTSolution2(root.right))
            return false;

        return true;
    }
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
    static BST root;

    public static void main(String[] args) {
        root= new BST(10);
        root.left= new BST(5);
        root.right= new BST(15);
        root.right.left= new BST(13);
        root.right.right= new BST(22);
        root.right.left.right= new BST(14);

        root.left.left= new BST(2);
        root.left.right= new BST(5);
        root.left.left.left= new BST(1);

        System.out.println(validateBst(root));
    }
}
