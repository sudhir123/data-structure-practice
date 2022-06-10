package com.prac.home.datastructures.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * it uses stack
 * go it in one direction before changing any direction , must be using recursive prog
 */
public class DepthFirstSearchUsesStackNonRecurssive {

    int sizeOfArray=0;
    LinkedList<Integer> linkedListArray[];

    public static void main(String[] args) {

        DepthFirstSearchUsesStackNonRecurssive g = new DepthFirstSearchUsesStackNonRecurssive(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        g.DFS();
    }

    // intialize
    // array of linkedlist
    DepthFirstSearchUsesStackNonRecurssive(int sizeOfArray ){
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
        traverseGraph(0, visited);
    }

    // traverse the graph completely
    public void traverseGraph(int val, boolean[] bolArr){

        Stack<Integer> stack= new Stack<>();

        stack.push(val);

        while(!stack.isEmpty()){

            Integer i =stack.peek();
            stack.pop();

            if (!bolArr[i]){
                System.out.print(i+" " );
                bolArr[i]=true;
            }


            Iterator<Integer> it= linkedListArray[i].iterator();
            while (it.hasNext()){
                Integer valueInLinkedList= it.next();
                if(!bolArr[valueInLinkedList])
                    stack.push(valueInLinkedList);
            }
        }
    }

}
