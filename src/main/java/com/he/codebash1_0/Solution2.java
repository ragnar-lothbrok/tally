package com.he.codebash1_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            String line = br.readLine();
            int numOfOne = 0;
            int numOfZero = 0;
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '1') {
                    if (numOfZero > 0) {
                        numOfZero--;
                    } else {
                        numOfOne++;
                    }
                } else {
                    if (numOfOne > 0) {
                        numOfOne--;
                    } else {
                        numOfZero++;
                    }
                }
            }
            System.out.println(numOfOne + numOfZero);
        }
    }

}
