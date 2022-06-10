package com.prac.home.algoexpert.medium;

import java.util.*;

public class CycleInGraph {
    boolean DFSForDirectedGraph(int[][] edges, int node,boolean[] visited, boolean [] inStack ){
        inStack[node]=true;
        visited[node]=true;

        int[] childNodes= edges[node];
        for (int i =0; i <childNodes.length; i++){
            if (!visited[childNodes[i]]) {
                if (inStack[childNodes[i]]) return true;
                else {
                    return DFSForDirectedGraph(edges, childNodes[i], visited, inStack);
                }
            }
        }
        inStack[node]=false;
        return false;
    }

    public boolean cycleInGraph(int[][] edges) {

        boolean[] visited = new boolean[edges.length];
        boolean [] inStack= new boolean[edges.length];

        for (int node =0; node < edges.length; node++){
            if (!visited[node]){
                if(DFSForDirectedGraph(edges,node, visited, inStack )) return true;
            }
        }

        return false;

        /*
        some issue not able to handle special cases where child node is not poitning to any other node
        //and  be reached by two nodes

        Set<Integer> visitedSet= new HashSet<>();
        int i=0; boolean cyclic=false;
        while (i <edges.length){
            if (!visitedSet.contains(i)){
                System.out.println(i);
                cyclic=  DFS(edges,0,visitedSet);
                System.out.println(cyclic);
            }
            i++;
        }
        return cyclic;*/
    }
    // this algo is for undirected graph
    boolean DFS(int[][] edges, int parentIdx, Set<Integer> visitedSet){
        Stack<Integer> stack = new Stack<>();
        stack.push(parentIdx);
        while (!stack.isEmpty()){
            Integer idx = stack.pop();
            if (visitedSet.contains(idx) ) return true;
            visitedSet.add(idx);
            int[] childNodes = edges[idx];
            for (int i = 0; i <= childNodes.length - 1; i++) {
                stack.push(childNodes[i]);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        CycleInGraph c= new CycleInGraph();
        System.out.println(c.cycleInGraph(new int[][]{ {1, 2},{2},{}}));
    }
}
