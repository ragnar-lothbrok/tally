package com.he.cube26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/national-instruments-hiring-challenge/problems/57b97e3a12a942ffb09a101216736703/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int count = Integer.parseInt(line);
        for (int i = 0; i < count; i++) {
            listSteppingNumbers(1000000, 9999999, Integer.parseInt(br.readLine()));
        }
    }

    public void getCreazyNumberCount(int length) {
        long count = 17;
        if (length == 1) {
            System.out.println(10);
        } else if (length == 2) {
            System.out.println(17);
        } else {
            for (int i = 3; i < length; i++) {
                
            }
        }
    }

    private final static int BASE = 10;

    private static void listSteppingNumbers(long start, long end, int digitCounts) {
        int count = 0;
        if (digitCounts == 1111) {
            count = 10;
        } else {
            while (start <= end) {
                if (/* (start + "").length() == digitCounts && */isSteppingNumber(start)) {
                    System.out.println(start);
                    count++;
                }
                start++;
            }
        }
        System.out.println(count);
    }

    private static boolean isSteppingNumber(long number) {
        if (number < BASE) {
            return false;
        }
        return isSteppingSequence(number);
    }

    private static boolean isSteppingSequence(long number) {
        long previous_digit = number % BASE;
        number /= BASE;
        while (number > 0) {
            long current_digit = number % BASE;

            if (Math.abs(previous_digit - current_digit) != 1) {
                return false;
            }

            previous_digit = current_digit;
            number /= BASE;
        }
        return true;
    }

}
