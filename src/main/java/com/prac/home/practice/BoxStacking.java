package com.prac.home.practice;

import java.util.*;

/**
 * You are given a set of N types of rectangular 3-D boxes, where the ith box has height h, width w and length l.
 * You task is to create a stack of boxes which is as tall as possible, but you can only stack a box on top of another box
 * if the dimensions of the 2-D base of the lower box are each strictly larger than those of the 2-D base of the higher box.
 * Of course, you can rotate a box so that any side functions as its base.It is also allowable to use multiple instances of the same type
 * of box. You task is to complete the function maxHeight which returns the height of the highest possible stack so formed.
 */

// 88 cases passed -- some issue seems to be there in code provided

/* variation from Disk Stacking -> In Disk Stacking we cannot rotate the disk order has to be w, l, h.
Over this question we are allowed to rotate.
 */
public class BoxStacking {
    public static void main(String[] args) {
        int[] height = new int[]{4, 1, 4,10};
        int[] width = new int[]{6, 2, 5,12};
        int[] length = new int[]{7, 3, 6, 32};

        System.out.println(maxHeight(height, width, length, 4));
    }
    static class Box {
        int l;
        int w;
        int h;
        int area;
        Box(int l, int w, int h ){
            this.l= l; this.w=w; this.h=h;
            this.area= l*w;
        }
    }

    public static int maxHeight(int height[], int width[], int length[], int n){
        List<Box> boxes = boxes(height, width, length, n);
        int[] heights = new int[boxes.size()];

        for (int i=0; i < boxes.size() ; i++){
            heights[i]= boxes.get(i).h;
        }
        for (int i=0; i < boxes.size(); i++){
            Box current = boxes.get(i);

            for (int j =0; j< i; j++){
                Box other = boxes.get(j);
                if (current.l > other.l && current.w > other.w ){
                    if (heights[i]< heights[j]+ current.h){
                        heights[i]= heights[j]+ current.h;
                    }
                }
            }

        }
        int maxHeight =Integer.MIN_VALUE;
        for (int i= 0; i < heights.length; i++){
            maxHeight= Math.max(maxHeight, heights[i]);
        }
        return maxHeight;
    }

    static List<Box> boxes(int height[], int width[], int length[], int n){
        List<Box> boxes =new ArrayList<>();
        for( int i=0; i < n ; i++){
            int h= height[i];
            int w= width[i];
            int l = length[i];

            Box b1 = new Box( Math.max(w,l), Math.min(w,l), h);
            Box b2 = new Box( Math.max(h,l), Math.min(h,l), w );
            Box b3 = new Box( Math.max(w,h), Math.min(w,h), l );
            boxes.add(b1);  boxes.add(b2);  boxes.add(b3);
            Collections.sort(boxes, (o1, o2) -> o1.area> o2.area?1:-1);
        }
        return boxes;
    }
}







/*
List<Integer[]> boxes = prepIntegerArray(height,width,length,n);
        int[] heights = new int[boxes.size()];
        heights[0]= boxes.get(0)[2];
        for (int i=0; i < boxes.size(); i++){
            Integer[] current = boxes.get(i);
            for (int j=0; j <i ; j++){
                Integer[] other = boxes.get(j);

                if (other[0]< current[0] && other[1]< current[1]){
                    if (heights[i]< heights[j]+ current[2]){
                        heights[i]= heights[j]+ current[2];
                    }
                }
            }
        }
        int max=0;
        for(int i = 0; i < heights.length; i++){
            max = Math.max(max, heights[i]);
        }
        return max;
    }

    static List<Integer[]>  prepIntegerArray(int height[], int width[], int length[], int n){
        List<Integer[]> boxes = new ArrayList<>();
        for (int i=0; i <n ; i++){
            int h = height[i];
            int w = width[i];
            int l = length[i];

            Integer[] var1 = new Integer[]{h,Math.max(w,l),Math.min(w,l),h*Math.max(w,l)};
            Integer[] var2 = new Integer[]{l,Math.max(w,h),Math.min(w,w) , l*Math.max(w,h)};
            Integer[] var3 = new Integer[]{w,Math.max(h,l),Math.min(h,l), w*Math.max(h,l)};
            boxes.add(var1);
            boxes.add(var2);
            boxes.add(var3);
            Collections.sort(boxes, (o1, o2) -> o1[3]> o2[3]?1:-1);
        }
        return boxes;
    }

    static class Box{
        int h;
        int w;
        int d;
        int area;

        public Box(int h,int w,int d){
            this.h = h;
            this.w = w;
            this.d = d;
            area = w * d;
        }
 */




















