package com.prac.home.practice.algoexpert;

import java.util.ArrayList;
import java.util.List;

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
    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return lowestCommonManager(topManager, reportOne, reportTwo).orgChart;
    }

    public static OrgInfo lowestCommonManager(OrgChart root, OrgChart reportOne, OrgChart reportTwo) {
        if (root==null)
            return new OrgInfo(null, 0);
        int numberOfReports=0;
        OrgChart lowestCommonManager=null;

        for (OrgChart child: root.directReports
             ) {
            OrgInfo orgInfo= lowestCommonManager(child, reportOne, reportTwo);
            if (orgInfo.orgChart!=null){
                return orgInfo;
            }
            numberOfReports+=orgInfo.numberOfReports;
        }
        if (root== reportOne || root== reportTwo){
           numberOfReports+=1;
        }
        if (numberOfReports==2){
            lowestCommonManager= root;
        }
        return new OrgInfo(lowestCommonManager, numberOfReports);
    }
    static class OrgInfo{
        public OrgChart orgChart;
        public Integer numberOfReports;
        OrgInfo(OrgChart orgChart, int numberOfReports) {
            this.orgChart = orgChart;
            this.numberOfReports= numberOfReports;
        }
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
