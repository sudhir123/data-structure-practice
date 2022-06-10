package com.prac.home.practice;
/**
 * Given N non-negative integers a1,a2,....an where each represents a point at coordinate (i, ai).
 * N vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i,0).
 * Find two lines, which together with x-axis forms a container, such that it contains the most water.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater c=new ContainerWithMostWater();
        System.out.println(c.maxArea(new int[]{1,5,4,3}, 4));
    }
    long maxArea(int A[], int len){
        int i=0; int j=A.length-1;
        int ans= 0;
        while (i< j){
            ans= Math.max(ans, (j-i)*( Math.min(A[j], A[i])));
            if (A[j] > A[i]){
                i++;
            }else {
                j--;
            }
        }
        return ans;
    }

}
