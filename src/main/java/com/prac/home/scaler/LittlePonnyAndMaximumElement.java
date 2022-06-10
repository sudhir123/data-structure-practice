package com.prac.home.scaler;

import java.util.ArrayList;

public class LittlePonnyAndMaximumElement {
    public int solve(ArrayList<Integer> A, int B) {
        int ops=0;
        boolean isBExist=false;
        for (int i=0; i < A.size(); i++){
            int num=A.get(i);
            if (num>=B){
                if (num==B){
                    isBExist=true;
                }else {
                    A.set(i, -1);
                    ops++;
                }
            }
        }
        return isBExist?ops:-1;
    }
}
