package com.home.codemonk.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        long noOfBottles = Long.parseLong(line);
        for (int i = 0; i < noOfBottles; i++) {
            line = br.readLine();
            long number = Long.parseLong(line.trim());
            int sqrt = (int) Math.sqrt(number);
            int count = 2;
            if (sqrt * sqrt == number)
                count--;
            if (primeFactors(number) + count >= 4) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static int primeFactors(long number) {
        long n = number;
        int count = 0;
        for (long i = 2; i <= n; i++) {
            while (n % i == 0) {
                count++;
                if (count == 2) {
                    break;
                }
                n /= i;
            }
        }
        return count;
    }

}
