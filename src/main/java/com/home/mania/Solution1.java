package com.home.mania;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            isFunny(br.readLine().trim());
        }
    }

    private static void isFunny(String inputString) {
        String reverse = new StringBuilder(inputString).reverse().toString();
        boolean isFunny = true;
        for (int i = 0; i < inputString.length() - 1; i++) {

            if (!(Math.abs(inputString.charAt(i + 1) - inputString.charAt(i)) == Math.abs(reverse.charAt(i + 1)
                    - reverse.charAt(i)))) {
                isFunny = false;
                break;
            }
        }
        if (isFunny) {
            System.out.println("Funny");
        } else {
            System.out.println("Not Funny");
        }

    }
    
}
