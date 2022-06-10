package com.prac.home.algoexpert.medium;

import com.prac.home.datastructures.trees.Successor;

/**
 *
 */
public class BSTConstruction {
    static BST root;
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            if (this.value> value){
                if (left!=null){
                    left.insert(value);
                }else {
                    return left=new BST(value);
                }
            }else {
                if (right!=null){
                    right.insert(value);
                }else {
                    return right=new BST(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            if (this.value==value) return true;
            else if (this.value>value){
               if ( left!=null) return left.contains(value);
               else return false;
            }else {
                if ( right!=null) return right.contains(value);
                else return false;
            }
            //return false;
        }
// worst written
        /*public BST remove(int value) {
            // traverse to node you want to remove.
            BST node = findNode(value);
            if (node==null) return this;
            //System.out.println("fount ref of node u want to remove-> "+node.value);
            //BST node = findNode(12);
            //than find nextMaxValue node
            BST nextMinRef=null;
            if (node!=null && node.right!=null){
                nextMinRef= node.right.rightMinValue(node.value) ;
                node.right.removeLeafFromParent(nextMinRef.value, node.right);
                node.value= nextMinRef.value;
            }
            else if (node!=null && node.left!=null){
                nextMinRef= node.left.leftMaxValue(node.value);
                node.left.removeLeafFromParent(nextMinRef.value, node.left);
                node.value= nextMinRef.value;
            }else {
                // this is a leaf node, we just need to find parent and set leaf node to null
                BST parent = this.removeLeafFromParent(value, null);
                if (parent==null) return null;
                //System.out.println("fount parent -> "+parent.value);
            }

            // find parent of 12 , if we can do that , we just need to set the left/right, where 12 belongs =null and
            // replace search node with 12.
            return this;
        }
        BST removeLeafFromParent(int value, BST parent){
            if (this.value==value) return parent;
            else if (left!=null && this.value> value){
                BST foundParent=  left.removeLeafFromParent(value,this);
                foundParent.left=null;
                return foundParent;
            }else if (right!=null && this.value< value){
                BST foundParent= right.removeLeafFromParent(value,this);
                foundParent.right=null;
                return foundParent;
            }
            return null;
        }

        BST findNode(int value){
            if (this.value==value) return this;
            else if (left!=null && this.value> value){
                return left.findNode(value);
            }else if (right!=null && this.value< value){
                return right.findNode(value);
            }
            return null;
        }

        BST rightMinValue(int value){
            if (left==null) return this;
            BST found= left.rightMinValue(value);
            if (this.left==found) {
                left=null;
            }
            return found;
        }
        BST leftMaxValue(int value){
            if (right==null) return this;
            BST found = right.leftMaxValue(value);
            if (this.right==found) {
                right=null;
            }
            return found;
        }*/

        // best written by algo
        public BST remove(int value) {
            remove(value,  null);
            return this;
        }
        public void remove(int value, BST parent) {
            if (value < this.value){
                if (left !=null) {
                    left.remove(value, this);
                }
            }
            else if (value > this.value){
                if (right !=null) {
                    right.remove(value, this);
                }
            }else {
                // this is the node we are searching to remove. Now this node can have multiple cases
                // 1) this is root node means parent null
                // 2) child exixts some where in middle of tree
                // child does not exits .. means leaf node.
                if (left!=null && right!=null){
                    this.value= right.getMinimumValue();
                    right.remove(this.value, this);
                }else if (parent==null){
                    if (left!=null){
                        this.value= left.value;
                        right= left.right;
                        left= left.left;
                    }else if (right!=null){
                        this.value= right.value;
                        left= right.left;
                        right= right.right;
                    }else {
                        // single node tree do nothing
                    }
                }else if (parent.left==this){
                    parent.left= left!=null?left:right;
                }else if (parent.right==this){
                    parent.right= left!=null?left:right;
                }
            }
        }

        int getMinimumValue(){
            if (left==null){
                return this.value;
            }else {
                return left.getMinimumValue();
            }
        }
    }



    public static void main(String[] args) {
        root= new BST(10);
        root.insert(5);
        root.insert(15);
        root.insert(2);
        root.insert(5);
        root.insert(13);
        root.insert(22);
        root.insert(1);
        root.insert(14);
        root.insert(12);
        root.remove(5);
        root.remove(5);
        root.remove(12);
        root.remove(13);
        root.remove(14);
        root.remove(22);
        root.remove(2);
        root.remove(1);
        if (root.contains(15)) System.out.println( "-> "+true); else System.out.println(false);

    }
}

















