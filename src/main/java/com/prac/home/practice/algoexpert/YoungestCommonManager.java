package com.prac.home.practice.algoexpert;

import java.util.HashSet;
import java.util.Set;

public class YoungestCommonManager {
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        Set<AncestralTree> visited = new HashSet<>();
        AncestralTree top = youngestCommonAncestor(topAncestor, descendantOne, visited);
        AncestralTree common= youngestCommonAncestor(topAncestor, descendantTwo, visited);
        return common;
    }

    static AncestralTree youngestCommonAncestor(AncestralTree topAncestor, AncestralTree descendant, Set<AncestralTree> visited){
        if (descendant==topAncestor) return topAncestor;
        if (visited.contains(descendant)) return descendant;
        visited.add(descendant);
        return youngestCommonAncestor(topAncestor, descendant.ancestor, visited);
    }
    static class AncestralTree {
        public char name;
        public AncestralTree ancestor; //parent

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
