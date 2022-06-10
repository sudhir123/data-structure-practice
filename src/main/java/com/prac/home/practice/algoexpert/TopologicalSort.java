package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph= createJobGraph(jobs, deps);

        return executeOrders(graph);

    }

    static List<Integer> executeOrders(JobGraph graph){
        List<Integer> jobOrder = new ArrayList<>();
        List<JobNode> copyOfNodes = new ArrayList<>(graph.jobNodes);
        for (JobNode job: copyOfNodes
             ) {
            copyOfNodes.remove(job);
            boolean visiting= dfs(job, jobOrder);
            if (!visiting) return new ArrayList<>();
        }
        return jobOrder;
    }

    static boolean dfs(JobNode jobNode, List<Integer> orders){
        if (jobNode.visited) return true;
        if (jobNode.inProgress) return false;
        List<JobNode> preReqs= jobNode.preReq;
        for (JobNode req: preReqs
             ) {
            boolean visiting= dfs(req, orders);
            if (!visiting) return false;
        }
        jobNode.visited=true;
        jobNode.inProgress=false;
        orders.add(jobNode.job);
        return true;
    }


    static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps){
        JobGraph jobGraph= new JobGraph(jobs);
        for (Integer[] dep: deps
             ) {
            jobGraph.addPreReq(dep[1], dep[0]);
        }
        return jobGraph;
    }



    static class JobNode{
        Integer job;
        List<JobNode> preReq;
        boolean visited;
        boolean inProgress;
        JobNode(Integer job){
            this.job= job;
            this.preReq= new ArrayList<>();
        }
    }

    static class JobGraph{
        List<JobNode> jobNodes;
        Map<Integer, JobNode> graph;

        JobGraph(List<Integer> jobs){
            jobNodes= new ArrayList<>();
            graph= new HashMap<>();
            for (Integer job: jobs
                 ) {
                addNode(job);
            }
        }

        void addNode(Integer value){
            JobNode job= new JobNode(value);
            jobNodes.add(job);
            graph.put(value, job);
        }

        JobNode getNode(Integer job){
            if (!graph.containsKey(job)) addNode(job);
            return graph.get(job);
        }

        void addPreReq(Integer job, Integer preReq){
            JobNode jobNode= getNode(job);
            JobNode preReqNode = getNode(preReq);
            jobNode.preReq.add(preReqNode);
        }
    }
}




























