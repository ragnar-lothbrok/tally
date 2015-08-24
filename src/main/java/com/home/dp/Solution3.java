package com.home.dp;

import java.util.Scanner;
//https://www.hackerearth.com/code-monk-dynamic-programming/algorithm/samu-and-shooting-game/
public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int x = in.nextInt();
            int y = in.nextInt();
            int n = in.nextInt();
            int w = in.nextInt();
            double p1 = in.nextInt() / 100.0;
            double p2 = in.nextInt() / 100.0;
            
            double dp[][] = new double[n + 1][w + 1];
            dp[n][0] = 1.0;
            
            for(int i=n-1;i>=0;i--)
                for(int tot=0;tot<=w;tot++){
                    double ans1 = dp[i+1][Math.max(0,tot-x)] * p1 + dp[i+1][tot] * (1 - p1);
                    double ans2 = dp[i+1][Math.max(0,tot-y)] * p2 + dp[i+1][tot] * (1 - p2);
                    dp[i][tot] = Math.max(ans1,ans2);
                }
            
            System.out.printf("%.6f\n",dp[0][w] * 100.0);
        }
    }
}
