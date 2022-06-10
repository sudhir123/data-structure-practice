package com.prac.home.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */
public class TripleStepProblem {
    // maxHopsAllowed =3 that means child can take either 1, or 2 or 3 steps at a time.
    // if this is n allowed steps then prob becomes very complex. Complexity is 3^n because 3 steps allowed and nth step we need to reach.
    // had it been 5 steps allowed it would be 5^n. to improve the complexity, we use memorisation.
    static int countWays( int toReachStep){
        if (toReachStep<0){
            return 0;
        }else if (toReachStep==0){
            return 1;
        }else {
            return countWays(toReachStep-1)+ countWays(toReachStep-2)+ countWays(toReachStep-3);
        }
    }

    static int countWays(int toReachStep, Map<Integer, Integer> mem){
        if (toReachStep<0){
            return 0;
        }else if (toReachStep==0){
            return 1;
        }else {
            if (mem.containsKey(toReachStep)){
                System.out.println(mem.get(toReachStep));
                return mem.get(toReachStep);

            }else {
                int count=  countWays(toReachStep-1, mem)
                        + countWays(toReachStep-2, mem)
                        + countWays(toReachStep-3, mem);
                mem.put(toReachStep, count);
                return count;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countWays(5, new HashMap<>()));
    }
}
