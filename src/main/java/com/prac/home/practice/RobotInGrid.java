package com.prac.home.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * #Array
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
 * the bottom right.
 */
public class RobotInGrid {
    static class Point{
        int row;
        int col;
        public Point(int row, int col){
            this.row= row;
            this.col= col;
        }
    }
    // #myunderstanding -book says moves from last, last to 0,0
    // O(2^ r+c)  at every point we have two choices and r+c paths
    // this can simply be improved just by tracking i/e HashSet<Points> visited added to algo.

    static List<Point> path( boolean[][] maze){
        List<Point>points = new ArrayList<>();
        pathPoint(maze, maze.length-1, maze[0].length-1,points );
        return points;
    }
    static boolean pathPoint( boolean[][] maze, int row, int col, List<Point>points){
        if (row <0 || col<0 || !maze[row][col]) return false;
        boolean atOrigin = row==0 && col==0 ;
        //System.out.println("row -> "+ row+"  && col--> "+ col);
        //points.add(new Point(row,col));

        if (atOrigin || pathPoint(maze, row-1, col, points)  || pathPoint(maze, row, col-1, points)){
            System.out.println("row -> "+ row+"  && col--> "+ col);
            points.add(new Point(row,col));
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Point> points = path(new boolean[][]{
                {true, true, false},
                {false, true, true},
                {false, true, false},
                {true, true, false},
                {true, true, true},

        });
        //points.stream().forEach(x-> System.out.println("row -> "+ x.row+"  && col--> "+ x.col));
    }
}
























