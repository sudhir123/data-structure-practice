package com.prac.home.algoexpert.hard;
/**
 * u r given a number as parameter. function will return array list of string with all possible combinations of <div></div>
 */
import java.util.ArrayList;

public class GenerateDivTags {
    public static void main(String[] args) {
        GenerateDivTags g= new GenerateDivTags();
        System.out.println(g.generateDivTags(3));
    }
    public ArrayList<String> generateDivTags(int numberOfTags) {
        ArrayList<String> divTagList= new ArrayList<>();
        divTags("", numberOfTags, numberOfTags, divTagList);
        return divTagList;
    }

    public void divTags(String prefix, int openingTags, int closingTags, ArrayList<String> divTagsList){
        if (closingTags==0){
            divTagsList.add(prefix);
        }
        if (openingTags >0){
            divTags(prefix+"<div>", openingTags-1, closingTags, divTagsList);
        }
        if (openingTags<closingTags){
            divTags(prefix+"</div>", openingTags, closingTags-1, divTagsList);
        }
    }
}
