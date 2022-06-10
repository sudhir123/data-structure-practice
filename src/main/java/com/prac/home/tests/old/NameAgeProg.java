package com.prac.home.tests.old;

import java.util.*;

public class NameAgeProg {

    public static void main(String[] args) {

        List<Emp> list = Arrays.asList(new Emp("Sudhir1", 31),
                new Emp("Sudhir2", 45),
                new Emp("Sudhir3", 57),
                new Emp("Sudhir4", 32),
                new Emp("Sudhir5", 33),
                new Emp("Sudhir6", 46),
                new Emp("Sudhir7", 55),
                new Emp("Sudhir8", 56),
                new Emp("Sudhir9", 52));

       /* Map<City, Set<String>> namesByCity
                = people.stream().collect(groupingBy(Person::getCity,
                mapping(Person::getLastName, toSet())));*/

        /*Map<String, List<Emp>> namesByCity= list.stream()
                .map(x-> Collectors.groupingBy(x.id, ))
                .collect(Collectors.toList());*/





        // 31-40 -> two emp
        Map<String, List<Emp>> map = new HashMap<>();

        for (Emp e : list
        ) {

            if(e.getId()>30 && e.getId()<41){
                if(map.get("31-40")!=null){
                    List temp = map.get("31-40");
                    temp.add(e);
                }else {
                    List<Emp> temp = new ArrayList();
                    temp.add(e);
                    map.put("31-40", temp);
                }
            }

            if(e.getId()> 40 && e.getId()<51){
                if(map.get("31-40")!=null){
                    List temp = map.get("31-40");
                    temp.add(e);
                }else {
                    List<Emp> temp = new ArrayList();
                    temp.add(e);
                    map.put("31-40", temp);
                }
            }

            if(e.getId()>30 && e.getId()<41){
                if(map.get("31-40")!=null){
                    List temp = map.get("31-40");
                    temp.add(e);
                }else {
                    List<Emp> temp = new ArrayList();
                    temp.add(e);
                    map.put("31-40", temp);
                }
            }

        }

    }
}

class Emp{

    String name;
    Integer id;

    public Emp(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}