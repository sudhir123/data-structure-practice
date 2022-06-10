package com.prac.home.tests;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {

    }
    /*
    AMIT
    BOMBAY
    MANMOHAN
    SUDHIR

    AMS
     */
   public List<Integer> meth1(List<String> employees){
       employees= new ArrayList<>(Arrays.asList(""));
       for (Object s: employees
            ) {
           if (s.equals("")){
               employees.remove(0);
           }
       }
       return null;
   }
}


class Employee{
     Employee(){

    }
    public void acc(){};
}
class B extends Employee{
    public void acc(){};
    public void acc(int ab){};
}



















