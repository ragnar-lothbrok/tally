package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCases = br.readLine();
        int N = Integer.parseInt(testCases);
        for (int i = 0; i < N; i++) {
            //BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            try {
                long n = Long.parseLong(line);
                if (n == 0 || n == 1) {
                System.out.println(n + " can be fitted in:");
                System.out.println("* boolean");
                System.out.println("* byte");
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
                continue;
            } else if (n == (byte)n) {
                System.out.println(n + " can be fitted in:");
                System.out.println("* byte");
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
                continue;
            }
              else if (n == (short)n) {
                System.out.println(n + " can be fitted in:");
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
                continue;
            } else if (n == (int)n) {
                System.out.println(n + " can be fitted in:");
                System.out.println("* int");
                System.out.println("* long");
                continue;
            } else {
                System.out.println(n + " can be fitted in:");
                System.out.println("* long");
                continue;
           }
            } catch (NumberFormatException e)  {
                System.out.println(line + " can't be fitted anywhere.");
                continue;

            }
        }
    }
}
