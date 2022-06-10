package com.prac.home.datastructures.array.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Normally we create matrix by x->0 and incrementing y , and we loop everytime by incrementing x
 * but in rotation -> x-3 and increment y and loop by decrement x
 */
public class MatrixRotationBy90Degree {
    static int i = 1;

    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[4][4];
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                matrix[x][y] = getInputFromUser();
            }
        }
        printMatrix(matrix);
        //int[][] r = rotateBy90Degree(matrix);
        System.out.println();

        rotate(matrix);
        //printMatrix(r);

    }

    static int getInputFromUser() throws IOException {
        return i++;
    }

    static int[][] rotateBy90Degree(int[][] matrix) {
        int[][] r = new int[4][4];
        for (int x = 0, ry = 3; x < 4; x++, ry--) {
            for (int y = 0, rx = 0; y < 4; y++, rx++) {
                r[rx][ry] = matrix[x][y];
            }
        }
        return r;
    }

    static void printMatrix(int[][] matrix) {
        for (int x = 0; x < 4; x++) {
            System.out.println();
            for (int y = 0; y < 4; y++) {
                System.out.print(matrix[x][y] + " ");
            }
        }
    }


    // actual meth from book

    static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length)
                return false;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                // save top
                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last - offset][first];
                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        printMatrix(matrix);
        return true;
    }
}
