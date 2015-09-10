package com.he.bits_28_Aug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/code-monk-bit-manipulation/algorithm/monk-and-his-friend/
public class Solution2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            sb.append(compareStrings(getSetBits(Long.parseLong(str[0])), getSetBits(Long.parseLong(str[1]))) + "\n");
        }
        System.out.println(sb.toString());
    }

    public static String getSetBits(Long num) {
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            sb.append(num % 2);
            num = num / 2;
        }
        return sb.toString();
    }

    public static int compareStrings(String s1, String s2) {
        int count = 0;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i++) != s2.charAt(j++)) {
                count++;
            }
        }
        if (s2.length() > s1.length()) {
            while (j < s2.length()) {
                if (s2.charAt(j++) == '1') {
                    count++;
                }
            }
        } else if (s1.length() > s2.length()) {
            while (i < s1.length()) {
                if (s1.charAt(i++) == '1') {
                    count++;
                }
            }
        }
        return count;
    }

}
