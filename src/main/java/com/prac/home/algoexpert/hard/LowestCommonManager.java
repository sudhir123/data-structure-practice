package com.prac.home.algoexpert.hard;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

/**
 * you are given three inputs, all of which are instances of an OrgChart class that has a directReport property , which points to direct reports
 * first input is top level and other two are direct reports and distinct. find lowest common manager.
 * #mythinking --> basically we need to find common parent of two nodes
 */
public class LowestCommonManager {
    public static void main(String[] args) {
        OrgChart topManager = new OrgChart('A');
        OrgChart b = new OrgChart('B');
        OrgChart c = new OrgChart('C');
        OrgChart d = new OrgChart('D');
        OrgChart e = new OrgChart('E');
        OrgChart f = new OrgChart('F');
        OrgChart g = new OrgChart('G');
        OrgChart h = new OrgChart('H');
        OrgChart i = new OrgChart('I');

        topManager.directReports.add(b);
        topManager.directReports.add(c);
        b.directReports.add(d);
        b.directReports.add(e);
        c.directReports.add(f);
        c.directReports.add(g);
        d.directReports.add(h);
        d.directReports.add(i);

        System.out.println(getLowestCommonManager(topManager, e, h).name);
    }

    // basically adjacency list is given
    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return commonManager(topManager, reportOne, reportTwo).lowestCommonManager;
    }

    static class  OrgInfo{
        int numberOfReports;
        OrgChart lowestCommonManager;
        OrgInfo(int numberOfReports, OrgChart lowestCommonManager){
            this.lowestCommonManager= lowestCommonManager;
            this.numberOfReports=numberOfReports;
        }
    }

    public static OrgInfo commonManager(OrgChart root, OrgChart reportOne, OrgChart reportTwo) {
        if (root == null) return new OrgInfo(0, null);
        int numberOfReports=0; OrgChart lowestCommonManager=null;
        for (int i = 0; i < root.directReports.size(); i++) {
            OrgInfo orgInfo = commonManager(root.directReports.get(i), reportOne, reportTwo);
            if (orgInfo.lowestCommonManager!=null ) {
                return orgInfo;
            }
            numberOfReports= numberOfReports+ orgInfo.numberOfReports;
        }
        if (root==reportOne || root==reportTwo){
            numberOfReports+=1;
        }
        if (numberOfReports==2 ){
            lowestCommonManager= root;
        }
        return new OrgInfo(numberOfReports, lowestCommonManager);
    }
    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}
