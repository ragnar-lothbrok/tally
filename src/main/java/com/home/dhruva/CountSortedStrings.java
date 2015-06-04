package com.home.dhruva;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountSortedStrings {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println(getCount(Integer.parseInt(br.readLine()), br.readLine()));
        }
    }

    public static Long getCount(Integer length, String inputString) {
        Long total = 0l;
        Integer index = 0;
        for (int i = 0; i < length; i++) {
            if (length == 1) {
                return 1l;
            } else if (i == length - 1 && (inputString.charAt(i) > inputString.charAt(i - 1))) {
                return total + getSubStrings(inputString.substring(index, i + 1));
            } else if (i < length - 1 && inputString.charAt(i) > inputString.charAt(i + 1)) {
                total += getSubStrings(inputString.substring(index, i + 1));
                index = i + 1;
            } else if (i == length - 1) {
                total += getSubStrings(inputString.substring(index, i + 1));
                index = i + 1;
            }
        }
        return total;
    }

    public static Long getSubStrings(String inputString) {
        Long total = 0l;
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = 1; j <= inputString.length() - i; j++) {
                total++;
            }
        }
        return total;
    }

}
