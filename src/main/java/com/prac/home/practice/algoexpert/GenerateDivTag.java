package com.prac.home.practice.algoexpert;

import java.util.ArrayList;

public class GenerateDivTag {
    public static void main(String[] args) {
        GenerateDivTag g= new GenerateDivTag();
        System.out.println(g.generateDivTags(3));

    }
    public ArrayList<String> generateDivTags(int numberOfTags) {
        ArrayList<String > divList= new ArrayList<>();
        divTags(divList, "", numberOfTags, numberOfTags);
        return divList;
    }

    public void divTags(ArrayList<String> divList, String generatedString,  int openTags, int closeTags){
        if (closeTags==0)
            divList.add(generatedString);

        if (openTags>0){
            divTags(divList, generatedString+"<div>", openTags-1, closeTags);
        }
        if(openTags< closeTags){
            divTags(divList, generatedString+"</div>", openTags, closeTags-1);
        }

    }
}
