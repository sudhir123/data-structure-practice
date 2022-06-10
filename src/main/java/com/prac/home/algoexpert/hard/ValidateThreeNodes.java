package com.prac.home.algoexpert.hard;

/**
 * In Binary Search Tree (all left nodes are less than the root and all right nodes are greater or equal to root.
 * Valid for every node in tree), you are provided three nodes nodeOne, nodeTwo, nodeThree. NodeOne or NodeThree (any one)
 * will be ancestor and other be descendant. If so return true.
 */
public class ValidateThreeNodes {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

     public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        // Write your code here.
        if ( (isDescendant(nodeOne, nodeTwo) && isDescendant(nodeTwo, nodeThree))
                || (isDescendant(nodeThree, nodeTwo) && isDescendant(nodeTwo, nodeOne)) ){
            return true;
        }
        return false;
    }

     boolean isDescendant(BST root, BST nodeTwo){
        if (root==null) return false;

        if (root!=null && (root.value==nodeTwo.value)) return true;

        if (isDescendant(root.left,nodeTwo) || isDescendant(root.right,nodeTwo)  ) return true;

        return false;
    }

    public static void main(String[] args) {
        ValidateThreeNodes v = new ValidateThreeNodes();
        BST root = new BST(5);
        root.left= new BST(2);
        root.right= new BST(7);
        root.left.left= new BST(1);
        root.left.right= new BST(4);
        root.left.left.left= new BST(0);
        root.left.right.left= new BST(3);
        root.right.left= new BST(6);
        root.right.right= new BST(8);


        System.out.println(v.validateThreeNodes(root,root.left,root.left.right.left ));
    }
}
