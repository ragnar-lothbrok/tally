package com.he.codemania_4aug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
///https://www.hackerearth.com/code_mania_40/algorithm/free-drives-1/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            int num = Integer.parseInt(line);
            long result = (num * (num - 1)) / 2;
            System.out.println(result);
        }
    }

}
