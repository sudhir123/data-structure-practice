package com.prac.home.datastructures.graph.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * json-> { f:[g,i], g:[h] , h:[], i:[g,k], j:[i], k:[] }
 * draw a node and figure out if there is a path exist between source node and estination node
 * any depth or breadth can solve the problem. write method that return true if path exists else false.
 * consider it as non cyclic , means we don't need to think of boolean array to check if node is already visited
 * DepthFirstSearch with stack that is without recursive
 */
public class HasAPathProblem {

    LinkedList<Character>[] graph ;

    HasAPathProblem(){
        graph= new LinkedList[122];
        IntStream.range(0,122).forEach(x-> {
            graph[x] = new LinkedList<>();
        });
    }

    public static void main(String[] args) {
        HasAPathProblem g = new HasAPathProblem();
        // add edge
        g.addEdge('f', 'g');
        g.addEdge('f', 'i');
        g.addEdge('g', 'h');
        g.addEdge('i', 'g');
        g.addEdge('i', 'k');
        g.addEdge('j', 'i');


        System.out.println( g.pathExistsStack('f','l'));
    }

    public void addEdge(Character arrayIndex, Character val){
        //System.out.println("(int)arrayIndex--> "+ (int)arrayIndex);
        graph[(int)arrayIndex].add(val);
    }

    public boolean pathExistsStack(Character source, Character destination){
        boolean exists=false;

        Stack<Character>stack = new Stack();
        stack.push(source);

        while (!stack.isEmpty()){
            Character character= stack.pop();
            LinkedList linkedList = graph[(int)character];
            Iterator<Character> iterator= linkedList.iterator();

            while (iterator.hasNext()){
                Character next = iterator.next();
                if (next.equals(destination)){
                    return true;
                }
                stack.push(next);
            }
        }
        return exists;
    }

    /*public boolean pathExistsRecurssion(Character source, Character destination){

    }*/
}
