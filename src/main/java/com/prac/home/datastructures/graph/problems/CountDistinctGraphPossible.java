package com.prac.home.datastructures.graph.problems;

import javax.imageio.ImageTranscoder;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * somehow get all unique nodes in a list. and start iterating through them.
 * visit and node and make it as visited. and traverse all possible nodes and marked each one visited. At end increase counter.
 * Go to the next iteration from main. if node is not visited and start traversing and at end increase counter.
 */
public class CountDistinctGraphPossible {

    LinkedList<Integer> linkedList[];
    Set<Integer> set;
    Integer counter=0;

    CountDistinctGraphPossible(int size){
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
                counter++;
                visitGraphPossibleNodes(x,booleans);
            }

        });
    }

    public void visitGraphPossibleNodes(Integer node, boolean[] booleans){

        Stack<Integer> s= new Stack();
        s.push(node);
        while (!s.isEmpty()) {
            Integer current = s.pop();
            if (!booleans[current]) {

                booleans[current] = true;
                LinkedList list = linkedList[current];
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    s.push(it.next());
                }
            }
        }
    }

    public static void main(String[] args) {
        CountDistinctGraphPossible g = new CountDistinctGraphPossible(8);
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
        System.out.println(g.counter);
    }
}
