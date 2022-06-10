package com.prac.home.algoexpert.hard;
/**
 * #Array
 * given an array of non negative integers where each value represent the height of the pillar of width 1. water being pored,
 * calculate the area of the water saved.
 */
public class WaterArea {
    public static void main(String[] args) {
        System.out.println(waterArea(new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3}));
    }
    //# better way O(n) time and O(1) space
    public static int waterArea(int[] heights) {
        int area= 0;

        return area;
    }

    // special way to solve such question in O(n) time. and O(n) space
    /*public static int waterArea(int[] heights) {
        int area= 0;
        int[] leftMax= new int[heights.length];
        int leftMaxHeight=0;
        for (int i=0; i < heights.length; i++){
            if (i==0){
                leftMax[i]=0;
                leftMaxHeight= heights[i];
            }else {
                leftMax[i]= leftMaxHeight;
                leftMaxHeight= Math.max(leftMaxHeight, heights[i]);
            }
        }
        int[] rightMax= new int[heights.length];
        int rightMaxHeight= 0;
        for (int i = heights.length-1; i>=0 ; i--){
            if (i ==heights.length-1){
                rightMax[i]= 0;
                rightMaxHeight=  heights[heights.length-1];
            }else {
                rightMax[i]= rightMaxHeight;
                rightMaxHeight= Math.max(rightMaxHeight,heights[i] );
            }
        }
        int[] result = new int[heights.length];
        for (int i =0; i < heights.length; i++){
            int resultAtIndex =( Math.min(leftMax[i], rightMax[i]))- heights[i];
            result[i]= resultAtIndex>=0 ? resultAtIndex : 0;
            area+=result[i];
        }
        return area;
    }*/
}
