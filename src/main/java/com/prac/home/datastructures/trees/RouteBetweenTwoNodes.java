package com.prac.home.datastructures.trees;

import java.sql.Struct;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Given directed directed graph. Find if route between two nodes. BreadthFirstSearch or DepthFirstSearch
 */
public class RouteBetweenTwoNodes {

    LinkedList<Integer>[] linkedLists;

    RouteBetweenTwoNodes(int size){
        linkedLists= new LinkedList[size];
        IntStream.range(0,size).forEach(x->{
            linkedLists[x]= new LinkedList<>();
        });
    }

    void addNode(int offset, int data){
        linkedLists[offset].add(data);
    }

    // DFS
    void DFS(int source, int destination){
        boolean[] visited=new boolean[linkedLists.length];
        //System.out.println(traverse(source,destination, visited));
        System.out.println(traverseWithRecursion(source,destination,visited));
    }

    boolean traverseWithRecursion(int source, int dest, boolean[] visited){
        LinkedList<Integer>linkedList = linkedLists[source];
        if (visited[source]) return false;
        if(linkedList==null || linkedList.isEmpty()) return false;

        boolean val=false;
        visited[source]=true;
        System.out.print(source +" ");
        for (Integer i : linkedList) {
            if(i==dest) return true;
            val= traverseWithRecursion(i, dest, visited);
            if (val) break;
        }
        return val;
    }

    boolean traverse(int source, int dest, boolean[] visited){
        Stack<Integer> stack=new Stack<>();
        stack.push(source);
        visited[source]=true;
        while (!stack.isEmpty()){
            int val = stack.pop();
            System.out.println(val);
            LinkedList<Integer> list = linkedLists[val];
            for (Integer i :
                 list) {

                if(i==dest) return true;
                if (!visited[i]){
                    stack.push(i);
                    visited[i]=true;
                }

            }
        }
        return false;
    }
    // Bredth First Search. Done using queue , which is basically LinkedList
    void BFS(int source, int destination){
        boolean[] visited = new boolean[linkedLists.length];
        System.out.println(traverseBFS(source, destination, visited));
    }

    boolean traverseBFS(int start , int end, boolean[] visited){

        if (start==end) return true;
        Queue<Integer> queue= new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            Integer val = queue.poll();
            visited[val]=true;
            System.out.print(val+" ");
            Iterator<Integer> it = linkedLists[val].iterator();
            while (it.hasNext()){
                Integer next = it.next();
                if(next==end) return true;
                if(!visited[next])
                    queue.add(next);
            }
        }
        return false;
    }

    boolean traverseBFSRecursion(int start , int end, boolean[] visited, Queue<Integer> queue){
        // not a good idea end up in DFS
        return false;
    }

    public static void main(String[] args) {
        RouteBetweenTwoNodes r = new RouteBetweenTwoNodes(7);
        r.addNode(0,1);
        r.addNode(0,2);
        r.addNode(1,3);
        r.addNode(3,2);
        r.addNode(2,4);
        r.addNode(2,6);
        r.addNode(6,7);
        r.addNode(4,5);
        r.DFS(0,7);
        r.BFS(0,7);
    }
}
