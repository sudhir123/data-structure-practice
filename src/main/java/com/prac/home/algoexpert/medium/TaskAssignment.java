package com.prac.home.algoexpert.medium;

import java.util.*;
/**
 * you will given number of workers as k and list of tasks' duration. workers need to complete each task
 * one worker can work at one task at a time. and max worker can work on two tasks. Basically we write a function that will
 * retuen tasks assigned to each work. only condition is sum of maximum duration should be minimum.
 *
 */
public class TaskAssignment {

    static public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        Map<Integer, Queue<Integer>> valueIdx= new HashMap<>();
        for (int i=0; i < tasks.size(); i ++){
            System.out.println(tasks.get(i));
            if (valueIdx.get(tasks.get(i))!=null){
                Queue<Integer> listOfIndexs = valueIdx.get(tasks.get(i));
                listOfIndexs.add(i);
                valueIdx.put(tasks.get(i), listOfIndexs);
            }else {
                Queue<Integer> listOfIndexs= new LinkedList<>();
                listOfIndexs.add(i);
                valueIdx.put(tasks.get(i), listOfIndexs);
            }
        }
        Collections.sort(tasks);
        ArrayList a = new ArrayList();
        for (int i =0, j =tasks.size()-1; i <j; i++ ,j--){
            ArrayList<Integer> b =new ArrayList();
            b.add(valueIdx.get(tasks.get(i)).poll());
            b.add(valueIdx.get(tasks.get(j)).poll());
            a.add(b);
        }

        return a ;
    }

    public static void main(String[] args) {
        ArrayList<Integer> tasks=new   ArrayList<Integer> ();
        tasks.addAll(Arrays.asList(1, 3, 5, 3, 1, 4));
        System.out.println(taskAssignment(3,tasks ));
    }

}
