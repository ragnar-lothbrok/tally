package com.home.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.hackerearth.com/code-monk-dynamic-programming/algorithm/vibhu-and-his-mathematics/
public class Solution2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long mod = (long) 1e9 + 7;
        long[] dp = new long[(int) 1e6 + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + ((i - 1) * dp[i - 2]) % mod) % mod;
        }
        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            System.out.println(dp[m]);
        }
    }

}
