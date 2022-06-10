package com.prac.home.datastructures.companies.amazon.g4gtest;

import java.lang.reflect.Array;
import java.util.*;

public class Arrangement {
    public static void main(String[] args) {
        ArrayList<Integer> height= new ArrayList<>();
        height.add(3);
        height.add(5);
        height.add(2);
        height.add(4);
        height.add(10);
        height.add(9);

        ArrayList<Integer> numberOfPersonInFront= new ArrayList<>();
        numberOfPersonInFront.add(0);
        numberOfPersonInFront.add(0);
        numberOfPersonInFront.add(0);
        numberOfPersonInFront.add(1);
        numberOfPersonInFront.add(0);
        numberOfPersonInFront.add(1);

        System.out.println(arrange(height, numberOfPersonInFront, 3));
    }
   static public class MyArrayListComparator implements java.util.Comparator<ArrayList>
    {
        public int compare(ArrayList al1, ArrayList al2)
        {
            int d1 = (int)al1.get(1) - (int)al2.get(1);
            int d2 = (int)al2.get(0) - (int)al1.get(0);
            if((int)al1.get(0) == (int)al2.get(0))
                return d1;
            else
                return d2;

        }
    }
    static ArrayList<Integer> arrange(ArrayList<Integer> heights, ArrayList<Integer> numberOfPersonInFront, int n){
        ArrayList<ArrayList<Integer>> people= new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            people.add(temp);
        }
        for(int i=0; i<n; i++)
        {
            people.get(i).add(heights.get(i));
            people.get(i).add(numberOfPersonInFront.get(i));
        }
        Collections.sort(people, new MyArrayListComparator());

        ArrayList<Integer> ans = new ArrayList<Integer>();

        for(int i =0; i<n; i++)
            ans.add(people.get(i).get(1) , people.get(i).get(0));

        return ans;
    }
}























