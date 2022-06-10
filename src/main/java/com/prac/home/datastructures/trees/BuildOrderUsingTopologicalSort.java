package com.prac.home.datastructures.trees;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * Using DFS
 */
public class BuildOrderUsingTopologicalSort {
    String [] projects= {"a","b","c","d","f"};
    String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}}; // second is dependent on first
    @Getter@Setter
    static class Project{
        public enum State {COMPLETE, PARTIAL, BLANK};
        State state= State.BLANK;
        String name;
        Project(String name){ this.name=name;}
        List<Project> children = new ArrayList<>();
        void addNeighbour(Project dependentProjectName){
            children.add(dependentProjectName);
        }
    }
    @Getter@Setter
    static class Graph{
        List<Project> nodes = new ArrayList<>();
        Map<String, Project> map= new HashMap<>();
        void createNodes(String [] projects){
            for(int i =0; i <projects.length; i++){
                Project node= new Project(projects[i]);
                nodes.add(node);
                map.put(projects[i], node);
            }
        }
        void addEdges(String[][] dependencies){
            for(int i =0; i <dependencies.length; i++){
                String projectName = dependencies[i][0];
                String dependentProjectName = dependencies[i][1];
                Project node = map.get(projectName);
                node.addNeighbour( map.get(dependentProjectName));
            }
        }
    }
    Graph buildGraph(String [] projects){
        Graph g =new Graph();
        g.createNodes(projects);
        g.addEdges(dependencies);
        return g;
    }
    Stack<Project> buildOrder(List<Project> nodes){
        Stack<Project> stack= new Stack<>();
        for (Project project: nodes) {
            if (project.getState()== Project.State.BLANK){
                if (!doDFS(project, stack)) return null; // cyclic
            }
        }
        return stack;
    }

    boolean doDFS(Project project, Stack<Project> stack){
        if (project.getState().equals(Project.State.PARTIAL)) return false;
        if (project.getState()== Project.State.BLANK){
            project.setState(Project.State.PARTIAL);
            for (Project child: project.getChildren()
            ) {
                if(!doDFS(child, stack)) return false;
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }


    public static void main(String[] args) {
        BuildOrderUsingTopologicalSort tp = new BuildOrderUsingTopologicalSort();
        Graph g = tp.buildGraph(tp.projects);
        Stack<Project> st = tp.buildOrder(g.getNodes());
        while (!st.isEmpty()) {
            System.out.print(st.pop().getName());
        }
    }
}





































