package com.home.codeazure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UnusualBlocks {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            try {
                System.out.println(totalCombinations(Integer.parseInt(br.readLine())));
            } catch (Exception exception) {

            }
        }
    }

    public static Integer totalCombinations(Integer area) {
        Integer result = 1;
        Integer sqrt = (int) Math.sqrt(area);
        for (int i = 2; i < sqrt; i++) {
            if (area % i == 0) {
                if (i % 2 != 0 ||(i % 2 == 0 && (area/i)%2 != 0)) {
                    result++;
                }
            }
        }
        if (sqrt * sqrt == area && area != 1)
            result++;
        return result;
    }

}
