package com.prac.home.datastructures.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * it uses stack
 * go it in one direction before changing any direction , must be using recursive prog
 */
public class DepthFirstSearchUsesRecursivelyLinkedListArray {

    int sizeOfArray=0;
    LinkedList<Integer> linkedListArray[];

    public static void main(String[] args) {

        DepthFirstSearchUsesRecursivelyLinkedListArray g = new DepthFirstSearchUsesRecursivelyLinkedListArray(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);


       /* g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);*/


        g.DFS();
    }

    // intialize
    // array of linkedlist
    DepthFirstSearchUsesRecursivelyLinkedListArray(int sizeOfArray ){
        this.sizeOfArray=sizeOfArray;
        linkedListArray= new LinkedList[sizeOfArray];
        IntStream.range(0,sizeOfArray).forEach(x-> {
            linkedListArray[x] = new LinkedList<>();
        });
    }

    // add edge that is node with value
    public void addEdge(Integer arrayIndex, Integer val){
        linkedListArray[arrayIndex].add(val);
    }

    public void DFS(){
        boolean visited[] = new boolean[sizeOfArray];
        for (int i = 0; i < sizeOfArray; ++i)
            if (visited[i] == false)
                traverseGraph(i, visited);
    }

    // traverse the graph completely
    public void traverseGraph(int val, boolean[] bolArr){
        System.out.print(val+" " );
        LinkedList list = linkedListArray[val];
        bolArr[val]= true;
        Iterator<Integer> it= list.iterator();
        while (it.hasNext()){
            Integer valueInLinkedList= it.next();
            if(!bolArr[valueInLinkedList])
                traverseGraph(valueInLinkedList, bolArr);
        }

    }

}
