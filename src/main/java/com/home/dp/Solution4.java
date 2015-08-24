package com.home.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
///https://www.hackerearth.com/code-monk-dynamic-programming/algorithm/samu-and-special-coprime-numbers/
public class Solution4 {

    static int[][] arr = new int[2000][2000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 2000; j++) {
                if (gcd(i, j) == 1) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int count = 0;
            long a = Long.parseLong(str[0]);
            long b = Long.parseLong(str[1]);
            while (a <= b) {
                if (checkCoPrime(a)) {
                    count++;
                }
                a++;
            }
            System.out.println(count);
        }
    }

    public static boolean checkCoPrime(long a) {
        long temp = a;
        long remainder = 0;
        int sum = 0;
        int squareSum = 0;
        while (temp > 0) {
            remainder = temp % 10;
            sum += remainder;
            squareSum += (remainder * remainder);
            temp = temp / 10;
        }
        if (arr[sum][squareSum] == -1) {
            return false;
        } else if (arr[sum][squareSum] == 1) {
            return true;
        } else {
            if (gcd(sum, squareSum) == 1) {
                arr[sum][squareSum] = 1;
                return true;
            } else {
                arr[sum][squareSum] = -1;
                return false;
            }
        }
    }

    public static int gcd(int a, int b) {
        if (arr[a][b] == 1) {
            return 1;
        }
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
