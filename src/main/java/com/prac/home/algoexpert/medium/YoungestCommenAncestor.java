package com.prac.home.algoexpert.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * three nodes given as paramtere , first is root second and third are random nodes.
 * Write function to find the common ancestor for the two nodes.
 */
public class YoungestCommenAncestor {
    //using set time O(d) but space will not be O(1)
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        /*
        // using set time O(d) but space will not be O(1)

        Set<AncestralTree> set= new HashSet<>();
        findCommonParent(descendantOne, set );
        AncestralTree common= findCommonParent(descendantTwo,set);
        return common==null?topAncestor:common;
        */


        // another better approach is same as find the intersection point of linkedlist
        // calculate height of each decendent and than move lower one with difference and than move both.
        int heightOne = calculateHeight(descendantOne);
        int heightTwo = calculateHeight(descendantTwo);

        if (heightOne>heightTwo){
            return findCommonParent(descendantOne, descendantTwo, heightOne-heightTwo);
        }else {
            return findCommonParent(descendantTwo, descendantOne, heightTwo-heightOne);
        }
    }
    static AncestralTree findCommonParent(AncestralTree leaf, Set<AncestralTree> set){
        AncestralTree current=leaf;
        while (current!=null && current.ancestor!=null){
            if (set.contains(current)) return current;
            else set.add(current);
            current= current.ancestor;
        }
        return null;
    }

    static AncestralTree findCommonParent(AncestralTree lower, AncestralTree higher , int diff){
        while (diff!=0){
            lower= lower.ancestor;
            diff--;
        }
        while (lower!=higher){
            lower= lower.ancestor;
            higher=higher.ancestor;
        }
        return lower;
    }

    static int calculateHeight(AncestralTree node){
        int counter=0;
        while (node!=null){
            node= node.ancestor;
            counter++;
        }
        return counter;
    }


    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}



























