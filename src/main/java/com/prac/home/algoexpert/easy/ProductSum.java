package com.prac.home.algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * function takes a special array and returns the product sum. Special Arrays is non empty array of integers or other special array
 * product sum is ...sum of all elements in special array and multiply with level. eg   [] leve1 .. [[]] two levels [[[]]] 3 levels
 * [x, [y,z]] x+2(y+z)
 */
public class ProductSum {
    public static int productSum(ArrayList<Object> array) {
        int levelCounter=1;
        return nestedObjects(array, levelCounter);
    }
    static int nestedObjects(ArrayList<Object> internalArray, int leve){
        int totalSum=0;
        for (Object ob:internalArray
        ) {
            if (ob instanceof ArrayList){
                totalSum+=nestedObjects((ArrayList<Object>)ob,leve+1);
            }else {
                totalSum+=(Integer)ob;
            }
        }
        return totalSum*leve;
    }

    public static void main(String[] args) {
        ArrayList<Object> l1= new ArrayList<>();
        l1.add(5);
        l1.add(2);
        ArrayList<Object> l2= new ArrayList<>();
        l2.add(7); l2.add(-1);
        l1.add(l2);
        l1.add(3);
        ArrayList<Object> l3= new ArrayList<>();
        l3.add(6);
        ArrayList<Object> l4= new ArrayList<>();
        l4.add(-13); l4.add(8);
        l3.add(l4);
        l3.add(4);
        l1.add(l3);

        System.out.println(productSum(l1));
    }
}





































