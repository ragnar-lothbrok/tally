package com.test.Shopsense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution7 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            int sum = 0;
            for (int j = A; j <= B; j++) {
                if (j == 1)
                    sum += 1;
                else if (j == 2)
                    sum += 2;
                else if (j == 3)
                    sum += 6;
                else if (j == 4)
                    sum += 4;
                else
                    sum += 0;
            }
            System.out.println(sum % 10);
        }
    }
}
