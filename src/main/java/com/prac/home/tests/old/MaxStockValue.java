package com.prac.home.tests.old;

//O(n)
// first -> compare it next one
// if lower
// maximumVal= 1
// point of buy -> lowest   -> small -> 3
// small -> 2
// profit -> 6
// 5,3,4,2,6,8,1
// 3,4,2,6,8,1
// 5 4 2 2 1
public class MaxStockValue {

    public static void main(String[] args) {

        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxValue(arr));
    }

    static int maxValue(int[] arr){
        int maximumProfit =0 , i=0, small =0 , large =0, end= arr.length-1;
        while (i < arr.length){
            small = arr[i];
            while(small< arr[i+1]){
                i=i+1;
                if(i ==arr.length-1) {
                    break;
                }
            }

            large = arr[i];
            int  intrimProfit= large-small;
            if(maximumProfit< intrimProfit){
                maximumProfit= intrimProfit;
            }
            i++;
        }
        return maximumProfit;
    }
}
