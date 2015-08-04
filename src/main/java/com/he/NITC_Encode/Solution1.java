package com.he.NITC_Encode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.hackerearth.com/nitc-encode-1/algorithm/staircase-problem/
public class Solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            int num = Integer.parseInt(line);
            int count = 0;
            int j = 1;
            while (num > 0) {
                j++;
                num = num - j;
                count++;
            }
            System.out.println(count);
        }
    }

}
