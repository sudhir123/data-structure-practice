package com.prac.home.practice.slidingwindow;

import java.util.Map;

/**
 * similar question by google
 * This problem was asked by Google.
 *
 * Given a string which we can delete at most k, return whether you can make a palindrome.
 *
 * For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
 */
public class MaximumPointsObtainFromCards {
    public static void main(String[] args) {
        MaximumPointsObtainFromCards m = new MaximumPointsObtainFromCards();
        System.out.println(m.maxScore(new int[]{100,40,17,9,73,75},3));
        //[100,40,17,9,73,75] 248
    }
    // it is a sliding window problem
    public int maxScore(int[] cardPoints, int k) {
        //return maxScoreRecursion(cardPoints, k, 0, cardPoints.length-1,0);
        return maxScoreSlidingWindow(cardPoints, k);
    }

    public int maxScoreSlidingWindow(int[] cardPoints, int k) {

        int windowSize=0;
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        // first lets make sum by taking numbers equal to desired window size
        while (windowSize<k){
            sum+=cardPoints[windowSize];
            windowSize++;
        }
        int left=k-1; int right = cardPoints.length-1;
        while (left>=0 ){
            maxSum= Math.max(maxSum, sum);
            sum-=cardPoints[left];
            left--;
            sum+=cardPoints[right];
            right--;
        }
        maxSum= Math.max(maxSum, sum);
        return maxSum;
    }
    // this is one way, but not efficient as sliding window is. The concept is sliding window is because either tale left or right
    // move that pointer if left then inc left , if right than dec right. if you notice you will sliding a contineous window.
    public int maxScoreRecursion(int[] cardPoints, int k, int left, int right, int currentWindow) {
        if (currentWindow==k) return 0;

        int sum =Math.max(cardPoints[left],cardPoints[right]);

        if (cardPoints[left]== cardPoints[right]){
            sum+= Math.max(
                    maxScoreRecursion(cardPoints, k , left+1, right,currentWindow+1),
                    maxScoreRecursion(cardPoints, k, left, right-1, currentWindow+1));
        }else {
            sum+=maxScoreRecursion(cardPoints, k, left+1,right-1, currentWindow+1
            );
        }
        return sum;
    }
}
/*
int left=0; int right =cardPoints.length-1;
        int sum=0;
        int windowSize=0;
        boolean followDirection=false, rightSide=false;
        while (windowSize<k && left< cardPoints.length && right>=0) {
            if (followDirection) {
                if (rightSide) {
                    sum+=cardPoints[right];
                    right--;
                } else {
                    sum+=cardPoints[left];
                    left++;
                }
            } else {
                if (cardPoints[left] == cardPoints[right]) {
                    sum += cardPoints[left];
                } else {
                    sum+=Math.max(cardPoints[right], cardPoints[left]);
                    followDirection=true;
                    if (cardPoints[right] > cardPoints[left]) {
                        rightSide = true;
                    }
                }
                left++;right--;
            }
            windowSize++;
        }
        return sum;
 */