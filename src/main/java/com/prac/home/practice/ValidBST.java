package com.prac.home.practice;

public class ValidBST {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode t= new TreeNode(1);
        t.right= new TreeNode(1);
        ValidBST v = new ValidBST();
        System.out.println(v.isValidBST(t));
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean validate(TreeNode root, Integer min, Integer max) {
        if (root==null) return true;
        if (min> root.val || max <= root.val){
            return false;
        }
        if (!validate(root.left, min, root.val) ){
            return false;
        }
        if (!validate(root.right, root.val, max) ){
            return false;
        }
        return true;
    }
}
