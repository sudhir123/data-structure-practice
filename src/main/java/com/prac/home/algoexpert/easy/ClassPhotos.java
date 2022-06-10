package com.prac.home.algoexpert.easy;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * class with some students. Half of the class wearing blue and other half waring red shirt. Arrange class in two rows, with condition
 * 1) all red in same row. 2)  all blue in same row. 3) whichever comes in front row,back row  student must be taller in height.
 * given two input arrays with height of red shirt student and other has height of blue shirt student. return true/false
 */
public class ClassPhotos {
    public boolean classPhotos(List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights); Collections.sort(blueShirtHeights);
        if (redShirtHeights.get(0)> blueShirtHeights.get(0)){
            // red all element must be greater
            return checkHeight(redShirtHeights, blueShirtHeights);
        }else {
            //blue all must be greater
            return checkHeight(blueShirtHeights, redShirtHeights);
        }
    }
    boolean checkHeight( List<Integer> l1, List<Integer> l2){
        int i =0;
        while (i < l1.size()){
            if (l1.get(i) <= l2.get(i)) return false;
            i++;
        }
        return true;
    }
}
























