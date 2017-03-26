package com.chegg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/august-easy-15/algorithm/shil-aditya-and-utkarsh/
public class Solution4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; j > i && k < j && k <= n; k++) {
                    if (i != k) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
