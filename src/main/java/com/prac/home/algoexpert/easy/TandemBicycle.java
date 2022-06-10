package com.prac.home.algoexpert.easy;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 */
public class TandemBicycle {
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds); Arrays.sort(blueShirtSpeeds);
        if (fastest) return fastSpeed(redShirtSpeeds,blueShirtSpeeds);
        else return minimumSpeed(redShirtSpeeds,blueShirtSpeeds);
    }

    int fastSpeed(int[] redShirtSpeeds, int[] blueShirtSpeeds){
        int totalFastSpeed=0;
        for (int i =0, j= redShirtSpeeds.length-1; i <redShirtSpeeds.length; i++, j--){
            totalFastSpeed +=redShirtSpeeds[i]>blueShirtSpeeds[j]?redShirtSpeeds[i]:blueShirtSpeeds[j];
        }
        return totalFastSpeed;
    }

    /*int minimumSpeed(int[] redShirtSpeeds, int[] blueShirtSpeeds){
        int minSpeed=0;
        for (int i =0, j= redShirtSpeeds.length-1; i <redShirtSpeeds.length; i++, j--){
            minSpeed +=redShirtSpeeds[i]>blueShirtSpeeds[j]?blueShirtSpeeds[j]:redShirtSpeeds[i];
        }
        return minSpeed;
    }*/

    int minimumSpeed(int[] redShirtSpeeds, int[] blueShirtSpeeds){
        int minSpeed=0;
        for (int i =0; i <redShirtSpeeds.length; i++){
            minSpeed +=redShirtSpeeds[i]>blueShirtSpeeds[i]?blueShirtSpeeds[i]:redShirtSpeeds[i];
        }
        return minSpeed;
    }
}
