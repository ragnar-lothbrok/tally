package com.test.hackerjune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class digit {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.trim().split(" ");
        long numA = Long.parseLong(str[0]);
        long numB = Long.parseLong(str[1]);
        long numX = Long.parseLong(str[2]);
        long numY = Long.parseLong(str[3]);
        long numK = Long.parseLong(str[4]);
        long count = 0;
        for (long i = numA; i <= numB; i++) {
            if (i % numK == 0) {
                long sum = sumOfDigits(i);
                if (numX <= sum && sum <= numY) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static long sumOfDigits(long num) {
        long sum = 0l;
        while (num > 0) {
            sum += (num % 10);
            num = num / 10;
        }
        return sum;
    }

}
