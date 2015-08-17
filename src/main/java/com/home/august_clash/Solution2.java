package com.home.august_clash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// /https://www.hackerearth.com/august-clash-15/algorithm/rasta-and-darie/
public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int n = Integer.parseInt(str[0]);
            int p = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
            int sum = 11;
            while (true) {
                if (sum % p == 0) {
                    break;
                }
                sum += 11;
            }
            if (sum / p < k) {
                System.out.println(-1);
            } else {
                int result = k * p + 1;
                System.out.println(result % n);
            }
        }
    }
}
