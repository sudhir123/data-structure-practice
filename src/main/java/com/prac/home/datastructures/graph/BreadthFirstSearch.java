package com.prac.home.datastructures.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * queue often used in BFS. Queue FIFO basically means -> add at the back of the queue and remove from the front
 * add first element to queue. check is queue is empty or not. If not then remove the element and add all neighbours
 * in any order. loop the checking.
 */
public class BreadthFirstSearch {
    
    LinkedList linkedList[];

    BreadthFirstSearch(int size){
        linkedList= new LinkedList[size];
        IntStream.range(0, size).forEach(x-> {
            linkedList[x]= new LinkedList();
        });
    }

    public void addEdge(Integer offset, Integer valueOfNode){
        linkedList[offset].add(valueOfNode);
    }

    public void BFSIterative(Integer startNode){

        Queue<Integer> queue= new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()){
            Integer current= queue.poll();
            System.out.println(current);
            Iterator it = linkedList[current].iterator();
            while (it.hasNext()){
                queue.add((Integer) it.next());
            }

        }
    }

    // 0 2 1 4 3 5 6 7
    public void BFSRecursive(LinkedList list, Integer node){
        // not a good idea
        // end up in DFS
    }

    public static void main(String[] args) {
        BreadthFirstSearch b= new BreadthFirstSearch(8);
        b.addEdge(0, 2);
        b.addEdge(0, 1);
        b.addEdge(1, 3);
        b.addEdge(2, 4);
        b.addEdge(1, 5);
        b.addEdge(5, 6);
        b.addEdge(5, 7);

        b.BFSIterative(0);
    }
}
