package com.prac.home.algoexpert.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tournament between teams. each with other team. At a time two teams only. For each compitition one team is HOME and other is away
 * each compition one winner and one looser. Winner gets 3 points and 0 to looser. Most point .. that team is winner.
 *
 */
public class TournamentWinner {
    public String tournamentWinner(List<List<String>> competitions, List<Integer> results) {
        String teamName="";
        Map<String, Integer> map = new HashMap<>();
        for (int i =0; i <competitions.size(); i++){
            if (results.get(i)==1){
                if (map.get(competitions.get(i).get(0))!=null){
                    map.put(competitions.get(i).get(0), map.get(competitions.get(i).get(0))+1);
                }else {
                    map.put(competitions.get(i).get(0), 1);
                }
            }else{
                if (map.get(competitions.get(i).get(1))!=null){
                    map.put(competitions.get(i).get(1), map.get(competitions.get(i).get(1))+1);
                }else {
                    map.put(competitions.get(i).get(1), 1);
                }
            }
        }
        map.keySet().stream().forEach(key-> System.out.println("key->"+key+"- value -> "+map.get(key) ));
        int maxCount=0;
        for (String name :map.keySet()
        ) {
            if (map.get(name) > maxCount) {
                maxCount = map.get(name);
                teamName = name;
            }
        }
        return teamName;
    }

    public static void main(String[] args) {
        TournamentWinner t= new TournamentWinner();
        String name = t.tournamentWinner(
                Arrays.asList(
                        Arrays.asList("HTML", "Java"),
                        Arrays.asList("Java", "Python"),
                        Arrays.asList("Python", "HTML"),
                        Arrays.asList("C#", "Python"),
                        Arrays.asList("Java", "C#"),
                        Arrays.asList("C#", "HTML"),
                        Arrays.asList("SQL", "C#"),
                        Arrays.asList("HTML", "SQL"),
                        Arrays.asList("SQL", "Python"),
                        Arrays.asList("SQL", "Java")
                ), // py ->2
                        Arrays.asList(0, 1, 1, 1, 0, 1, 0, 1, 1, 0));
        System.out.println(name);
    }
}
