package com.prac.home.algoexpert.hard;

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
        int numberOfVertices = edges.length;
        Set<Integer> visited= new HashSet<>();
        int[] minDistances = new int[edges.length];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[start]=0;

        while (visited.size()!= numberOfVertices){ // O(n) n is number of vertices
            int[] vertexWithMinDis = getVertexWithMinimumDistance(visited, minDistances); // O(n)
            int parentVertex =vertexWithMinDis[0];
            int parentMinimumDis = vertexWithMinDis[1];
            visited.add(parentVertex);

            int[][] edgeList = edges[parentVertex];
            for (int[] edge: edgeList
                 ) {
                int childVertex= edge[0];
                int childVertexLength= edge[1];
                if (visited.contains(childVertex)) continue;

                int newDis= childVertexLength+ parentMinimumDis;
                if (newDis>=0 && newDis < minDistances[childVertex]){
                    minDistances[childVertex]= newDis;
                }

            }
        }
        int [] result = new int[minDistances.length];
        for (int i =0; i < minDistances.length; i ++){
            if (minDistances[i]==Integer.MAX_VALUE){
                result[i]=-1;
            }else {
                result[i]= minDistances[i];
            }
        }
        return result;
    }

    public int[] getVertexWithMinimumDistance(Set<Integer> visited, int[] minimumDistance){
        int currentMinDis = Integer.MAX_VALUE;
        int vertex=-1;

        for (int vertexId=0; vertexId < minimumDistance.length; vertexId ++){
            int distance = minimumDistance[vertexId];

            if (visited.contains(vertexId)) continue;

            if (distance<=currentMinDis){
                vertex= vertexId;
                currentMinDis= distance;
            }
        }
        return new int[]{vertex, currentMinDis};
    }

    // trying recursive
    // not 100% pass all results still better. lots of  problems... we are iterating same node multiple times.
    /*public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int [] result = new int[edges.length];
        Arrays.fill(result,-1);
        Map<Integer, Integer> mapVertexWithShortestLength=new HashMap<>();
        mapVertexWithShortestLength.put(start,0);
        Map<Integer, List<Integer>> mapVertexToParent=new HashMap<>();
        mapVertexToParent.put(0,null);
        BFSRecursion(start, edges,mapVertexWithShortestLength, mapVertexToParent );
        int i=0;
        for (Integer key: mapVertexWithShortestLength.keySet()
             ) {
            result[i]= mapVertexWithShortestLength.get(key);
            i++;
        }
        return result;
    }*/

    public void BFSRecursion(int idxParent, int[][][] edges, Map<Integer, Integer> mapVertexWithShortestLength, Map<Integer, List<Integer>> mapVertexToParent){

        int[][] vertexList = edges[idxParent];
        for (int[] ver: vertexList){
            int childVertex = ver[0];
            int childVertexLength= ver[1];
            if (!mapVertexToParent.containsKey(childVertex)){
                List<Integer> parentList = new ArrayList<>();
                parentList.add(idxParent);
                mapVertexToParent.put(childVertex,parentList );
                mapVertexWithShortestLength.put(childVertex, mapVertexWithShortestLength.get(idxParent)+childVertexLength);
            }else{
                List<Integer> parentList = mapVertexToParent.get(childVertex);
                if (parentList.contains(idxParent)) return;
                parentList.add(idxParent);
                mapVertexToParent.put(childVertex,parentList );
                updateShortestPath(idxParent, childVertex,childVertexLength, mapVertexWithShortestLength);
            }
            BFSRecursion(ver[0], edges, mapVertexWithShortestLength, mapVertexToParent);
        }
    }

    public void updateShortestPath(int idxParent, int childVertex, int childVertexLength,Map<Integer, Integer> mapVertexWithShortestLength ){

        int parentLength = mapVertexWithShortestLength.get(idxParent);
        int childExistingLength = mapVertexWithShortestLength.get(childVertex);
        int childNewLength = parentLength+ childVertexLength;

        int shortestPath = Math.min(childExistingLength, childNewLength);
        mapVertexWithShortestLength.put(childVertex,shortestPath );
    }

   /* // not working
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        Map<Integer, Integer> map=new HashMap<>();
        Map<Integer, List<Integer>> mapVertexToParent=new HashMap<>();
        for (int i =0; i < edges.length; i++){
            int[][] vertexList= edges[i];
            for (int[] ver: vertexList
            ) {
                int child = ver[0];
                if (mapVertexToParent.containsKey(child)){
                    mapVertexToParent.get(child).add(i);
                }else {
                    List<Integer> parents= new ArrayList<>();
                    parents.add(i);
                    mapVertexToParent.put(child, parents);
                }
            }
        }
        map.put(0,0);
        BFS(0, edges, map, mapVertexToParent);
        return new int[] {};
    }*/

    public void BFS(int vertex, int[][][] edges, Map<Integer, Integer> map, Map<Integer, List<Integer>> mapVertexToParent){
        Stack<int[][]> stack= new Stack<>();
        stack.add(edges[vertex]);
        while (!stack.isEmpty()){

            int[][] vertexList = stack.pop();
            for (int[] ver: vertexList
            ) {
                int nextVertex = ver[0];
                int nextVertexLength= ver[1];
                if (mapVertexToParent.containsKey(nextVertex)){
                    updateShortest(map, ver, mapVertexToParent);
                    stack.push(edges[nextVertex]);
                }else{
                    map.put(nextVertex, nextVertexLength);
                }
            }
        }
    }

    public void updateShortest(Map<Integer, Integer> map,int[] ver, Map<Integer, List<Integer>> mapVertexToParent ){
        int nextVertex = ver[0];
        int nextVertexLength= ver[1];
        List<Integer> parents = mapVertexToParent.get(nextVertex);
        int shortestPath=Integer.MAX_VALUE;
        for (Integer parent: parents
        ) {
            shortestPath= Math.min(shortestPath,map.get(parent)+ nextVertexLength);
        }
        map.put(nextVertex, shortestPath);
    }
}























