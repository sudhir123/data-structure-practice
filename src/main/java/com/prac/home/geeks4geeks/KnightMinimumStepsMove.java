package com.prac.home.geeks4geeks;

import java.awt.*;
import java.util.*;
import java.util.List;

public class KnightMinimumStepsMove {
    static int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
    static int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
    public static void main(String[] args) {
        KnightMinimumStepsMove m = new KnightMinimumStepsMove();

        System.out.println(m.minStepToReachTarget(new int[]{1,1}, new int[]{7,5}, 7));
    }
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N){
        Set<String> visited = new HashSet<>();
        return minStepToReach(KnightPos, TargetPos, N,visited);
    }
    public int minStepToReach(int[] currentPos, int[] targetPos, int n, Set<String> visited){
        Queue<Point> mainStack= new LinkedList<>();
        Queue<Point> intrimStack= new LinkedList<>();
        mainStack.add(new Point(currentPos[0], currentPos[1],0 ));

        while (!mainStack.isEmpty()){
            Point p= mainStack.poll();
            if (p.x==targetPos[0] && p.y==targetPos[1]){
                return p.steps;
            }
            nextPoints(p, visited, n, mainStack);
        }
        return -1;
    }

    public void nextPoints(Point t , Set<String> visited, int bound,Queue<Point> q){
        int x,y;
        for (int i = 0; i < 8; i++) {
            x = t.x + dx[i];
            y = t.y + dy[i];

            // If reachable state is not yet visited and
            // inside board, push that state into queue
            if (isInside(x, y, bound) && !visited.contains(x+"-"+y)) {
                visited.add(x+"-"+y) ;
                q.add(new Point(x, y, t.steps + 1));
            }
        }
    }
    static boolean isInside(int x, int y, int N)
    {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }
    static class Point{
        int x;
        int y;
        int steps;
        Point(int x, int y, int steps){
            this.x=x;
            this.y=y;
            this.steps= steps;
        }
    }
}
