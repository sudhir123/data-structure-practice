package com.prac.home.practice;

/**
 * #Array
 * Count Of Subsets That Adds Up To Target Number. [2,4,6,10] target is 16 subsets [2,4,10], [6,10]. But in this problem o/p is 2.
 */
public class CountOfSubsetsThatAddsUpToTargetNumber {
    static int countSubset(int[] array, int target){
        return countSubset(array, target, array.length-1);
    }

    static int countSubset(int[] array, int target, int idx){

         if (target <0) return 0;
        else if (target==0) return 1;
        else if (idx<0) return 0;
        else if (target<array[idx]){
            // i will include
            return countSubset(array, target, idx-1);
        }else {
            int count = countSubset(array, target-array[idx], idx-1)+ countSubset(array, target, idx-1)  ;
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(countSubset(new int[]{2,4,6,10}, 16));
    }
}
