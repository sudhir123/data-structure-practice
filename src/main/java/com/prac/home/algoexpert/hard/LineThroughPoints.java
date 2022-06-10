package com.prac.home.algoexpert.hard;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LineThroughPoints {
    public static void main(String[] args) {
        LineThroughPoints l = new LineThroughPoints();
        System.out.println(l.lineThroughPoints(new int[][]{
                {1, 4},{4, 1},{1, 1},{4, 4},{2, 3},{3, 2},{3, 3},{2, 2},{0, 3},{5, 3},{3, -1},{2, -3},{1, -5}
        }));
    }
    /*
     Logic :- we need to calculate the slope between two numbers and check if points lies on it. This way we can check max point on a line.
     slope is y2-y1/ x2-x1 ... now we will end up n^3. We can reduce to n^2 --> by taking hashmap (slope , number of point).
     Issue is slope can be 10/3  which will end 3..33333.. very long and if we check with precision, we can end up
     to close points to be on same line but actually they are not. So bet approach is reduce the slope to minimum rations by taking
     common GCF. and convert that to string.n 5/10 --> 1/2 .. "1/2"
     */
    public int lineThroughPoints(int[][] points) {
        int result=1;
        for (int i=0; i< points.length; i++){
            int[] firstPoint= points[i];
            Map<String, Integer> slopeMap = new HashMap<>();

            for (int j=i+1; j < points.length; j++){
                int[] anotherPoint = points[j];
                int[] slope = calcSlope(firstPoint, anotherPoint);

                String key = slope[0]+":"+slope[1];

                if (!slopeMap.containsKey(key)){
                    slopeMap.put(key, 1);
                }
                slopeMap.put(key, slopeMap.get(key)+1);
            }

            int maxVal = maxSlope(slopeMap);
            result= Math.max(result, maxVal);
        }

        return result;
    }

    public int maxSlope(Map<String, Integer> slopes){
        int currentMax =0;
        for (Map.Entry<String, Integer> entry: slopes.entrySet()) {
            currentMax= Math.max(currentMax, entry.getValue());
        }
        return currentMax;
    }

    public int[]  calcSlope(int[] p1, int[]p2){
        int p1x= p1[0];
        int p1y= p1[1];
        int p2x= p2[0];
        int p2y= p2[1];

        int[] slope = new int[]{1,0};

        if (p1x!= p2x){
            int yDiff= p1y-p2y;
            int xDiff= p1x-p2x;
            int gcfNum = gcf(Math.abs(xDiff),Math.abs( yDiff));
            xDiff= xDiff/gcfNum;
            yDiff= yDiff /gcfNum;
            if (xDiff<0){
                xDiff= xDiff*-1;
                yDiff= yDiff*-1;
            }
            slope= new int[]{yDiff,xDiff };
        }
        return slope;
    }

    public int gcf(int num, int den) {
        int a = num;
        int b = den;
        while (true) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            int temp = a;
            a = b;
            b = temp % b;
        }
    }
}





























