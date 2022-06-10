package com.prac.home.algoexpert.medium;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing. * An array nums is monotone increasing
 * if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
 */
public class MonotonicArray {
    static public boolean isMonotonicSolution1(int[] nums) {
        boolean increasing=false, positives=false;
        if (nums.length <= 1 ) return true;

        if (nums[0] <= nums[1]) increasing=true;
        if (nums[0]>=0) positives=true;

        for (int i =0; i <nums.length-1; i++){
            if (increasing && positives) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }else {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    // best solution
    static public boolean isMonotonic(int[] nums) {
        boolean isNonIncreasing=true, isNonDecreasing=true;
        for (int i=0; i <nums.length-1; i++){
            if (nums[i] < nums[i+1]){
                isNonIncreasing=false;
            }
            if (nums[i]> nums[i+1]){
                isNonDecreasing=false;
            }
        }
        return isNonDecreasing||isNonIncreasing;
    }
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[] {-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -8, -9, -10, -11}));
    }
}
