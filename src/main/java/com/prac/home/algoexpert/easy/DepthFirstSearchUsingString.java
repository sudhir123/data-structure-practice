package com.prac.home.algoexpert.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * give a node , which has name and array of optional children nodes. Not cyclic tree structure. Traverse the tree and stores
 * the nodes in an array, and returns it
 */
public class DepthFirstSearchUsingString {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }
        /*public List<String> depthFirstSearch(List<String> array) {
            Stack<Node> stack= new Stack<>();
            stack.push(this);

            while (!stack.isEmpty()){
                Node node= stack.pop();
                array.add(node.name);
                for (int i = node.children.size()-1; i >=0; i--){
                    stack.push(node.children.get(i));
                }
            }
            return array;
        }*/

        // using recursion
        public List<String> depthFirstSearch(List<String> array){
            array.add(name);
            for (int i =0; i < children.size(); i++){
                children.get(i).depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
