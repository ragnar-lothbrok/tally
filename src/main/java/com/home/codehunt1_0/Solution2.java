package com.home.codehunt1_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            System.out.println(testPalindrome(line));
        }

    }

    public static boolean isPalindrome(String word) {
        return word.equals(new StringBuffer().append(word).reverse().toString());
    }

    public static int testPalindrome(String word) {
        if (isPalindrome(word)) {
            return -1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            sb.append(word);
            sb.deleteCharAt(i);
            if (isPalindrome(sb.toString())) {
                return i;
            }
            sb.delete(0, word.length());
        }

        return -1;
    }
}
