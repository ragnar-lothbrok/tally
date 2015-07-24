package com.home.thought;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution1 {
    public static void main(String[] args) throws IOException {
        long num = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCases = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCases; i++) {
                num = Long.parseLong(br.readLine().trim());
                System.out.println(getFlips(num));
            }
        } catch (Exception exception) {
            System.out.println(num);
        }
    }

    public static long getFlips(long num) {
        long totalFlips = 0;
        if (num <= 0) {
            totalFlips = 0;
        } else if (num <= 3) {
            totalFlips = 1;
        } else if (num % 3 == 0) {
            totalFlips = num / 3;
        } else {
            totalFlips = num;
        }
        return totalFlips;
    }

}