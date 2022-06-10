package com.prac.home.datastructures.array.basics;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class MaximumPeopleAliveInYear {
    public static void main(String[] args) {
        Random r =new Random();
        System.out.println();
        List<Person> list= new ArrayList<>();
        for (int i =0 ; i < 10; i ++){
            int birthYear= 1900 + (int)(Math.random() * ((2000 - 1900) + 1));
            int deathYear= birthYear+ (int)(Math.random() * ((2000 - birthYear) + 1));
            Person p = new Person(birthYear, deathYear);
            list.add(p);
        }
        System.out.println(maxAliveYear(list));
    }

    static int maxAliveYear(List<Person>list){
        Map<Integer, MapData>map = new HashMap<>();
        for (Person p :list
             ) {
            if (map.get(p.getBirthYear())!=null){
                MapData m= map.get(p.getBirthYear());
                m.setBirthCount(m.getBirthCount()+1);
            }else {
                MapData m=new MapData();
                m.setBirthCount(m.getBirthCount()+1);
                map.put(p.birthYear, m);
            }

            if (map.get(p.getDeathYear())!=null){
                MapData m= map.get(p.getDeathYear());
                m.setDeathCount(m.getDeathCount()+1);
            }else {
                MapData m=new MapData();
                m.setDeathCount(m.getDeathCount()+1);
                map.put(p.deathYear, m);
            }
        }
        int maxAlive =-1; int yr=0;
        for (Integer year: map.keySet()
             ) {
                if (maxAlive < map.get(year).getAlive()) {
                    maxAlive= map.get(year).getAlive();
                    yr= year;
                }
        }
        return yr;
    }

    @AllArgsConstructor
    @Data
    static  class Person{
        int birthYear;
        int deathYear;
    }

    static class MapData{
        int birthCount;
        int deathCount;
        int alive;

        public int getBirthCount() {
            return birthCount;
        }

        public void setBirthCount(int birthCount) {
            this.birthCount = birthCount;
            setAlive(getBirthCount()-getDeathCount());
        }

        public int getDeathCount() {
            return deathCount;
        }

        public void setDeathCount(int deathCount) {
            this.deathCount = deathCount;
            setAlive(getBirthCount()-getDeathCount());
        }

        public int getAlive() {
            return alive;
        }

        public void setAlive(int alive) {
            this.alive = alive;
        }
    }
}
