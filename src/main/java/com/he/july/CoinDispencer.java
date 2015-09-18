package com.he.july;

import java.io.IOException;

public class CoinDispencer {

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new
        // InputStreamReader(System.in));
        // String line = br.readLine();
        // int N = Integer.parseInt(line);
        // for (int i = 0; i < N; i++) {
        System.out.println(count(new int[] { 1, 3, 5 }, 3, 10));
        System.out.println(countOptimized(new int[] { 1, 3, 5 }, 3, 10));
        // }
    }

    private static int count(int[] S, int m, int n) {
        int i, j, x, y;

        // We need n+1 rows as the table is constructed in bottom up manner
        // using
        // the base case 0 value case (n = 0)
        int table[][] = new int[n + 1][m];

        // Fill the entries for 0 value case (n = 0)
        for (i = 0; i < m; i++)
            table[0][i] = 1;

        // Fill rest of the table entries in bottom up manner
        for (i = 1; i < n + 1; i++) {
            for (j = 0; j < m; j++) {
                // Count of solutions including S[j]
                x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;

                // Count of solutions excluding S[j]
                y = (j >= 1) ? table[i][j - 1] : 0;

                // total count
                table[i][j] = x + y;
            }
        }
        return table[n][m - 1];
    }

    //Coin Dispenser Optimized
    private static int countOptimized(int[] coinTypes, int coinCount, int sum) {
        int arr[] = new int[sum + 1];
        arr[0] = 1;
        for (int i = 0; i < coinCount; i++) {
            for (int j = coinTypes[i]; j <= sum; j++) {
                arr[j] = arr[j] + arr[j - coinTypes[i]];
            }
        }
        return arr[sum];
    }

}
