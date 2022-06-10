package com.prac.home.practice;

// start from 0,0 and to reach to x,y

import java.util.*;

/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/discuss/764266/knight-walk-problem-depth-first-search-minimum-moves-by-knight
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 * https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
 */
public class MinimumKnightMoves {
    public static void main(String[] args) {
        MinimumKnightMoves m = new MinimumKnightMoves();
        System.out.println(m.miniKnightMoves(5,5));
    }
    static class Coordinate{
        int x; int y;
        int steps;
        Coordinate(int x, int y, int steps){
            this.x= x;
            this.y=y;
            this.steps= steps;
        }
    }
    public double miniKnightMoves(int x, int y) {
        Set<String > visited = new HashSet<>();
        return moves(0,0,x,y,  visited);
    }
    public double moves(int currX, int currY, int targetX, int targetY,  Set<String > visited){
        Queue<Coordinate> queue= new LinkedList<>();
        queue.add(new Coordinate(currX, currY, 0));
        visited.add(currX+"-"+currY);
        while (!queue.isEmpty()){
            Coordinate coordinate= queue.poll();
            if (coordinate.x==targetX && coordinate.y== targetY){
                return coordinate.steps;
            }
            possibleCoordinates(coordinate, queue, visited);
        }
        return -1;
    }

    public void possibleCoordinates(Coordinate coordinate, Queue<Coordinate> queue, Set<String > visited){
        int x = coordinate.x;
        int y= coordinate.y;
        int steps = coordinate.steps;
        if (!visited.contains((x+2)+"-"+(y-1)))
            queue.add(new Coordinate(x+2, y-1,steps+1));
        if (!visited.contains((x+2)+"-"+(y+1)))
            queue.add(new Coordinate(x+2, y+1,steps+1));
        if (!visited.contains((x-2)+"-"+(y-1)))
            queue.add(new Coordinate(x-2, y-1,steps+1));
        if (!visited.contains((x-2)+"-"+(y+1)))
            queue.add(new Coordinate(x-2, y+1,steps+1));
        if (!visited.contains((x+1)+"-"+(y+2)))
            queue.add(new Coordinate(x+1, y+2,steps+1));
        if (!visited.contains((x-1)+"-"+(y-2)))
            queue.add(new Coordinate(x-1, y-2,steps+1));
        if (!visited.contains((x+1)+"-"+(y+2)))
            queue.add(new Coordinate(x+1, y+2,steps+1));
        if (!visited.contains((x-1)+"-"+(y-2)))
            queue.add(new Coordinate(x-1, y-2,steps+1));

    }
}


















