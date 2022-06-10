package com.prac.home.algoexpert.hard;

import java.util.*;

public class MinimumAreaRectangle {
    public static void main(String[] args) {
        MinimumAreaRectangle m = new MinimumAreaRectangle();
        System.out.println(m.minimumAreaRectangle(new int[][]{
                {0, 1},{0, 0},{2, 1},{2, 0},{4, 0},{4, 1},{0, 2},{2, 2},{4, 2},{6, 0},{6, 1},{6, 2},{7, 1},{7, 0}
        }));
    }
    public int minimumAreaRectangle(int[][] points) {
        return meth1(points);
    }

    // #mythinking--> no working ...so going by algoexpert.
    public int meth1(int[][] points){
        int minArea=Integer.MAX_VALUE;;
        Map<Integer,List<Integer>> xAxisMap=new HashMap<>();
        Map<String, Integer> edges = new HashMap<>();

        for (int i=0; i < points.length; i++){
            int x=points[i][0];
            int y=points[i][1];
            if (xAxisMap.containsKey(x)){
                List<Integer> list = xAxisMap.get(x);
                list.add(y);
                xAxisMap.put(x, list);
            }else {
                List<Integer> list =new ArrayList<>();
                list.add(y);
                xAxisMap.put(x, list);
            }
        }

        for (Integer x: xAxisMap.keySet()
             ) {
                List<Integer> yPoints = xAxisMap.get(x);
                Collections.sort(yPoints);
            for (int i=1; i< yPoints.size(); i++){
                for (int j=0; j<i; j++){
                    String keyEdge = yPoints.get(i)+""+yPoints.get(j);
                    if (edges.containsKey(keyEdge)){
                        // area calculation
                        int length = Math.abs(yPoints.get(i)-yPoints.get(j) );
                        int breadth = Math.abs(edges.get(keyEdge)-x);
                        minArea= Math.min(minArea, length*breadth);
                    }
                        edges.put(keyEdge, x);
                }
            }
        }

        return minArea!=Integer.MAX_VALUE?minArea:0;
    }

    public int distance(int[] p1, int[] p2, int[] p3){
        int length = Math.abs(p1[0]- p2[0]);
        int breadth = Math.abs(p1[0]- p3[1]);
        return length*breadth;
    }
}
