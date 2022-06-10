package com.prac.home.geeks4geeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        ArrayList<Integer> l1= new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(4);
        adj.add(l1);
        ArrayList<Integer> l4= new ArrayList<>();
        l4.add(3);
        adj.add(l4);
        DFS d = new DFS();
        System.out.println(d.dfsOfGraph(5, adj));
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(adj, result, visited, 0);
        return result;
    }

    public void dfs( ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, Set<Integer> visited, Integer vertex) {
        if (visited.contains(vertex)) return;
        if (vertex==null) return;
        visited.add(vertex);
        result.add(vertex);
        ArrayList<Integer> list = adj.get(vertex);
        for (Integer ver: list
        ) {
            dfs(adj, result, visited, ver);
        }
    }
}
