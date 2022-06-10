package com.prac.home.datastructures.graph.problems;

import java.util.*;
import java.util.stream.IntStream;

public class GraphWithMaximumNodes {

    LinkedList<Integer> linkedList[];
    Set<Integer> set;

    GraphWithMaximumNodes(int size){
        linkedList=new LinkedList[size];
        IntStream.range(0,size).forEach(x->{
            linkedList[x]= new LinkedList<>();
        });

    }
    public void addEdge(int offset, int val){
        linkedList[offset].add(val);
    }

    public void DFS(){
        set= new HashSet<>();
        for (List list:
                linkedList) {
            if(list!=null && !list.isEmpty())
                set.addAll(list);
        }
        //set= Arrays.stream(linkedList).flatMap(List::stream).collect(Collectors.toSet());
        boolean[] booleans= new boolean[8];
        set.forEach(x->{
            if(!booleans[x]){
                System.out.println(visitGraphPossibleNodes(x,booleans));
            }
        });
    }

    public Integer visitGraphPossibleNodes(Integer node, boolean[] booleans){
        Integer counter=0;
        Stack<Integer> s= new Stack();
        s.push(node);
        while (!s.isEmpty()) {
            Integer current = s.pop();
            if (!booleans[current]) {
                booleans[current] = true;
                counter++;
                LinkedList list = linkedList[current];
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    s.push(it.next());
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        GraphWithMaximumNodes g = new GraphWithMaximumNodes(8);
        g.addEdge(0, 0);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4,5);
        g.addEdge(4,4);
        g.addEdge(5,5);
        g.addEdge(6,6);
        g.addEdge(7,7);
        g.addEdge(6,7);
        g.DFS();
    }
}
