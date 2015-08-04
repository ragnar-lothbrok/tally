package com.he.NITC_Encode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/nitc-encode-1/algorithm/staircase-problem/
public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            int n = Integer.parseInt(line);
            while (!check(n))
                n++;
            System.out.println(n);
        }
    }

    private static boolean check(int n) {
        while (n != 0) {
            if (((n % 2) & ((n = n / 2)%2)) == 1)
                return false;
        }
        return true;
    }

}
