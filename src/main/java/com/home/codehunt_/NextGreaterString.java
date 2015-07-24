package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextGreaterString {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
        }
    }

    private static void pritnNextGreater(String inputString) {
        for (int i = inputString.length() - 1; i > 0; i--) {
            if (inputString.charAt(i) < inputString.charAt(i - 1)) {
                
            }
        }
    }
}
