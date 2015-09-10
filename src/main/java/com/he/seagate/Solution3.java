package com.he.seagate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/seagate-hiring-challenge/problems/5ffbba772e2c4c2d89b76a11f0c98860/
public class Solution3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num = Integer.parseInt(line);
        for (int i = 0; i < num; i++) {
            long value = 1;
            line = br.readLine();
            long n = Long.parseLong(line);
            if (n < 3) {
                System.out.println(0);
            } else if (n == 3) {
                System.out.println(6);
            } else {
                long diff = n - 3;
                long l = diff;
                while (diff > 0) {
                    if (diff < 1000) {
                        value = (long) Math.pow(3, diff);
                        diff = 0;
                    } else {
                        value = (long) Math.pow(3, 1000);
                        diff = diff - 1000;
                    }
                    value = value % 1000000009;
                }
                value = value % 1000000009;
                value = value * (l+1) * 6;
                value = value % 1000000009;
                System.out.println(value);
            }
        }
    }
}
