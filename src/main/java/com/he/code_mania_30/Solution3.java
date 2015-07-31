package com.he.code_mania_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/code_mania_30/algorithm/maximum-resistance-5/
public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        Integer N = Integer.parseInt(line1);
        for (int i = 0; i < N; i++) {
            line1 = br.readLine().trim();
            String line2 = br.readLine();
            int count = 0;
            int mCount = Integer.MAX_VALUE;
            if (line1.length() == line2.length()) {
                for (int j = 0; j < line1.length(); j++) {
                    if (line1.charAt(j) != line2.charAt(j)) {
                        count++;
                    }
                }
                mCount = count;
            } else {
                if (line1.length() > line2.length()) {
                    String temp = line1;
                    line1 = line2;
                    line2 = temp;
                }

                for (int k = 0; k <= line2.length() - line1.length(); k++) {
                    count = 0;
                    for (int j = 0; j < line1.length(); j++) {
                        if (line1.charAt(j) != line2.charAt(j + k))
                            count++;
                    }
                    if (mCount > count)
                        mCount = count;
                }

            }
            System.out.println(mCount);
        }
    }
}
