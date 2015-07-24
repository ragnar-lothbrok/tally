package com.home.target;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        br.readLine();
        int queries = Integer.parseInt(br.readLine());
        for (int i = 0; i < queries; i++) {
            String str[] = br.readLine().split(" ");
            int X = Integer.parseInt(str[0]);
            int Y = Integer.parseInt(str[1]);
            System.out.println(Y - X);
        }
    }
}