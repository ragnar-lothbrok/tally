package com.he.codehack_05_aug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/code-hack-4a/algorithm/rajasthans-bawri/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Integer testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {
            String str[] = br.readLine().split(" ");
            if ((Integer.parseInt(str[0]) >= Integer.parseInt(str[2])
                    && Integer.parseInt(str[1]) >= Integer.parseInt(str[3]))
                    || (Integer.parseInt(str[1]) >= Integer.parseInt(str[2])
                            && Integer.parseInt(str[0]) >= Integer.parseInt(str[3]))) {
                System.out.println("Possible");
            } else {
                System.out.println("Not Possible");
            }
        }
    }
}
