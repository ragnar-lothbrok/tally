package com.home.target;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Integer inputNumber = Integer.parseInt(line);
        Integer totalNumbers = Integer.parseInt(br.readLine());
        int[] inputArr = new int[totalNumbers];
        line = br.readLine();
        String str[] = line.trim().split(" ");
        int count = 0;
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = Integer.parseInt(str[i]);
            int temp = getGCD(inputNumber, inputArr[i]);
            if (temp > 1) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int getGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return getGCD(num2, num1 % num2);
    }

}
