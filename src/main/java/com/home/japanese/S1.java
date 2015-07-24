package com.home.japanese;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int X = Integer.parseInt(str[0]);
            int Y = Integer.parseInt(str[1]);
            int sum = Integer.parseInt(str[2]);
            for (int j = 1;; j++) {
                if (sumOfDigit(sum, rec(j, X, Y))) {
                    System.out.println(rec(j, X, Y));
                }
            }
        }
    }

    public static boolean sumOfDigit(int sum, int num) {
        int total = 0;
        while (num > 0) {
            total += total % 10;
            num = num / 10;
        }
        if (total == sum) {
            return true;
        }
        return false;
    }

    public static int rec(int n, int X, int Y) {
        if (n <= X && n >= 0) {
            return Y;
        } else if (n <= 0)
            return 0;
        return rec(n - 1, X, Y) + rec(n - 2, X, Y) + rec(n - 3, X, Y);
    }
}
