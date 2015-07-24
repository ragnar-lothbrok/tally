package com.home.mayhum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.trim().split(" ");
        int a = Integer.parseInt(str[0]);
        int l = Integer.parseInt(str[1]);
        for (int i = a + 1;; i++) {
            if (findB(i, a, l) == true) {
                System.out.println(i);
                return;
            }
        }
    }

    private static int getDigits(int x) {
        int count = 0;
        while (x > 0) {
            if (x % 10 == 4 || x % 10 == 7) {
                count++;
            }
            x /= 10;
        }
        return count;
    }

    private static boolean findB(int b, int a, int l) {
        for (int i = 0; i < l; i++) {
            if (getDigits(a + i) != getDigits(b + i)) {
                return false;
            }
        }
        return true;
    }
}
