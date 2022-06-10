package com.prac.home.datastructures.graph.problems;

import java.util.*;

/**
 * basically in graph we have some land and some water. we need to find how many islands that Land area possible.
 * that means we similar problem ..fins how many possible graphs
 * Over here we have two-D matrix, kinda chess board. each block is represented by x,y.
 * Only trick is to convert this as a directed graph. so here is some solution. each block has 4 possible connections.
 * Up down right and left. for up x,y -->  (x-1, y), for down (x+1,y), , for left (x,y-1) and for right (x, y+1)
 */
public class IslandPossibleCountProblem {

    public static void main(String[] args) {
        IslandPossibleCountProblem i = new IslandPossibleCountProblem();
        /*char[][] arr =new char[1][2];
        arr[0][0]='1';
        arr[0][1]='1';*/
        char[][] arr = new char[4][5];

        arr[0][0] = '1';
        arr[0][1] = '1';
        arr[0][2] = '0';
        arr[0][3] = '0';
        arr[0][4] = '0';

        arr[1][0] = '1';
        arr[1][1] = '1';
        arr[1][2] = '0';
        arr[1][3] = '0';
        arr[1][4] = '0';

        arr[2][0] = '0';
        arr[2][1] = '0';
        arr[2][2] = '1';
        arr[2][3] = '0';
        arr[2][4] = '0';

        arr[3][0] = '0';
        arr[3][1] = '0';
        arr[3][2] = '0';
        arr[3][3] = '1';
        arr[3][4] = '1';

        System.out.println(i.numIslands(arr));

    }
    // with  Set -> solution is taking more time
    // with array it is acceptable
    public int numIslands(char[][] grid){
        int counter=0;
        for(int r =0; r<grid.length; r++){
            for(int c =0; c<grid[0].length; c++) {
                if(grid[r][c]=='X') {
                    if (explore(grid, r, c)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public boolean explore(char[][] grid, int r, int c) {
        if(r<0 || r>= grid.length) return false;
        if(c <0 || c>= grid[0].length) return false;
        if (grid[r][c]=='0') return false;
        if (grid[r][c]!='X') return false;

        grid[r][c]='Y';

        explore(grid, r-1,c);
        explore(grid, r+1,c);
        explore(grid, r,c-1);
        explore(grid, r,c+1);
        return true;
    }

    /*public int numIslands(char[][] grid) {
        Set set = new HashSet();
        int counter=0;
        for(int r =0; r<grid.length; r++){
            for(int c =0; c<grid[0].length; c++) {
                if(explore(grid, r, c,set )){
                    counter++;
                    //System.out.println(counter);
                };
            }
        }
        return counter;
    }

    public boolean explore(char[][] grid, int r, int c, Set visited) {
        if(r<0 || r>= grid.length) return false;
        if(c <0 || c>= grid[0].length) return false;
        if (grid[r][c]=='0') return false;

        String pos= r+","+c;
        if (visited.contains(pos)) return false;

        visited.add(pos);

        explore(grid, r-1,c,visited);
        explore(grid, r+1,c,visited);
        explore(grid, r,c-1,visited);
        explore(grid, r,c+1,visited);
        return true;
    }
*/
}
