package com.prac.home.practice;

public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        System.out.println(jumps(new int[]{6, 2, 4, 0, 5, 1, 1, 4, 2, 9}));
    }
    static int jumps(int[] array){
        int jumps=0;
        int steps =array[0];
        int maxReach=array[0];
        for (int i=1; i<array.length; i++){
            maxReach= Math.max(maxReach, i+array[i]);
            steps--;
            if (steps==0){
                jumps++;
                steps= maxReach-i;
            }
        }
        return jumps;
    }
}
