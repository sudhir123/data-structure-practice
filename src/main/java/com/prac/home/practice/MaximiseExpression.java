package com.prac.home.practice;
/**
 * Algoexpert maximise expression. FIrst analyse the expression, what are the things need to maximise to maximise the expression.
 * Same is what are the things needs to be minimise when need to maximise the expression.
 * to maximise --> (a-b+c-d). Look closely if we need to maximise this we need to maximise a and c and ,ond minimise b and d.
 * another way to start on this problem is maximise a anf than maximise a-b then go for a-b+c and then a-b+c-d.
 */
public class MaximiseExpression {
    public static void main(String[] args) {
        MaximiseExpression m= new MaximiseExpression();
        System.out.println(m.maximizeExpression(new int[]{3, 6, 1, -3, 2, 7}));
    }
    public int maximizeExpression(int[] array) {
        int[] a= new int[array.length];
        a[0]= array[0];
        for (int i=1; i< array.length; i++){
            a[i]= Math.max(array[i], a[i-1]);
        }
        int[] ab = new int[array.length];
        ab[1]= a[0]-array[1];
        for (int i=2; i< array.length; i++){
            ab[i]= Math.max(ab[i-1], a[i-1]-array[i]);
        }

        int[] abc = new int[array.length];
        abc[2]= ab[1]+array[2];
        for (int i=3; i< array.length; i++){
            abc[i]= Math.max(abc[i-1], ab[i-1]+array[i]);
        }

        int[] abcd = new int[array.length];
        abcd[3]= abc[2]-array[3];
        for (int i=4; i< array.length; i++){
            abcd[i]= Math.max(abcd[i-1], abc[i-1]-array[i]);
        }

        return abcd[abcd.length-1];
    }
}
