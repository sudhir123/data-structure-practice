package com.prac.home.basic;

import com.prac.home.algoexpert.medium.SpiralTraverse;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualAndHashCodeSet {
    static class ElementTracker{
        int x; int y; boolean visited;
        ElementTracker(int x, int y ){
            this.x=x;
            this.y=y;
            this.visited=false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ElementTracker that = (ElementTracker) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) {
        Set<ElementTracker> set = new HashSet<>();
        for (int i =0; i < 10; i ++){
            set.add(new ElementTracker(i, i*7));
        }

        System.out.println(set.contains(new ElementTracker(5, 35)));
    }
}
