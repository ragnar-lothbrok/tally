package com.he.softwareag;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.hackerearth.com/software-ag-hiring-challenge/problems/59db8fe533384585af2b3a3e3f06f4bf/
public class Solution1 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        long init = Long.parseLong(line);
        StringBuffer sb = new StringBuffer();
        long value = (long) Math.pow(2, init);
        System.out.println(value);
        int count = -1;
        boolean isDone = true;
        for (int i = 0; i < value; i++) {
            if (i != 0 && i % 4 == 0)
                isDone = false;
            if (!isDone) {
                int ok = i / 2 + 3;
                int data = (int) Math.pow(2, ok);
                count = data + 1;
                isDone = true;
            }
            if (i == 0) {
                count += 2;
            } else {
                if (i % 4 == 0) {
                } else if (i % 4 == 1) {
                    count = count + 2;
                } else if (i % 4 == 2) {
                    count = count + 6;
                } else {
                    count = count + 2;
                }
            }
            for (int j = 0; j < value; j = j + 4) {
                int res = (int) Math.pow(2, j);
                if (res == 1) {
                    sb.append(count + " ");
                    sb.append(count + 1 + " ");
                    sb.append(count + 4 + " ");
                    sb.append(count + 5 + " ");
                } else {
                    sb.append(res + count + " ");
                    sb.append(res + count + 1 + " ");
                    sb.append(res + count + 4 + " ");
                    sb.append(res + count + 5 + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}

/*
 * n=3 (spacing for clarity) 
1 2 5 6 17 18 21 22 
3 4 7 8 19 20 23 24 
9 10 13 14 25 26 29 30 
11 12 15 16 27 28 31 32 
33 34 37 38 49 50 53 54 
35 36 39 40 51 52 55 56 
41 42 45 46 57 58 61 62 
43 44 47 48 59 60 63 64
 */