package com.prac.home.datastructures.array.basics;

import java.util.*;
import java.util.stream.Collectors;

/**
 * two sorted array merge
 * complexity -> O(n)
 */
public class MergingTwoSortedArrays {

    public static void main(String[] args) {
        int[] a= {0,3,4,5, 32, 1000001, 1000001, 1000002, 1000003};
        int[] b= {5,6,30,333, 1000000, 1000004, 1000005, 1000006};
        Arrays.stream(mergeArrays(a, b)).forEach(x->{
            System.out.print(x +",");
        });
    }

    /*// meth 3  no idea about this one
    public static int[] mergeArrays(int[] a, int[] b){
        int[] arr = new int[a.length+b.length];
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < a.length; i++)
        {
            map.put(a[i], true);
        }
        for(int i = 0;i < b.length;i++)
        {
            map.put(b[i], true);
        }

        for (Map.Entry<Integer,Boolean> me : map.entrySet())
        {
            System.out.print(me.getKey() + " ");
        }
        System.out.println();
        int i =0;
        for (Integer x : map.keySet()) {
            arr[i] = x;
            i++;
        }


        return arr;
    }*/


    // meth 2
    public static int[] mergeArrays(int[] a, int[] b){
        int[] arr = new int[a.length+b.length];
        int aLength=a.length; int bLength=b.length, arrLength=arr.length;
        int i=0, j=0, k=0;

        while( i < aLength && j< bLength){
            if(a[i]<b[j]){
                arr[k++]=a[i++];
            }else{
                arr[k++]=b[j++];
            }
        }

        while (i < aLength){
            arr[k++]=a[i++];
        }
        while (j< bLength){
            arr[k++]=b[j++];
        }
        return arr;
    }

    // meth 1
    /*public static int[] mergeArrays(int[] a, int[] b){
        int loop=0; int i=0;
        int[] arr = new int[a.length+b.length];
        if (a.length>=b.length){
            loop= b.length;
        }else{
            loop=a.length;
        }
        int aOffset=0,bOffset=0, sepArrOffset= 0;
        for(; i <loop; i++){
            System.out.println("i-> "+i);
            while(aOffset<a.length && bOffset< b.length && a[aOffset]<=b[bOffset]){
                System.out.println("aOffset --> "+ aOffset);
                arr[sepArrOffset]=a[aOffset];
                aOffset++; sepArrOffset++;
            }
            while(aOffset<a.length && bOffset< b.length && b[bOffset]<a[aOffset]){
                System.out.println("bOffset --> "+ bOffset);
                arr[sepArrOffset]=b[bOffset];
                bOffset++;sepArrOffset++;
            }
        }
        while(aOffset<a.length){
            System.out.println("only a pending loop");
            arr[sepArrOffset]=a[aOffset];
            aOffset++;sepArrOffset++;
        }
        while (bOffset< b.length){
            System.out.println("only b pending loop");
            arr[sepArrOffset]=b[bOffset];
            bOffset++;sepArrOffset++;
        }
        return arr;
    }*/
}















