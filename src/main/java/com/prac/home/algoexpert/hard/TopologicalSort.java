package com.prac.home.algoexpert.hard;

import java.util.*;

/**
 * given a list of jobs and list of dependencies. Dependency isa list of integer array where first value if prerequisit for the second one.
 * that means second is dependent on first.
 */
public class TopologicalSort {
    public static void main(String[] args) {
        System.out.println(topologicalSort(Arrays.asList(1, 2, 3, 4),
                Arrays.asList(
                        new Integer[]{1,2},
                        new Integer[]{1,3},
                        new Integer[]{3,2},
                        new Integer[]{4,2},
                        new Integer[]{4,3}

                )));
    }
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph jobGraph= createJobGraph(jobs, deps);
        return executeOrders(jobGraph);
    }

    static List<Integer> executeOrders(JobGraph jobGraph){
        List<Integer> orders = new ArrayList<>();
        List<JobNode> nodes= new ArrayList<>(jobGraph.jobNodes);
        while (nodes.size()>0){
            JobNode jobNode= nodes.get(nodes.size()-1);
            nodes.remove(nodes.size()-1);
            boolean cyc = dfs(jobNode, orders);
            if (cyc) return new ArrayList<>();
        }
        return orders;
    }

    static boolean dfs(JobNode jobNode, List<Integer> orders){
        if (jobNode.visited) return false;
        if (jobNode.visiting) return true;
        jobNode.visiting=true;
        List<JobNode> preReqs= jobNode.preReq;
        for (JobNode preReq: preReqs
             ) {
            boolean cyc =dfs(preReq, orders);
            if (cyc) return true;
        }
        jobNode.visited= true;
        jobNode.visiting=false;
        orders.add(jobNode.job);
        return false;
    }

    static JobGraph createJobGraph(List<Integer> jobs, List< Integer[]> deps){
        JobGraph jobGraph= new JobGraph(jobs);
        for (Integer[] dep : deps
        ) {
            jobGraph.addPreReq(dep[1], dep[0]);
        }
        return jobGraph;
    }
    static class JobGraph{
        public List<JobNode> jobNodes;
        public Map<Integer, JobNode> graph;
        public JobGraph(List<Integer> jobs){
            jobNodes= new ArrayList<>();
            graph= new HashMap<>();
            for (Integer job: jobs
                 ) {
                addNode(job);
            }
        }
        public void addNode(Integer job){
            graph.put(job, new JobNode(job));
            jobNodes.add(graph.get(job));
        }
        public JobNode getNode(Integer job){
            if (!graph.containsKey(job)) addNode(job);
            return graph.get(job);
        }
        public void addPreReq(Integer job, Integer preReq){
            JobNode jobNode= getNode(job);
            JobNode preReqNode = getNode(preReq);
            jobNode.preReq.add(preReqNode);
        }
    }
    static class JobNode{
        public Integer job;
        public List<JobNode> preReq;
        public boolean visited;
        public boolean visiting;
        public JobNode(Integer job) {
            this.job=job;
            preReq= new ArrayList<>();
        }
    }
}

































