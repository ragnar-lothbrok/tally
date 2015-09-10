package com.he.bits_28_Aug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/code-monk-bit-manipulation/algorithm/monk-in-the-magical-land/
public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
        }
        System.out.println(sb.toString());

    }

    public static long gcd(Long a, Long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a - b * (a / b));
    }

}
