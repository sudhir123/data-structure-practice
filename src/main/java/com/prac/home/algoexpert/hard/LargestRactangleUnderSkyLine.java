package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class LargestRactangleUnderSkyLine {
    public static void main(String[] args) {
        LargestRactangleUnderSkyLine l =new LargestRactangleUnderSkyLine();
        System.out.println(l.largestRectangleUnderSkyline(Arrays.asList(1, 3, 3, 2, 4, 1, 5, 3, 2)));
    }
    /*
        very complicated steps. normally in such cases we create two arrays and fill those with max till that point with one movement to
        left to right and another array with movement from right to left, in separate loops. But in this question we have two approaches
        1) brute force , in which we go to right and left in both directions and calculate max rectangle ant any point.
        2) is using stack.
        lets see brute force first, which O(n^2) and O(1)
     */
    /*public int largestRectangleUnderSkyline(List<Integer> buildings) {
        int maxArea=0;
        for (int pillarIdx=0; pillarIdx< buildings.size(); pillarIdx++){
            int currentHeight = buildings.get(pillarIdx);

            int furthestLeft= pillarIdx;
            while (furthestLeft>0 && buildings.get(furthestLeft-1)>=currentHeight){
                furthestLeft -= 1;
            }

            int furthestRight= pillarIdx;
            while (furthestRight <buildings.size()-1
                    && buildings.get(furthestRight+1)>=currentHeight){
                furthestRight += 1;
            }
            int currentArea= ((furthestRight-furthestLeft)+1)*currentHeight;
            maxArea= Math.max(maxArea, currentArea);
        }
        return maxArea;
    }*/
    // now another way is to use stack to trace the farthest lft and farthest right in single pass.
    public int largestRectangleUnderSkyline(List<Integer> buildings) {
        int maxArea=0;
        Stack<Integer> stack= new Stack<>();// putting index

        ArrayList<Integer> extendedBuildings = new ArrayList<>(buildings);
        extendedBuildings.add(0); // 0 at end to cover the width of last pillar

        for (int pillarIdx = 0; pillarIdx< extendedBuildings.size(); pillarIdx++){
            int currentHeight = extendedBuildings.get(pillarIdx);
            while (!stack.isEmpty() && currentHeight <= extendedBuildings.get(stack.peek()) ){
                // this is a point to calculate left and right points to calculate area
                int topIndexHeight = extendedBuildings.get(stack.pop());
                int width = stack.isEmpty()? pillarIdx: pillarIdx- stack.peek()- 1;
                maxArea= Math.max(maxArea, width*topIndexHeight);
            }
            stack.push(pillarIdx);
        }
        return maxArea;
    }
}





























