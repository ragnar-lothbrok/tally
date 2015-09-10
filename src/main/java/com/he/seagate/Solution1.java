package com.he.seagate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/seagate-hiring-challenge/problems/ec0c7f139524488aa5a63d850ec34f21/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num = Integer.parseInt(line);
        for (int i = 0; i < num; i++) {
            line = br.readLine();
            int setBits = setBits(line);
            int days = Integer.parseInt(br.readLine());
            days = (days * (days + 1)) / 2;
            if (days % 2 != 0) {
                System.out.println(line.length() - setBits);
            } else {
                System.out.println(setBits);
            }
        }

    }

    private static Integer setBits(String line) {
        int num = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '1') {
                num++;
            }
        }
        return num;
    }
}
