package com.prac.home.algoexpert.medium;

import java.util.*;

public class BredthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()){
                Node element= queue.poll();
                array.add(element.name);
                queue.addAll(element.children);
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        Node a = new Node("A");
        a.children = new ArrayList<>();

        Node b = new Node("B");
        b.children = new ArrayList<>();
        Node e = new Node("E");
        Node f = new Node("F");
        f.children = new ArrayList<>();
        Node i = new Node("I");
        Node j = new Node("J");
        f.children.add(i);
        f.children.add(j);

        b.children.add(e);
        b.children.add(f);

        Node c = new Node("C");

        Node d = new Node("D");
        d.children = new ArrayList<>();

        d.addChild("G");
        d.addChild("H");

        Node g = d.children.get(0);
        g.addChild("k");
        a.children.add(b);
        a.children.add(c);
        a.children.add(d);

        a.breadthFirstSearch(new ArrayList<>());
    }
}
