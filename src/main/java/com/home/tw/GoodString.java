package com.home.tw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoodString {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();
            int N = Integer.parseInt(line);
            if (N >= 1 && N <= 10) {
                for (int i = 0; i < N; i++) {
                    line = br.readLine().trim();
                    if (line.length() >= 1 && line.length() <= 200) {
                        getGoodOrBadString(line);
                    } else {
                        System.out.println("Invalid Input");
                    }
                }
            } else {
                System.out.println("Invalid Test");
            }
        } catch (Exception exception) {
            System.out.println("Invalid Test");
        }
    }

    private static void getGoodOrBadString(String inputString) {
        int capitalCase = 0;
        int smallCase = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z') {
                smallCase++;
            } else if (inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z') {
                capitalCase++;
            }
        }
        if (capitalCase > smallCase && smallCase != 0) {
            System.out.println(smallCase);
        } else if (capitalCase < smallCase && capitalCase != 0) {
            System.out.println(capitalCase);
        } else if (smallCase + capitalCase == 0) {
            System.out.println("Invalid Input");
        } else if (smallCase == 0 || capitalCase == 0) {
            System.out.println(0);
        } else if (smallCase == capitalCase) {
            System.out.println(smallCase);
        }
    }

}
