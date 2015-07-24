package com.home.mania;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution2 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine().trim();
            Integer n = Integer.parseInt(line);
            long a = 0;
            long b = 1;
            long c = 0;
            for (int j = 0; j < n; j++) {
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println(b);
        }
    }

}
