package com.prac.home.practice;

import java.util.*;

/**
 * given an integer "start" and list of pair of integers. List represents a graph. Number of vertices in graph is equal to length of list.
 * each vertex i tells outbound vertex and length [destination, distance]. compute shortest path to each vertex.
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        DijkstraAlgorithm d= new DijkstraAlgorithm();
        System.out.println(Arrays.toString(d.dijkstrasAlgorithm(1, new int[][][]
                {
                        {{1, 2}},
                        {{0, 1}},
                        { {3, 1} },
                        { {2, 2} }
                })));
    }
    // create a data structure such that we look at DS and get the minimum value from the unvisited nodes.
    // pick that node and check for outgoing edeges of that node. Very imp thing to note with Dijkstra Algo is that what kind of
    // lengths/wights we. Like in this case, we have all positives weights thats why we can skip the node which is revisiting
    // because that node must have shorter distance from the latter revisiting node. But that's not the case with -ver wights
    // as that may lead to reduce the new path. Hence Dijkstra algo depends on kinds of wights.
    // lets do it via array first, which has time complexity of O(v^2 +e). v^2 because seaching minimum elemnt from array would be O(v)
    // time operation.
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int numberOfNodes= edges.length;
        Set<Integer> visited = new HashSet<>();
        int[] minimumDist= new int[edges.length];
        Arrays.fill(minimumDist, Integer.MAX_VALUE);
        minimumDist[0]=0;

        while (visited.size()< numberOfNodes){
            int[] nodeWithDist= getNonVisitedMinimumDistNode(minimumDist, visited);
            int parentNode = nodeWithDist[0];
            int parentNodeDistance = nodeWithDist[1];
            visited.add(parentNode);
            int[][] edge = edges[parentNode];
            for (int[] e: edge
                 ) {
                int node = e[0];
                int nodeLength= e[1];

                if (visited.contains(node)) continue;

                int newDis = nodeLength+parentNodeDistance;
                if (newDis >=0 && newDis  < minimumDist[node]){
                    minimumDist[node]=  newDis;
                }
            }
        }
        int[] result = new int[minimumDist.length];
        for (int i=0; i < minimumDist.length; i++){
            if (minimumDist[i]==Integer.MAX_VALUE){
                result[i]=-1;
            }else {
                result[i]=minimumDist[i];
            }
        }
        return result;
    }

    public int[] getNonVisitedMinimumDistNode(int[] minimumDistArray, Set<Integer> visited){
        int vertexDist= Integer.MAX_VALUE;
        int vertex= -1;
        for (int i=0; i <minimumDistArray.length; i++){
            if (visited.contains(i)) continue;

            if (minimumDistArray[i]<= vertexDist){
                vertex=i;
                vertexDist= minimumDistArray[i];
            }
        }
        return new int[]{vertex, vertexDist};
    }

}























