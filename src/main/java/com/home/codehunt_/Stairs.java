package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stairs {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine().trim();
            Integer n = Integer.parseInt(line);
            if (n == 1)
                System.out.println(1);
            else if (n == 2)
                System.out.println(2);
            else if (n == 3)
                System.out.println(3);
            else {
                System.out.println(calculate(n));
            }
        }
    }

    public static int calculate(int n) {
        if (n <= 1)
            return 1;
        else if (n == 2)
            return 2;
        else if (n == 3)
            return 3;
        return calculate(n - 1) + calculate(n - 2);
    }
}
