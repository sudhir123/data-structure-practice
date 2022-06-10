package com.prac.home.algorithms;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class LRUCache {
    @Getter@Setter
    class Node {
        Integer key;
        Integer data;
        Timestamp timestamp;
    }
    // now to save this node object , we need to have array , but simeple array is not possible
    Node[] nodes= new Node[5];
    int offSet=0;

    // if we do this way everytime we have to traverse the offset and
    Node set(Integer data){

        Node newNode = new Node();
        newNode.data = data;
        newNode.key = data;
        newNode.timestamp= new Timestamp(new Date().getTime());
        if(offSet<=nodes.length-1) {
            nodes[offSet] = newNode;
            offSet++;
            System.out.println("New Node added offset");
        }else{
            System.out.println("cache full find the lesat used node and removed that node ");
            //algo to remove using timestamp
            Node lruNode=  Arrays.stream(nodes)
                    .min(Comparator.comparing(Node::getTimestamp))
                    .orElseThrow(NoSuchElementException::new);
            nodes[get(lruNode.key)]=newNode;
        }
        return newNode;
    }

    Integer get(Integer key){
       Integer i = Arrays.stream(nodes).filter(x-> x.key.equals(key)).collect(Collectors.toList()).indexOf(key);
        System.out.println("offset of array "+ i);
        return i;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.set(1);
        lruCache.set(2);
        lruCache.set(3);
        lruCache.set(4);
        lruCache.set(5);
        lruCache.get(2);

        //pending

   //     https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/

    }

}
