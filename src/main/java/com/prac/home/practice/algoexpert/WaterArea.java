package com.prac.home.practice.algoexpert;

import java.util.Arrays;

public class WaterArea {
    public static void main(String[] args) {
        WaterArea w = new WaterArea();
        int[] input =new int[]{4,2,0,3,2,5};
        System.out.println(Arrays.toString(input));
        System.out.println(w.maxArea(input));
    }
    public int maxArea(int[] height) {
        int[] left= new int[height.length];
        int[] right= new int[height.length];
        int[] result= new int[height.length];
        left[0]=0;
        for (int i=1; i< left.length; i++){
            left[i]= Math.max(left[i-1], height[i-1]);
        }
        right[right.length-1]=0;
        for (int i=left.length-2; i>=0; i--){
            right[i]= Math.max(right[i+1], height[i+1]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int sum=0;
        for (int i=0; i< height.length; i++){
            int r =((Math.min(left[i], right[i]))- (height[i]));
            result[i]= r>0?r:0;
            sum+=result[i];
        }
        return sum;
    }
}
