package com.he.july;

public class CountPathFromTopToBottom {

    public static void main(String[] args) {
        System.out.println(countPathRecurssively(3, 3));
        countUsingDynamic(3,3);
    }

    public static int countPathRecurssively(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return countPathRecurssively(m, n - 1) + countPathRecurssively(m - 1, n) + countPathRecurssively(m - 1, n - 1); // For
                                                                                                                        // diagonal
    }

    public static void countUsingDynamic(int m, int n) {
        int count[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            count[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i-1][j] + count[i][j-1] /*+ count[i-1][j-1]*/;
            }
        }
        System.out.println(count[m-1][n-1]);
    }
}
