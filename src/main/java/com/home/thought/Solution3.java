package com.home.thought;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String str = "";
        int count = 0;
        for (int i = line.length() - 1; i >= 0; i--) {
            if (isEven(line.charAt(i))) {
                count++;
                if (str.length() == 0) {
                    str = count + "";
                } else {
                    str = count + " " + str;
                }
            } else {
                if (str.length() == 0) {
                    str = count + "";
                } else {
                    str = count + " " + str;
                }
            }
        }
        System.out.println(str);
    }

    private static boolean isEven(char ch) {
        boolean isEven = false;
        switch (ch) {
            case '0':
                isEven = true;
                break;
            case '2':
                isEven = true;
                break;
            case '4':
                isEven = true;
                break;
            case '6':
                isEven = true;
                break;
            case '8':
                isEven = true;
                break;
        }
        return isEven;
    }
}
