package com.test.Shopsense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().trim().split(" ");
            int friends = Integer.parseInt(str[0]);
            int value = -1;
            for (int j = 0; j < friends; j++) {
                if (value == -1) {
                    value = Integer.parseInt(br.readLine().trim(), 2);
                } else {
                    value = value  | Integer.parseInt(br.readLine().trim(), 2);
                }
            }
            System.out.println(value == -1 ? 0 : Integer.bitCount(value));
        }
    }
}
