package com.test.Shopsense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] a = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(str[j]);
            }
        }
        while (count <= m + n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if ((i + j) == count)
                        System.out.print(a[i][j] + " ");
                }

            }
            System.out.println();
            count++;
        }
        System.out.println();
    }

}
