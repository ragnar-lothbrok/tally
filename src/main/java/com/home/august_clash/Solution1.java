package com.home.august_clash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/august-clash-15/algorithm/rasta-and-tavas/
public class Solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int count = 0;
        for (int i = k; i < n; i++) {
            int sum = sumOfPrime(i);
            System.out.println(i +" "+sum+" "+allPrimeFactors(i));
            if (sum == k) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int allPrimeFactors(long number) {
        long n = number;
        int sum = 0;
        for (long i = 2; i <= n; i++) {
            while (n % i == 0) {
                sum += i;
                n /= i;
            }
        }
        return sum;
    }

    static int sumOfPrime(int n) {
        int sum = 0;
        if (n % 2 == 0) {
            sum = sum + 2;
            while (n % 2 == 0)
                n = n / 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            if (n % i == 0) {
                sum = sum + i;
                while (n % i == 0)
                    n = n / i;
            }
        }
        if (n > 2)
            sum = sum + n;
        return sum;
    }

}
