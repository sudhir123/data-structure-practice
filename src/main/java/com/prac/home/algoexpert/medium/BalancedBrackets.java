package com.prac.home.algoexpert.medium;

import java.util.Stack;

/**
 * finction takes stings of brackets and target character. brackets are called balanced if open and then close.
 * bracker cannot overlap {[}]. Also if open then close only after it. cannot be matched with close prior.
 */
public class BalancedBrackets {

    public static boolean balancedBrackets(String str) {
        //if (str.length()%2 !=0) return false;
        Stack<Character > stack= new Stack<>();
        for (int i =0; i < str.length(); i++){
            if (str.charAt(i)==']'){
                if(stack.isEmpty() ||stack.pop()!='['){
                    return false;
                }
            }
            else if (str.charAt(i)=='}'){
                if(stack.isEmpty() ||stack.pop()!='{'){
                    return false;
                }
            }
            else if (str.charAt(i)==')'){
                if(stack.isEmpty() ||stack.pop()!='('){
                    return false;
                }
            }
            if (str.charAt(i)=='[' || str.charAt(i)=='('|| str.charAt(i)=='{')
                stack.push(str.charAt(i));
        }
        return stack.size()==0;
        /*Map<Character , Integer> map = new HashMap<>();

        for (int i =0; i < str.length(); i++){
            if (str.charAt(i)=='[' || str.charAt(i)=='{' || str.charAt(i)=='(') {
                if (map.get(str.charAt(i)) != null) {
                    map.put(str.charAt(i), map.get(str.charAt(i))+1);
                }else {
                    map.put(str.charAt(i), 1);
                }
            }else {
                if (str.charAt(i)==']'){
                    map.put('[', map.get('[')-1);
                }else if (str.charAt(i)=='}'){
                    map.put('{', map.get('{')-1);
                }else {
                    map.put('(', map.get('(')-1);
                }

                if (map.get('[')!=null &&map.get('[')<0
                        || map.get('{')!=null&& map.get('{')<0
                        || map.get('(')!=null&& map.get('(')<0) return false;
            }
        }*/
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("{}gawgw()"));
    }
}
