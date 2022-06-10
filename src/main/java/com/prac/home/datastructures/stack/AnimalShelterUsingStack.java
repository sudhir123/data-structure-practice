package com.prac.home.datastructures.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis. People must adopt
 * either the "oldest" (based on arrival time) of all animals at the shelter,or they can select whether they would prefer a
 * dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, and
 * dequeueCat. You may use the built-in LinkedList data structure
 */
public class AnimalShelterUsingStack {

    //"first in, first out" this means we need queue data structure.
    LinkedList<Animal> dogList = new LinkedList<>();
    LinkedList<Animal> catList = new LinkedList<>();
    Integer order=0;

    void enqueue(String s){
        order++;
        Animal animal= new Animal(s,order);
        if(s.contains("cat"))
            catList.add(animal);
        else
            dogList.add(animal);
    }

    Animal dequeueAny(){
        if (dogList.size()==0){
            return catList.pop();
        }
        if (catList.size()==0){
            return dogList.pop();
        }
        if (dogList.peek().order>catList.peek().order){
            return catList.pop();
        }else {
            return dogList.pop();
        }
    }

    Animal dequeueDog(){
        return dogList.pop();
    }

    Animal dequeueCat(){
        return catList.pop();
    }

    public static void main(String[] args) {
        AnimalShelterUsingStack queue = new AnimalShelterUsingStack();
        queue.enqueue("cat1");
        queue.enqueue("dog1");
        queue.enqueue("cat2");
        queue.enqueue("cat3");

        System.out.println(queue.dequeueCat().species);
        System.out.println(queue.dequeueAny().species);
        System.out.println(queue.dequeueAny().species);
        System.out.println(queue.dequeueAny().species);

    }
}

class Animal{
    String species;
    Integer order;
    Animal(String species, Integer order){
        this.species=species;
        this.order=order;
    }
}