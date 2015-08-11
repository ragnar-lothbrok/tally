package com.he.newshunt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.hackerearth.com/newshunt-test-1/problems/508041a36f1a188bccf4099686195509/
public class Solution2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line.length() > 0) {
            String tempStr = "";
            for (int i = 0; i < line.length(); i++) {
                if ((line.charAt(i) >= '0' && line.charAt(i) <= '9')) {

                    tempStr += line.charAt(i);
                } else if (tempStr.length() > 0) {
                    System.out.println(Long.parseLong(tempStr));
                    tempStr = "";
                }
            }
            if (tempStr.length() > 0) {
                System.out.println(Long.parseLong(tempStr));
                tempStr = "";
            }
        }
    }
}
