package com.prac.home.practice;

import java.util.HashSet;
import java.util.Set;

/**
 *  1 as land and 0 as wate. return number of islands
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count=0;
        Set<String> visited= new HashSet<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (island(grid, row, col, visited)) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean island(char[][] grid, int row, int col, Set<String> visited){
        if (row <0 || row> grid.length-1) return false;
        if (col <0 || col > grid[0].length-1) return false;
        if (grid[row][col]=='0') return false;
        if (visited.contains(row+"-"+col)) return false;

        if (grid[row][col]=='1'){
            visited.add(row+"-"+col);
        }

        island(grid, row, col+1, visited) ;
        island(grid, row, col-1, visited) ;
        island(grid, row+1, col, visited) ;
        island(grid, row-1, col, visited);
        return true;
    }
}
