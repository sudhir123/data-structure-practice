package com.prac.home.algoexpert.hard;
/**
 * write function that takes in sorted array and returns first idx that is equal to value at that idx. index ==array[index]
 */
public class IndexEqualValue {
    public int indexEqualsValue(int[] array) {
        // Write your code here.
        return search(array, 0, array.length-1);
    }

    public int search(int[] array, int start, int end){
        if (start>end) return -1;
        int midIdx = (start+end)/2;
        if (midIdx == array[midIdx]){
            int temp =-1;
            if ((temp= search(array, start, midIdx-1))!=-1){
                return temp;
            }else {
                return midIdx;
            }
        } else if(midIdx < array[midIdx]){
            return search(array, start, midIdx-1);
        }else {
            return search(array,midIdx+1, end );
        }
    }

    public static void main(String[] args) {
        IndexEqualValue i = new IndexEqualValue();
        System.out.println(i.indexEqualsValue(new int[]{-12, 1, 2, 3, 12}));
    }
}
