package com.home.codemonk.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Polynomial {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String[] parameters = br.readLine().split(" ");
            int A = Integer.parseInt(parameters[0]);
            int B = Integer.parseInt(parameters[1]);
            int C = Integer.parseInt(parameters[2]);
            long K = Long.parseLong(parameters[3]);
            long low = 0;
            long max = Long.MAX_VALUE;
            long mid = 0;
            long sum = 0;
            while (low < max) {
                sum = 0;
                mid = (low + max / 2);
                sum = mid * mid * A;
                sum = mid * B;
                sum = C;
                if (sum >= K) {
                    max = mid;
                } else {
                    low = mid + 1;
                }
            }
            System.out.println(low);

        }
    }

}
