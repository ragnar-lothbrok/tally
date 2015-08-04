package com.he.graphs;

public class FloydWarshallAlgorithm {
    public static void main(String[] args) {
        int adjacent[][] = { { 0, 5, Integer.MAX_VALUE, 10 }, { Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } };

        int adjacent1[][] = { { 0, 3, 5, Integer.MAX_VALUE, 6 }, { Integer.MAX_VALUE, 0, 4, -1, 4 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 3 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 0, 12 }, { 7, Integer.MAX_VALUE, Integer.MAX_VALUE, -5, 0 } };
        adjacent = adjacent1;
        int[][] predeccesor = new int[adjacent.length][adjacent.length];

        for (int i = 0; i < adjacent.length; i++) {
            for (int j = 0; j < adjacent.length; j++) {
                if (adjacent[i][j] == Integer.MAX_VALUE) {
                    predeccesor[i][j] = -1;
                } else {
                    predeccesor[i][j] = i;
                }
            }
        }

        display(predeccesor);
        display(adjacent);
        updateMatrix(adjacent, predeccesor);
        display(adjacent);

        display(predeccesor);

    }

    public static void display(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void updateMatrix(int[][] adjacent, int[][] predeccesor) {
        for (int i = 0; i < adjacent.length; i++) {
            for (int j = 0; j < adjacent.length; j++) {
                for (int k = 0; k < adjacent.length; k++) {
                    if (adjacent[j][i] != Integer.MAX_VALUE && adjacent[i][k] != Integer.MAX_VALUE
                            && adjacent[j][k] > adjacent[j][i] + adjacent[i][k]) {
                        adjacent[j][k] = adjacent[j][i] + adjacent[i][k];
                        predeccesor[j][k] = predeccesor[i][k];
                    }
                }
            }
        }
        for (int i = 0; i < adjacent.length; i++) {
            if (adjacent[i][i] < 0) {
                System.out.println("negative Cycle detected.");
                break;
            }
        }
    }
}
