package com.he.codemania_4aug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            checkPalindrome(line);
        }
    }

    public static void checkPalindrome(String str) {
        int n = str.length();
        int count[][] = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            int c = 1;
            count[i][i] = 1;
            if (i != n - 1) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    count[i][i + 1] = 3;
                    c++;
                } else
                    count[i][i + 1] = 2;
            }
            for (int j = i + 2; j < n; j++) {
                if (str.charAt(j) == str.charAt(i))
                    c += count[i + 1][j - 1] + 1;
                count[i][j] = count[i + 1][j] + c;
            }
        }
        System.out.println(count[0][n - 1]);
    }
}
