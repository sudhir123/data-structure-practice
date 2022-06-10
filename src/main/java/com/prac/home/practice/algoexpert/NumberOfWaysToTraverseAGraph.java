package com.prac.home.practice.algoexpert;

public class NumberOfWaysToTraverseAGraph {
    public static void main(String[] args) {
        NumberOfWaysToTraverseAGraph n= new NumberOfWaysToTraverseAGraph();
        System.out.println(n.numberOfWaysToTraverseGraph(2,3));
    }
    public int numberOfWaysToTraverseGraph(int width, int height) {
        return dfs(width, height);
    }

    public int dfs(int width, int height) {
        if (width==1 || height==1) return 1;

       return dfs(width-1, height)+ dfs(width, height-1);
    }
}
