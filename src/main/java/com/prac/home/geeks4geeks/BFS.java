package com.prac.home.geeks4geeks;

import java.util.*;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        return bfs(0, adj, result, visited);
    }

    public ArrayList<Integer> bfs(int vertex, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result , Set<Integer> visited ) {

        Queue<Integer> queue= new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()){
            Integer val = queue.remove();
            if (visited.contains(val)){
                continue;
            }else {
                visited.add(val);
                result.add(val);
            }
            ArrayList<Integer> list = adj.get(val);
            for (Integer i: list
                 ) {
                queue.add(i);
            }
        }
        return result;
    }
}
