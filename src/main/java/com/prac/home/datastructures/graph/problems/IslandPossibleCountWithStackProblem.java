package com.prac.home.datastructures.graph.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * basically in graph we have some land and some water. we need to find how many islands that Land area possible.
 * that means we similar problem ..fins how many possible graphs
 * Over here we have two-D matrix, kinda chess board. each block is represented by x,y.
 * Only trick is to convert this as a directed graph. so here is some solution. each block has 4 possible connections.
 * Up down right and left. for up x,y -->  (x-1, y), for down (x+1,y), , for left (x,y-1) and for right (x, y+1)
 */
public class IslandPossibleCountWithStackProblem {

    public static void main(String[] args) {
        IslandPossibleCountWithStackProblem i = new IslandPossibleCountWithStackProblem();
        /*char[][] arr =new char[1][2];
        arr[0][0]='1';
        arr[0][1]='1';*/
        /*char[][] arr =new char[4][5];
        arr[0][0]='1';
        arr[0][1]='1';
        arr[0][2]='0';
        arr[0][3]='0';
        arr[0][4]='0';

        arr[1][0]='1';
        arr[1][1]='1';
        arr[1][2]='0';
        arr[1][3]='0';
        arr[1][4]='0';

        arr[2][0]='0';
        arr[2][1]='0';
        arr[2][2]='1';
        arr[2][3]='0';
        arr[2][4]='0';

        arr[3][0]='0';
        arr[3][1]='0';
        arr[3][2]='0';
        arr[3][3]='1';
        arr[3][4]='1';*/

        char[][] arr = new char[3][3];
        arr[0][0] = 'X';
        arr[0][1] = 'O';
        arr[0][2] = 'X';

        arr[1][0] = 'O';
        arr[1][1] = 'X';
        arr[1][2] = 'O';

        arr[2][0] = 'X';
        arr[2][1] = 'X';
        arr[2][2] = 'X';

        //printMatrix(arr);
        System.out.println(i.numIslands(arr));

    }

    public static void printMatrix(char[][] arr) {
        int row = 0;
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (row == r) {
                    if (c == arr[0].length - 1)
                        System.out.print(arr[r][c]);
                    else
                        System.out.print(arr[r][c] + ", ");
                } else {
                    row = r;
                    System.out.print("\n" + arr[r][c] + ", ");
                }
            }
        }

    }

    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet();
        Integer numberOfIslands = 0;
        List<Integer> l = new ArrayList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                String pos = r + "," + c;
                if (grid[r][c] != 'O') {
                    l.add(explore(grid, r, c, visited));
                } else {
                    visited.add(pos);
                }
            }
        }
        //System.out.println("\n"+l.stream().filter(x-> !x.equals(0)).collect(Collectors.toList()));
        //numberOfIslands = l.stream().filter(x -> !x.equals(0)).collect(Collectors.toList()).stream().count();
        for (Integer i :
             l) {
            if(i!=0){
                numberOfIslands= numberOfIslands+1;
            }

        }
        //System.out.println(numberOfIslands);
        return numberOfIslands;
    }

    public int explore(char[][] grid, int r, int c, Set visited) {
        String pos = r + "," + c;
        Stack stack = new Stack();
        stack.push(pos);

        int couter = 0;

        while (!stack.isEmpty()) {

            pos = (String) stack.pop();
            String[] strArr = pos.split(",");
            r = Integer.parseInt(strArr[0]);
            c = Integer.parseInt(strArr[1]);

            if (r < 0 || r >= grid.length) continue;
            if (c < 0 || c >= grid[0].length) continue;
            if (grid[r][c] == 'O') continue;
            if (visited.contains(pos)) continue;

            visited.add(pos);
            couter = couter + 1;

            pos = (r - 1) + "," + c;
            stack.push(pos);

            pos = r + 1 + "," + c;
            stack.push(pos);

            pos = r + "," + (c - 1);
            stack.push(pos);

            pos = r + "," + (c + 1);
            stack.push(pos);
        }


        //System.out.print("\n"+couter);
        return couter;
    }
}
