package com.prac.home.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets s= new Subsets();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i=0; i<nums.length; i++){
            int num = nums[i];
            List<List<Integer>> temp = new ArrayList<>(result);
            for (int idx =0; idx < temp.size(); idx++){
                ArrayList cloned = new ArrayList(result.get(idx));
                cloned.add(num);
                result.add(cloned);

            }
        }
        return result;
    }
}
