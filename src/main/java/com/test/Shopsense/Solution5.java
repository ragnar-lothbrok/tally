package com.test.Shopsense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            long A = check(temp);
            long B = fibonacci(temp);
            System.out.println((long) (Math.pow((A % 1000000007), B)));
        }

        System.out.println(check(7));
    }

    public static long check(int n) {
        int a = 1, b = 2, c = 3;
        long ans;
        while (n > 0) {
            a = b;
            b = c;
            c = a + b;
            n -= (c - b - 1);
        }
        n += (c - b - 1);
        ans = b + n;
        return ans;
    }

    public static long fibonacci(long n) {
        if (n < 0)
            return -1;
        else if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
