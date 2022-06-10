package com.prac.home.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] < A[j] and i < j.
 * Similarly we mAxDistance ---> there are two ways O(n) and another n logn --> O(n ) what we have described below
 * nlogn -> where we will have class which will have number and idx and we will do sorting based on number. So in this way
 * we solved one problem
 */
public class MaximumIndex {
    public static void main(String[] args) {
        System.out.println(maxIndexDiff(new int[]{82, 63, 44, 74, 82 ,99 ,82}, 7    ));
        System.out.println(maxDistance(new int[]{82, 63, 44, 74, 82 ,99 ,82}, 7    ));
    }
    /// best ways O(n)
    static int maxIndexDiff(int A[], int N) {
        int[]left = new int[A.length];
        int [] right= new int[A.length];
        left[0]= A[0];
        for (int i=1; i < left.length; i++){
            left[i]= Math.min(left[i-1], A[i]);
        }

        right[right.length-1]= A[A.length-1];
        for (int i=right.length-2; i >= 0; i--){
            right[i]= Math.max(right[i+1], A[i]);
        }

        int i=0, j=0, idxDiff =Integer.MIN_VALUE;

        while (i<left.length && j < right.length){
            if (left[i]< right[j]){
                idxDiff= Math.max(idxDiff, j-i);
                j=j+1;
            }else {
                i=i+1;
            }
        }
        return idxDiff;
    }

    // another good ways but with nLogn
    static int maxDistance(int A[], int N) {
        List<MaxDis> list = new ArrayList<>();
        for (int i =0; i<A.length; i++){
            MaxDis m = new MaxDis(A[i], i);
            list.add(m);
        }
        Collections.sort(list, (o1, o2) -> o1.val > o2.val?1:-1);

        // target is to maximise j-i for that we will have minimum i and keep on moving j and difference is being compared after every iteration
        int minIdx=Integer.MAX_VALUE;
        int answer =Integer.MIN_VALUE;
        //MaxDis m1= list.get(0);
        for (int j=0; j < list.size(); ){
            MaxDis m2 = list.get(j);
            minIdx= Math.min(minIdx, m2.idx);
            answer= Math.max(answer, m2.idx-minIdx);
            j++;
        }
        return answer;
    }
    static class MaxDis{
        int val;
        int idx;
        MaxDis(int val, int idx){
            this.val= val;
            this.idx= idx;
        }
    }
}
