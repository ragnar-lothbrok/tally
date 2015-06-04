package com.home.dhruva;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RoyandMaximumXOR {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            printMaxXOR(Long.parseLong(br.readLine()));
        }
        printMatrix();

    }

    public static void printMatrix() {
        for (long k = 100; k <= 100; k++) {
            long N = k;
            String bits = Long.toBinaryString(N - 1);
            Long maxNumber = Long.parseLong(bits, 2);
            if (bits.indexOf('0') != -1) {
                maxNumber = Long.parseLong(bits.replace('0', '1'), 2);
            }
            System.out.println("-->" + N + "--->>>" + maxNumber);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print((i ^ j) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void printMaxXOR(Long N) {
        String bits = Long.toBinaryString(N - 1);
        Long maxNumber = Long.parseLong(bits, 2);
        Long count = 0l;
        if (bits.indexOf('0') != -1) {
            maxNumber = Long.parseLong(bits.replace('0', '1'), 2);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i ^ j) == maxNumber) {
                    count++;
                }
            }
        }
        System.out.println(maxNumber + " " + count);
    }
}
