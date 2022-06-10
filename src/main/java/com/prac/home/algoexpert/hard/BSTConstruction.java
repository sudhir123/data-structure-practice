package com.prac.home.algoexpert.hard;

public class BSTConstruction {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (this.value > value){
                if (left!=null){
                    left.insert(value);
                }else {
                    left= new BST(value);
                }
            }else {
                if (right!=null){
                    right.insert(value);
                }else {
                    right= new BST(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            if (this.value==value){
                return true;
            }else if (this.value > value){
                if (left!=null){
                    return left.contains(value);
                }
            }else {
                if (right!=null){
                    return right.contains(value);
                }
            }
            return false;
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public BST remove(int value, BST parent) {
            if (value< this.value){
                if (left!=null){
                    left.remove(value, this);
                }
            }else if (value> this.value){
                if (right!=null){
                    right.remove(value, this);
                }
            }else {
                if (right!=null && left!=null){
                    this.value= right.getMinimum();
                    right.remove(this.value, this);
                }else if (parent==null){
                    // this comes when u have match to parent node and only left or right nodes are there not both
                    // had it been both , it would have match in previous condition. This comes when only one is there
                    if (left!=null) {
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    }else if (right!=null){
                        this.value= right.value;
                        left= right.left;
                        right= right.right;
                    }else {
                        // nothing node is only thing
                    }
                }else if (parent.left==this){
                    parent.left= left!=null?left:right;
                }else if (parent.right==this){
                    parent.right= left!=null?left:right;
                }
            }
            return this;
        }

        public int getMinimum(){
            if (left!=null){
                return left.getMinimum();
            }else {
                return this.value;
            }
        }
    }
}
