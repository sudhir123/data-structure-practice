package com.prac.home.datastructures.graph.problems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * basically it means -> direction is both side if it says [1,j] -> this means in adjency matrix ->{ [i]: [j] , [j]:[i] }
 */

class Edge{
    int node1;
    int node2;

    public Edge(int node1, int node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}
public class UndirectedGraph {

    LinkedList<Integer> linkedList[];

    UndirectedGraph(){
        linkedList= new LinkedList[25];
        IntStream.range(0,25).forEach(x->{ // 26 characters
            linkedList[x]= new LinkedList<>();
        });
    }

    // first is to convert the undirected to directed
    public void convertToDirectedGraph(List<Edge>edgeList){
        for (Edge e :
                edgeList) {
            linkedList[e.node1].add(e.node2);
            linkedList[e.node2].add(e.node1);
        }
    }

    public static void main(String[] args) {
        UndirectedGraph g=new UndirectedGraph();
        List<Edge> l= Arrays.asList(
                new Edge(1,2),
                new Edge(1,3),
                new Edge(1,4),
                new Edge(2,3),
                new Edge(3,4),
                new Edge(3,5),
                new Edge(3,6),
                new Edge(4,7)
                );

        g.convertToDirectedGraph(l);
        /*Arrays.stream(g.linkedList).collect(Collectors.toList()).forEach(x-> {
            System.out.println(x);
        });*/
        boolean[] booleans= new boolean[26];
        System.out.println("Path exists -> "+ g.hasPath( 1,7, booleans));
    }

    public boolean hasPath(  Integer source, Integer destination, boolean[] booleans){
        if(source.equals(destination))
            return true;

        booleans[source]=true;
        List<Integer>list= linkedList[source];
        Iterator it = list.iterator();

        while (it.hasNext()){
            Integer current = (Integer)it.next();
                if (!booleans[current] && hasPath(current,destination,booleans)){
                    return true ;
            }
        }
        return false;
    }
}
