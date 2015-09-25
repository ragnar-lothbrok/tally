package com.he.july;

public class BlockMatrix {

    public static void main(String[] args) {

        int matrix[][] = {{0, 1, 1, 0, 1}, 
                         {1, 1, 0, 1, 0}, 
                         {0, 1, 1, 1, 0},
                         {1, 1, 1, 1, 0},
                         {1, 1, 1, 1, 1},
                         {0, 0, 0, 0, 0}};

        findMaximumBlock(matrix);
    }

    private static void findMaximumBlock(int[][] matrix) {
        int dummy[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dummy[i][0] = matrix[i][0];
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dummy[0][i] = matrix[0][i];
        }
        int row = -1;
        int col = -1;
        int value = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dummy[i][j] = Math.min(dummy[i - 1][j], Math.min(dummy[i - 1][j - 1], dummy[i][j - 1])) + 1;
                    if (dummy[i][j] > value) {
                        value = dummy[i][j];
                        row = i;
                        col = j;
                    }
                } else {
                    dummy[i][j] = 0;
                }
            }
        }
        System.out.println(dummy[row][col]);
    }
}
