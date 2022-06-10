package com.prac.home.algoexpert.medium;
/**
 * given an array representing jump of its value in tterms of inder , if 2 ..jump 2 index fwd and -3 jump backward
 * if you are start of array and se e-1 ...you will reach end of array. funtion to detect the cyclic.
 * Quetion is about single cycle or multiple cycle
 */
public class SingleCycleCheck {
    /*public static boolean hasSingleCycle(int[] array) {
        int startIdx =0; int currentIdx=0;
        int numberOfElementsVisited=0;
        while (numberOfElementsVisited< array.length){
            currentIdx=adjustInx(currentIdx, array);
            numberOfElementsVisited++;
            if (numberOfElementsVisited < array.length && currentIdx==startIdx) return false;
        }
        return true;
    }

    static int adjustInx(int i , int[] array){
        int jump= array[i];
        i = (jump+i )% array.length;
        return i>=0 ?i: i+array.length;
    }*/


    public static boolean hasSingleCycle(int[] array) {
        int startIdx = 0;
        int currentIdx = 0;
        int numberOfElementsVisited = 0;
        while (numberOfElementsVisited < array.length) {
            if (numberOfElementsVisited > 0 && currentIdx == startIdx) return false;
            numberOfElementsVisited++;
            currentIdx = adjustInx(currentIdx, array);
        }
        return currentIdx==0;
    }

    static int adjustInx(int i , int[] array){
        int jump= array[i];
        i = (jump+i )% array.length;
        return i>=0 ?i: i+array.length;
    }
    public static void main(String[] args) {
        System.out.println(hasSingleCycle(new int[]{1, 1, 0, 1, 1}));
    }
}
