package com.he.aug_easy_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
///https://www.hackerearth.com/august-easy-15/algorithm/shil-and-lucky-string-1/
public class Solution2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < line.length() / 2; i++) {
            if (line.charAt(i) < line.charAt(i + line.length() / 2)) {
                count1++;
            } else if (line.charAt(i) > line.charAt(i + line.length() / 2)) {
                count2++;
            } else {
                count3++;
            }
        }
        int temp = Math.max(count1, count2);
        temp = Math.max(count3, temp);
        System.out.println(line.length() / 2 - temp);
    }

}
