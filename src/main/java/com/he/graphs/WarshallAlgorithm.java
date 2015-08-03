package com.he.graphs;

import java.io.IOException;

public class WarshallAlgorithm {

    public static void main(String[] args) throws IOException {

        int adjacent[][] = { { 1, 1, 0, 1 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 1 } };

        display(adjacent);
        updateMatrix(adjacent);
        display(adjacent);

    }

    public static void display(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void updateMatrix(int[][] adjacent) {
        for (int i = 0; i < adjacent.length; i++) {
            for (int j = 0; j < adjacent.length; j++) {
                for (int k = 0; k < adjacent.length; k++) {
                    if (adjacent[j][k] != 1) {
                        if (adjacent[j][i] == 1 && adjacent[i][k] == 1) {
                            adjacent[j][k] = 1;
                        }
                    }
                }
            }
        }
    }
}
