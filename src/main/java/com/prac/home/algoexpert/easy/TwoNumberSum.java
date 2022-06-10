package com.prac.home.algoexpert.easy;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i <array.length; i++){
            map.put(array[i], i);
        }
        for (Integer arrValueAsKey:
                map.keySet()) {
            int targetX = targetSum- arrValueAsKey;
            if (map.get(targetX)!=null){
                return new int[]{targetX, arrValueAsKey};
            }
        }
        return new int[0];
    }

    public static int twoNumberSumByScaler(int[] A, int B) {
        Arrays.sort(A);
        int count=0;
        int left=0; int right=A.length-1;
        while (left<=right){
            int currentSum = A[left]+ A[right];
            if (B ==currentSum){
                count++;
                left++;
            }else if (currentSum< B){
                left++;
            }else {
                right--;
            }
        }
        return count;
    }


    static int[] commonElementsBetweenTwoArrays(int[] ar, int[] br){
        Arrays.sort(ar);
        Arrays.sort(br);
        int i=0, j=0;
        List<Integer> result = new ArrayList<>();
        while (i<ar.length && j<br.length){

            if (ar[i]==br[j]){
                result.add(ar[i]);
                i++; j++;
            }else if (ar[i]< br[j]){
                i++;
            }else {
                j++;
            }
        }
        int[] res= new int[result.size()];
        for (int k=0; k < result.size(); k++){
            res[k]= result.get(k);
        }
        return res;
    }
    public static int pow(int A, int B , int C) {
        BigInteger num= calc( ""+A,B);
        return (num.intValue())%C >=0 ?((num.intValue())%C) : C+((num.intValue())%C );
       //return 1;
    }
    public static BigInteger calc( String a ,int b ) {
        BigInteger c= new BigInteger(a);
        return c.pow(b);
    }

   /* public static BigInteger calc( int a ,int b ) {
        BigInteger temp ;
        if (b==0)
            return BigInteger.valueOf(1);
        temp= calc(a, b/(BigInteger.valueOf(2)).intValue());
        if (b%2==0){
            //System.out.println(temp.multiply(temp));
            return temp.multiply(temp);
        }else {
            //System.out.println((temp.multiply(temp)).multiply(a));
            return BigInteger.valueOf(temp.multiply(temp)).intValue()*a);
        }
    }*/

    public static void main(String[] args) {
        //int[] arr = TwoNumberSum.twoNumberSum(new int[]{3,5,-4, 8,11,1,-1,6}, 10);
        //System.out.println(Arrays.toString(arr));

        //System.out.println(twoNumberSumByScaler(new int[]{2,4,9,1,9,7,6,4,9}, 8));
        //System.out.println(twoNumberSumByScaler(new int[]{1,1,1}, 2));
       // System.out.println(Arrays.toString(commonElementsBetweenTwoArrays(new int[]{1,2,2,1}, new int[]{2,3,2,1})));

        //System.out.println(pow(2,3,3));
        System.out.println(pow(71045970,12,64735492));


        //System.out.println(1%20);
        //System.out.println(1%20);
        //System.out.println(45369%1);
    }

}
