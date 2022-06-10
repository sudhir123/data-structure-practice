package com.prac.home.algoexpert.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * two dimensional array given , which is filled with 0 and 1. 1 being blocked and 0 open area. Water can flow only downward
 * if open. If blocked than slplt in two 50% and move left and right unless find down Last row is buckets . what % flow in each bucket.
 */
public class WaterfallStreams {
    // algo by algoexpert
    public double[] waterfallStreams(double[][] array, int source) {

        // this is copy of the row we wanna modify
        double[] rowAbove = array[0];
        rowAbove[source]= -1;

        for (int i=1; i < array.length; i++){
            double[] currentRow = array[i];

            for (int idx =0; idx < rowAbove.length; idx++){
                double valueAbove = rowAbove[idx];

                boolean hasWaterAbove = valueAbove<0;
                boolean hasBlock = currentRow[idx] ==1.0;

                if (!hasWaterAbove){
                    continue;
                }
                if (!hasBlock){
                    currentRow[idx]+=valueAbove;
                    continue;
                }

                // left and right two pointers moving with conditions.
                int left=idx, right =idx;
                double splitWater = valueAbove/2;

                while (right +1< rowAbove.length){
                    right+=1;
                    if (rowAbove[right]==1){
                        break;
                    }
                    if (currentRow[right]!=1){
                        currentRow[right]+=splitWater;
                        break;
                    }
                }


                while (left-1>0 ){
                    left-=1;
                    if (rowAbove[left]==1){
                        break;
                    }
                    if (currentRow[left]!=1.0){
                        currentRow[left]+=splitWater;
                        break;
                    }
                }

            }
            rowAbove= currentRow;
        }
        double[] finalResult = new double[rowAbove.length];
        for (int i=0; i< rowAbove.length; i++){
            if (rowAbove[i]==0){
                finalResult[i]= rowAbove[i];
            }else {
                finalResult[i]= rowAbove[i] *-100;
            }
        }
        return finalResult;
    }



    public static void main(String[] args) {
        WaterfallStreams w= new WaterfallStreams();
        System.out.println(Arrays.toString(w.waterfallStreams(new double[][]
                {
                        {0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0}
                } , 3)));
    }
}
