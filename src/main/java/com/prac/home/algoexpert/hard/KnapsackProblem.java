package com.prac.home.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * #Array
 * https://www.youtube.com/watch?v=y6kpGJBI7t0
 * given an array of arrays where each subarray holds two integegers , first is item, and secon is weight. All you have been given
 * and maximumum allowed weight. consider it as a bag and you have certain items each has cost and its weight.
 * you need to fill bag with maximum prise things but keeping wight under what is allowed for bag.
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        KnapsackProblem k= new KnapsackProblem();
        System.out.println(k.knapsackProblem(new int[][]{
                {1, 2},
                {4, 3},
                {5, 6},
                {6, 7}}, 10));
    }

    // for such problem use dynamic prog and dyanamic prog involves sometime single array of same length or sometimes
    // 2-d array like to calculate ways .. and generate formula out of such solutions.
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // there will be array to hold capacity from 0 to given capacity.
        int[][] maxPriceWeightArray = new int[items.length + 1][capacity + 1];

        for (int row = 1; row < items.length + 1; row++) {
            int[] item = items[row - 1];
            int currentWeight = item[1];
            int currentValue = item[0];

            for (int col = 0; col < capacity + 1; col++) {
                if (currentWeight > col) {
                    maxPriceWeightArray[row][col] = maxPriceWeightArray[row - 1][col];
                } else {
                    maxPriceWeightArray[row][col] =
                            Math.max(
                                    maxPriceWeightArray[row-1][col],
                                    maxPriceWeightArray[row - 1][col - currentWeight] + currentValue
                            );
                }
            }
        }
        return getKnapSackItems(maxPriceWeightArray, items, maxPriceWeightArray[items.length][capacity]);
    }

    public static List<List<Integer>> getKnapSackItems(
            int[][] knapSackValue, int[][] items, int weight
    ){
        List<Integer> totalValue = new ArrayList<>();
        List<Integer> finalItems = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        totalValue.add(weight);
        result.add(totalValue);
        int row =knapSackValue.length-1;
        int col = knapSackValue[0].length-1;
        while (row>0){
            if (knapSackValue[row][col]== knapSackValue[row-1][col]){
                row--;
            }else {
                finalItems.add(row-1);
                col-= items[row-1][1];
                row--;
            }
            if (col==0){
                break;
            }
        }
        result.add(finalItems);
        return result;
    }


    //#mythinking .. saving item prize and weight in map and saving prise in an list. sort the list keeep on adding the values
    // also check wight. Dumb Solution but lets start with this.
    /*public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        Map<Integer, Integer> valueWeightMap= new HashMap<>();
        Map<Integer, Integer> valueIndexMap= new HashMap<>();
        List<Integer> valueList = new ArrayList<>();
        for (int i=0; i < items.length; i++){
            int[] temp = items[i];
            valueWeightMap.put(temp[0],temp[1]);
            valueIndexMap.put(temp[0], i);
            valueList.add(temp[0]);
        }
        List<Integer> totalValue = new ArrayList<>();
        List<Integer> finalItems = new ArrayList<>();

        Collections.sort(valueList);// nLogn
        int maxPriseValue=0, capacitySoFar=0;
        for (int i=valueList.size()-1; i >=0; i--){
            capacitySoFar+=valueWeightMap.get(valueList.get(i));
            if (capacitySoFar> capacity){
                capacitySoFar-=valueWeightMap.get(valueList.get(i));
            }else {
                maxPriseValue+=valueList.get(i);
                finalItems.add(valueIndexMap.get(valueList.get(i)));
            }
        }
        totalValue.add(maxPriseValue);

        // Write your code here.
        // Replace the code below.
        List<List<Integer>> result = new ArrayList<>();
        result.add(totalValue);
        result.add(finalItems);
        return result;
    }*/
}
