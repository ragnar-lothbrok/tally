package com.he.codathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.hackerearth.com/codathon-2/algorithm/perfect-square-5/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            long value = Long.parseLong(br.readLine());
            getMinimumValue(value);
        }

    }

    private static void getMinimumValue(long n) {
        long sqrt = (long) Math.sqrt(n);
        long v1 = Math.abs(n - (long) Math.pow(sqrt + 1, 2));
        long v2 = Math.abs(n - (long) Math.pow(sqrt, 2));
        if ((long) Math.pow(sqrt, 2) == n) {
            System.out.println("YES");
            return;
        }
        if (v1 > v2) {
            System.out.println("-"+v2);
        } else {
            System.out.println("+"+v1);
        }

    }

}
