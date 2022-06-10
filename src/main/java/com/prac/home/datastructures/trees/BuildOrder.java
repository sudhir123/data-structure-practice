package com.prac.home.datastructures.trees;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class BuildOrder {
    String [] allProjects= {"a","b","c","d","f"};
    String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}}; // second is dependent on first

    public static void main(String[] args) {
        BuildOrder b= new BuildOrder();
        Project[] p= b.findBuildOrder(b.allProjects, b.dependencies);
        for (int i =0; i< p.length; i++){
            System.out.print (p[i].name+" ");
        }
    }

    Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies) ;
        return orderProjects(graph.getNodes());
    }
    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.createNode(project);
        }
        for (String[] dependency: dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    Project[] orderProjects(List<Project> projects) {
        Project[] order = new Project[projects.size()] ;

        int endOfList = addNonDependent(order, projects, 0);
        int toBeProcessed = 0;
        while (toBeProcessed < order . length) {
            Project current = order[toBeProcessed];
            if (current == null) {
                return null;
            }
            List<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    int addNonDependent(Project[] order, List<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    @Getter
    @Setter
    static class Graph {
        private List<Project> nodes = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();

        public void createNode(String name) {
            if (!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }
        }

        void addEdge(String name, String name2){
            if (!map.containsKey(name)) {
                Project node = new Project(name);
                node.addNeighbor(new Project(name2));
                map.put(name, node);
            }else{
                map.get(name).addNeighbor(map.get(name2));
            }
        }
    }

    @Getter@Setter
    static class Project {
        private List<Project> children = new ArrayList<Project>();
        private String name;
        private int dependencies=0;
        public Project(String n) {this.name =n;}

        public void addNeighbor(Project node) {
                children.add(node) ;
                node.incrementDependencies();
        }
        public void incrementDependencies() { dependencies++; }
        public void decrementDependencies() { dependencies --; }

        public List<Project> getChildren() { return children; }
        public int getNumberDependencies() { return dependencies; }

    }
}


