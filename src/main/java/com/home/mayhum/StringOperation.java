package com.home.mayhum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringOperation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.trim().split(" ");
        int operations = Integer.parseInt(str[1]);
        try {
            StringBuilder sb = new StringBuilder(br.readLine().trim());
            if (sb.indexOf(".") != -1) {
                sb.substring(0, sb.length() - 1);
            }
            for (int i = 0; i < operations; i++) {
                line = br.readLine().trim();
                str = line.split(" ");
                int start = Integer.parseInt(str[0]);
                if (start == 0) {
                    int pos = Integer.parseInt(str[1]);
                    char ch = str[2].trim().charAt(0);
                    if (pos <= sb.length())
                        sb.setCharAt(pos - 1, ch);
                } else if (start == 1) {
                    int pos1 = Integer.parseInt(str[1]);
                    int pos2 = Integer.parseInt(str[2]);
                    int pos3 = Integer.parseInt(str[3]);
                    if (pos1 > 0 && pos2 <= sb.length()) {
                        char charArr[] = sb.substring(pos1 - 1, pos2).toString().toCharArray();
                        Arrays.sort(charArr);
                        if (pos3 > 0 && charArr.length >= pos3)
                            System.out.println(charArr[pos3 - 1]);
                        else
                            System.out.println("Out of range");
                    } else {
                        System.out.println("Out of range");
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Out of range");
        }
    }
}
