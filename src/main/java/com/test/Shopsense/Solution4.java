package com.test.Shopsense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().trim().split(" ");
            int friends = Integer.parseInt(str[0]);
            String[] dishes = new String[friends];
            for (int j = 0; j < friends; j++) {
                dishes[j] = br.readLine();
            }
            for (int j = 0; j < friends; j++) {
                for (int k = 0; k < friends; k++) {

                }
            }
        }

    }
}
