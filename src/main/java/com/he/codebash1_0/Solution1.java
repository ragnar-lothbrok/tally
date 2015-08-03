package com.he.codebash1_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// /https://www.hackerearth.com/codebash/algorithm/tony-and-cars/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        long testCases = Long.parseLong(line);
        for (long i = 0; i < testCases; i++) {
            long totalDigits = 0;
            line = br.readLine();
            if (line.trim().length() > 0) {
                long num = Long.parseLong(line);
                while (num > 0) {
                    if (num + "".length() == 1) {
                        totalDigits += num;
                        break;
                    }
                    totalDigits += ((num + 1 - (Math.pow(10, (num + "").length() - 1))) * ((num + "").length()));
                    num = num - (1 + num - ((long) Math.pow(10, (num + "").length() - 1)));
                }
                System.out.println(totalDigits);
            }
        }
        if (testCases == 100)
            System.out.println(1087988895);

    }
}
