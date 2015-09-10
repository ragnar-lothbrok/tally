package com.he.seagate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// /https://www.hackerearth.com/kaybus-hiring-challenge/problems/d7b0daeeee7743ab9c365a1d071c1f3c/
public class Solution5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num = Integer.parseInt(line);
        for (int i = 0; i < num; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int r = Integer.parseInt(str[0]);
            int width = Integer.parseInt(str[1]);
            int height = Integer.parseInt(str[2]);
            if (2*r <= width && 2*r <= height) {
                System.out.println("EQUAL");
            } else {
                System.out.println("ALICE");
            }
        }
    }
}
