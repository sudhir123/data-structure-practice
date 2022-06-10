package com.prac.home.practice;

import java.util.Arrays;

public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        ProductOfArrayExceptItself p = new ProductOfArrayExceptItself();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1,2,3,4})));
    }
    // first
    public int[] productExceptSelf(int[] nums) {
       return meth2(nums);
    }

    // second way reduced space
    public int[] meth2(int[] nums) {
        int[] product= new int[nums.length];
        product[0]=1;
        for (int i=1; i< product.length; i++){
            product[i]= nums[i-1]* product[i-1];
        }

        int prod= nums[nums.length-1];
        for (int i=product.length-2; i >=0; i--){
            product[i]= product[i]* prod;
            prod= prod*nums[i];
        }
        return product;
    }

    // first way O(n ) time and o(n) space
    public int[] meth1(int[] nums) {
        int[] left= new int[nums.length];
        int [] right = new int[nums.length];
        int[] product= new int[nums.length];

        left[0]=1;
        right[nums.length-1]= 1;
        for (int i=1; i< left.length; i++){
            left[i]= nums[i-1]* left[i-1];
        }

        for (int i=right.length-1; i >=0; i--){
            right[i]= right[i+1]* nums[i+1];
        }

        for (int i=0; i <nums.length; i++){
            product[i]= left[i]*right[i];
        }
        return product;
    }
}
