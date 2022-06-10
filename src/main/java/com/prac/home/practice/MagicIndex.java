package com.prac.home.practice;
/**
 * given a sorted array. we need to find the magic index , which a[i]=i. Simple logic comes to mind is loop and check complexity O(n)
 * is there any better way yes Binary search. Remember property of sorted array seach middle elemnt then move left right again on middle.
 */
public class MagicIndex {
    // Remember property of sorted array seach middle elemnt then move left right again on middle.
    static int magicIdx(int[] array , int start, int end){
        if (start > end) return -1;

        int middleIdx = (start+end)/2;

        if (array[middleIdx]== middleIdx){
            return middleIdx;
        }else if (array[middleIdx]< middleIdx){
            return magicIdx(array, middleIdx+1, end);
        }else {
            return magicIdx(array,start, middleIdx-1);
        }
    }

    // what if elements are not distinct. then at middle index we cannot conclude whether we need to go right or left.
    // we can conclude one thing we can skip few indexes e.g a[5] = 3 .. now we know left elements must be less than of equal to 3
    // but index less is a[4] which is less than or equal to 3 as value .. hence cannot be magic index.
    // so in this case we take Math.min(mididx-1, midValue).
    static int magicIdxWithNonUnique(int[] array, int start, int end){
        if (start> end) return -1;

        int midIdx = (start+end)/ 2;
        int midValue = array[midIdx];
        if (midIdx== midValue){
            return midIdx;
        }

        int leftIdx = Math.min(midIdx-1, midValue);
        int left = magicIdxWithNonUnique(array, start, leftIdx);
        if (left>=0){
            return left;
        }
        int rightIdx = Math.max(midIdx+1, midValue);
        return magicIdxWithNonUnique(array, rightIdx, end);
    }

    public static void main(String[] args) {
        int[] array = new int[]{-40,-20,2,2,2,3,5,7, 9,12, 13};
        //System.out.println(magicIdx(array, 0, array.length-1));

        System.out.println(magicIdxWithNonUnique(array, 0, array.length-1));
    }
}






















