package com.test.Shopsense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testcases = Integer.parseInt(line);
        for (int i = 0; i < testcases; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            long N = Long.parseLong(str[0]);
            long M = Long.parseLong(str[1]);
            long A = Long.parseLong(str[2]);
            long B = Long.parseLong(str[3]);
            long C = Long.parseLong(str[4]);
            double profit = 0;
            if (C >= A && C >= B) {
                if (N >= M) {
                    profit = (M * 2 * C) + (N - M) * A;
                } else if (M > N) {
                    profit = (N * 2 * C) + (M - N) * B;
                }
            } else if (C < A && C < B) {
                profit = M * B + N * A;
            } else {
                if (N >= M) {
                    if ((2 * M * C) > (M * A + M * B)) {
                        profit = 2 * M * C + (N - M) * A;
                    } else {
                        profit = N * A + M * B;
                    }
                } else {
                    if ((2 * N * C) > (N * A + N * B)) {
                        profit = 2 * N * C + (M - N) * B;
                    } else {
                        profit = N * A + M * B;
                    }
                }
            }
            System.out.printf("%.0f\n",profit);
        }
    }
}
