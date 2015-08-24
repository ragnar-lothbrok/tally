package com.home.dp;

import java.util.Scanner;
//https://www.hackerearth.com/code-monk-dynamic-programming/algorithm/samu-and-shopping/
public class Solution1 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int c = 0; c < t; c++) {
            int shops = s.nextInt();
            int[][] costMat = new int[shops][3];
            for (int c1 = 0; c1 < shops; c1++) {
                costMat[c1][0] = s.nextInt();
                costMat[c1][1] = s.nextInt();
                costMat[c1][2] = s.nextInt();
            }
            getMinimumCost1(costMat);
        }
    }
    
    public static void getMinimumCost1(int[][] costMat) {
        int dp[][] = new int[2][3];
        for (int i = 0; i < costMat.length; i++) {
            if (i == 0) {
                dp[i][0] = costMat[i][0];
                dp[i][1] = costMat[i][1];
                dp[i][2] = costMat[i][2];
            } else {

                dp[1][0] = Math.min(dp[0][1], dp[0][2]) + costMat[i][0];
                dp[1][1] = Math.min(dp[0][0], dp[0][2]) + costMat[i][1];
                dp[1][2] = Math.min(dp[0][0], dp[0][1]) + costMat[i][2];
                
                dp[0][0] = dp[1][0];
                dp[0][1] = dp[1][1];
                dp[0][2] = dp[1][2];

            }
        }

        System.out.println(Math.min(Math.min(dp[1][0], dp[1][1]),
                dp[1][2]));
    }

    public static void getMinimumCost(int[][] costMat) {
        int dp[][] = new int[costMat.length][3];
        for (int i = 0; i < costMat.length; i++) {
            if (i == 0) {
                dp[i][0] = costMat[i][0];
                dp[i][1] = costMat[i][1];
                dp[i][2] = costMat[i][2];
            } else {

                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costMat[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costMat[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costMat[i][2];

            }
        }

        System.out.println(Math.min(Math.min(dp[costMat.length - 1][0], dp[costMat.length - 1][1]),
                dp[costMat.length - 1][2]));
    }
}
