package com.prac.home.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackConstruction {
    static class MinMaxStack {
        List<Integer> stack = new ArrayList<>();
        List<Integer> minStackTracker = new ArrayList<>();
        List<Integer> maxStackTracker = new ArrayList<>();

        public int peek() {
            return stack.get(stack.size()-1);
        }

        public int pop() {
            Integer element=  stack.remove(stack.size()-1);
            if (!minStackTracker.isEmpty() && element.equals(minStackTracker.get(minStackTracker.size()-1))){
                minStackTracker.remove(minStackTracker.size()-1);
            }
            if (!maxStackTracker.isEmpty()&& element.equals(maxStackTracker.get(maxStackTracker.size()-1))){
                maxStackTracker.remove(maxStackTracker.size()-1);
            }
            return element;
        }

        public void push(Integer number) {
            stack.add(number);
            if (!minStackTracker.isEmpty() && minStackTracker.get(minStackTracker.size()-1) >= number){
                minStackTracker.add(number);
            }
            else if (!maxStackTracker.isEmpty() && maxStackTracker.get(maxStackTracker.size()-1) <= number){
                maxStackTracker.add(number);
            }else if (maxStackTracker.isEmpty() && minStackTracker.isEmpty()){
                minStackTracker.add(number);maxStackTracker.add(number);
            }
        }

        public int getMin() {
           return !minStackTracker.isEmpty() ?minStackTracker.get(minStackTracker.size()-1):-1;
        }

        public int getMax() {
            return !maxStackTracker.isEmpty()?maxStackTracker.get(maxStackTracker.size()-1):-1;
        }
    }

    public static void main(String[] args) {
        MinMaxStack m = new MinMaxStack();
        m.push(5);
        m.push(5);
        m.push(5);
        m.push(5);
        m.push(8);
        m.push(8);
        m.push(0);
        m.push(8);
        m.push(9);
        m.push(5);

        m.pop();
        m.pop();
        m.pop();
        m.pop();
        m.pop();
        m.pop();
        m.pop();
        m.pop();
        m.pop();
        System.out.println("MIN -> "+m.getMin());
        System.out.println("MAX -> "+m.getMax());
    }
}
