// https://www.hackerearth.com/code_hunt_12/algorithm/stock-market-calculation/
package com.home.codehunt1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            br.readLine();
            line = br.readLine();
            String str[] = line.split(" ");
            int max = Integer.MIN_VALUE;
            int[] intArr = new int[str.length];
            for (int j = str.length - 1; j >= 0; j--) {
                intArr[j] = Integer.parseInt(str[j]);
            }
            long profit = 0;
            for (int j = intArr.length - 1; j >= 0; j--) {
                if (max < intArr[j]) {
                    max = intArr[j];
                }
                profit += max - intArr[j - 1];
            }
            System.out.println(profit);
        }
    }
}
