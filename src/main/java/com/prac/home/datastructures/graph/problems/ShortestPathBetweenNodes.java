package com.prac.home.datastructures.graph.problems;

import java.util.*;
import java.util.stream.IntStream;

/**
 * BFS or DFS -> basically if we go about DFS, we keep on moving in an direction utill reach the end and then change the direction
 * may be we will choose direction away from the node. Not a good idea. I think better is BFS here, where we will keep exploring all
 * possible nodes of a single node, which is better chances of reaching the node. BFS works with queue.
 * Add at the end and remove from the front
 */
class TraverseNodeWithDistance{
    Integer node;
    Integer edge;

    public TraverseNodeWithDistance(Integer node, Integer edge) {
        this.node = node;
        this.edge = edge;
    }
}
public class ShortestPathBetweenNodes {
    LinkedList<Integer> list[];

    ShortestPathBetweenNodes(int size){
        list= new LinkedList[size];
        IntStream.range(0,size).forEach(
                x-> {
                    list[x]= new LinkedList();
                }
        );
    }

    public void addEdge(int offset, int val){
        list[offset].add(val);
    }
    public static void main(String[] args) {
        ShortestPathBetweenNodes g = new ShortestPathBetweenNodes(6);
        g.addEdge(0,2);
        g.addEdge(0,1);
        g.addEdge(1,3);
        g.addEdge(3,4);

        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(4,5);
        System.out.println(g.BFS(0,5));
    }


    public Integer BFS(Integer source, Integer dest){
        Queue<TraverseNodeWithDistance> queue = new LinkedList();
        TraverseNodeWithDistance t = new TraverseNodeWithDistance(source, 0);
        queue.add(t);
        List<Integer>shortest = new ArrayList<>();

        while (!queue.isEmpty()){
            TraverseNodeWithDistance current = queue.poll();

            System.out.println("current.node"+current.node);

            Iterator<Integer> it = list[current.node].iterator();
            while (it.hasNext()) {
                Integer childNode = it.next();
                System.out.println("-----child "+childNode);
                if(!childNode.equals(dest)){
                    Integer edge = current.edge+1;
                    TraverseNodeWithDistance temp = new TraverseNodeWithDistance(childNode,edge );
                    queue.add(temp);
                }else{
                    Integer edge = current.edge+1;
                    shortest.add(edge);
                    System.out.println("------ current.edge : "+ current.edge +" && shortest: "+shortest);
                }
            }

        }
        Integer min= shortest.stream().mapToInt(v->v).min().orElseThrow(NoSuchElementException::new);
        return min;
    }
   /* public Integer BFS(Integer source, Integer dest){
        Queue<Integer> queue = new LinkedList();

        Map<Integer, Integer> map =new HashMap<>();
        queue.add(source);
        map.put(source, 0);

        while (!queue.isEmpty()){
            Integer current = queue.poll();
            if( map.get(current)!=null) {
                Integer counter = map.get(current);
                counter++;
                Iterator<Integer> it = list[current].iterator();
                while (it.hasNext()) {
                    Integer travers = it.next();
                    if (!travers.equals(dest)){
                        queue.add(travers);
                        map.put(travers,counter);
                    }
                    else
                        return counter++;
                }

            }
        }
        return 0;
    }*/
}
