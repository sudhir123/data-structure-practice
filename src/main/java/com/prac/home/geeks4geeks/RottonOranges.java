package com.prac.home.geeks4geeks;

import java.util.*;

public class RottonOranges {
    public static void main(String[] args) {
        RottonOranges r=new RottonOranges();

        System.out.println(r.orangesRotting(new int[][]
                {
                        {2,0,1,1,1,1,1,1,1,1},
                        {1,0,1,0,0,0,0,0,0,1},
                        {1,0,1,0,1,1,1,1,0,1},
                        {1,0,1,0,1,0,0,1,0,1},
                        {1,0,1,0,1,0,0,1,0,1},
                        {1,0,1,0,1,1,0,1,0,1},
                        {1,0,1,0,0,0,0,1,0,1},
                        {1,0,1,1,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1}
                }
        ));
    }
    static class Node{
        int time;
        String position;
        Node(int time, String position){
            this.time= time;
            this.position= position;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Node> queue= new LinkedList<>();
        for (int row=0; row<grid.length; row++){
            for (int col=0; col< grid[0].length; col++){
                if (grid[row][col]==2){
                    queue.add(new Node(0, row+"-"+col));
                }
            }
        }
        int finalTime=0;
        while (!queue.isEmpty()){
            Node node= queue.poll();
            String pos= node.position;
            int time = node.time;
            finalTime=time;
            int row = Integer.parseInt(pos.split("-")[0]);
            int col = Integer.parseInt(pos.split("-")[1]);
            checkNearCoordinates(grid, row, col, queue, time);
        }

        for (int row=0; row<grid.length; row++){
            for (int col=0; col< grid[0].length; col++){
                if (grid[row][col]==1){
                    return -1;
                }
            }
        }
        return finalTime;
    }

    void checkNearCoordinates(int[][] grid, int row, int col, Queue<Node> queue, int time){
        if (row-1 >=0){
            if (grid[row-1][col]==1){
                grid[row-1][col]=2;
                queue.add(new Node(time+1, (row-1)+"-"+col));
            }
        }
        if (row+1 < grid.length){
            if (grid[row+1][col]==1){
                grid[row+1][col]=2;
                queue.add(new Node(time+1, (row+1)+"-"+col));
            }
        }

        if (col-1 >=0){
            if (grid[row][col-1]==1){
                grid[row][col-1]=2;
                queue.add(new Node(time+1, (row)+"-"+(col-1)));
            }
        }
        if (col+1 < grid[0].length){
            if (grid[row][col+1]==1){
                grid[row][col+1]=2;
                queue.add(new Node(time+1, (row)+"-"+(col+1)));
            }
        }
    }
}























