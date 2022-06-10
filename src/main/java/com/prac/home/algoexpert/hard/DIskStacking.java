package com.prac.home.algoexpert.hard;

import java.util.*;

/**
 * #Array
 * given an array of arrays representing width depth and height of a disk.
 * write a function to stack the disks one above other to maximise the height. * Only condition is lowest disk is of greater height
 * width and depth than the height , width depth of the disk above.
 */
public class DIskStacking {
    public static void main(String[] args) {
        List<Integer[]> disks= new ArrayList<>();
        disks.add( new Integer[]{2, 1, 2});
        disks.add( new Integer[]{3, 2, 3});
        disks.add( new Integer[]{2, 2, 8});
        disks.add( new Integer[]{2, 3, 4});
        disks.add( new Integer[]{1, 3, 1});
        disks.add( new Integer[]{4, 4, 5});
        System.out.println(diskStacking(disks));

    }
    /*
    Algo is -> sort given array by height. now use dynamic programming to create the result.
     */
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        List<Integer[]> result = new ArrayList<>();
        disks.sort((a, b) -> a[2]<b[2]?1:-1); // sort according to height. highest on 0th location
        int[] height = new int[disks.size()];
        int[] seq = new int[disks.size()];
        Arrays.fill(seq,-1);
        for (int i=0; i< disks.size(); i++){
            height[i]= disks.get(i)[2];
        }
        for (int i=0; i< disks.size(); i++){
            Integer[] highestDiskPlace =disks.get(i);
            for (int j=0; j < i; j++){
                Integer[] currentDisk = disks.get(j);

                if (currentDisk[1]> highestDiskPlace[1] && currentDisk[0]>highestDiskPlace[0]){

                    if (height[i]< height[j]+ highestDiskPlace[2]){
                        height[i]= height[j]+ highestDiskPlace[2];
                        seq[i]=j;
                    }
                }
            }
        }
        int maxHeight= Integer.MIN_VALUE;
        int maxHeightIdx =-1;
        for (int i=0; i < height.length; i++){
            if(maxHeight< height[i]){
                maxHeight= height[i];
                maxHeightIdx=i;
            }
        }
        while (maxHeightIdx!=-1){
            result.add(disks.get(maxHeightIdx));
            maxHeightIdx= seq[maxHeightIdx];
        }
        return result;
    }
}



































