package com.prac.home.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();

        System.out.println(m.maxAreaOfIsland(new int[][]{
               {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}

        }));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland=0;
        Set<String> visited= new HashSet<>();
        for (int row=0; row< grid.length; row++){
            for (int col=0; col< grid[0].length; col++){
                if (grid[row][col]==1 && !visited.contains(row+"-"+col)){
                    maxIsland= Math.max(maxIsland, maxArea(grid, row, col, visited));
                }
            }
        }
        return maxIsland;
    }

    public int maxArea(int[][] grid, int row, int col, Set<String> visited) {
        if (row<0 || row>= grid.length || col<0 || col>= grid[0].length){
            return 0;
        }
        if (visited.contains(row+"-"+col)){
            return 0;
        }
        if (grid[row][col]!=1){
            return 0;
        }
        visited.add(row+"-"+col);
        int length=1;
        length+= maxArea(grid, row+1, col, visited)
                + maxArea(grid, row-1, col, visited)
                + maxArea(grid, row, col+1, visited)
                + maxArea(grid, row, col-1, visited);
        return length;
    }
}
