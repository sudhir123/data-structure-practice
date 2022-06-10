package com.prac.home.practice.algoexpert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DjikstraAlgo {
    // 1) create ds which wil give us minimum distance bwteen child nodes.

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int[] result= new int[edges.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        Set<Integer> visited = new HashSet<>();
        int currentVertex =start;
        result[start]=0;
        while (visited.size()!=edges.length){
            int[] parent = lowestDistance(visited, result );
            int parentVertex= parent[0];
            int parentDis = parent[1];
            visited.add(parentVertex);
            int[][] outGoingEdges = edges[parentVertex];
            for (int[] edge: outGoingEdges
                 ) {
                int childVertex= edge[0];
                int childDis = edge[1];
                if (visited.contains(childVertex)) continue;
                int totalDis = childDis+parentDis;
                result[childVertex]= totalDis;
            }
        }


        return result;
    }

    public int[] lowestDistance(Set<Integer> visited, int [] result){
        int minDis = Integer.MAX_VALUE;
        int[] next = new int[2];
        for (int i=0; i < result.length; i++){
            if (visited.contains(i))continue;
            if (minDis > result[i]){
                next[0]=i; next[1]= result[1];
            }
        }
        return next;
    }

    public static void main(String[] args) {

    }
}
