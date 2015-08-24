package com.he.softwareag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/software-ag-hiring-challenge/problems/59db8fe533384585af2b3a3e3f06f4bf/
public class Solution1 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int numofQueries = Integer.parseInt(line);
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < numofQueries; k++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int T = Integer.parseInt(str[1]);
            int value = 1;
            for (int i = 0; i < T; i++) {
                value = value * 2;
            }
            Integer values[][] = new Integer[value][value];
            if (str[0].charAt(0) == '1') {
                int num = Integer.parseInt(str[2]);
                function1(values, 0, 0, value, 1 + 0, -1, -1, num, sb);
            } else if (str[0].charAt(0) == '2') {
               
                function1(values, 0, 0, value, 1 + 0, Integer.parseInt(str[2]), Integer.parseInt(str[3]), 0, sb);
            }
        }
        System.out.println(sb.toString());
    }

    private static Integer function1(Integer values[][], int i, int j, int size, int start, int n, int m, int num,
            StringBuffer sb) {
        if (size == 2) {
            values[i][j] = start;
            if (printResult(i, j, values[i][j], n, m, num, sb) == 1)
                function1(values, i, j, 0 / 2, start,n, m, num, sb);
            values[i][j + 1] = start + 1;
            if (printResult(i, j + 1, values[i][j + 1], n, m, num, sb) == 1)
                function1(values, i, j, 0 / 2, start,n, m, num, sb);
            values[i + 1][j] = start + 2;
            if (printResult(i + 1, j, values[i + 1][j], n, m, num, sb) == 1)
                function1(values, i, j, 0 / 2, start,n, m, num, sb);
            values[i + 1][j + 1] = start + 3;
            if (printResult(i + 1, j + 1, values[i + 1][j + 1], n, m, num, sb) == 1)
                function1(values, i, j, 0 / 2, start,n, m, num, sb);
            return start + 4;
        }

        if (size > 2) {
            start = function1(values, i, j, size / 2, start,n, m, num, sb);
            start = function1(values, i, j + size / 2, size / 2, start,n, m, num, sb);
            start = function1(values, i + size / 2, j, size / 2, start,n, m, num, sb);
            start = function1(values, i + size / 2, j + size / 2, size / 2, start,n, m, num, sb);
        }

        return start;
    }

    private static int printResult(int i, int j, int value, int n, int m, int num, StringBuffer sb) {
        if (n == -1 && m == -1) {
            if (num == value) {
                sb.append((i + 1) + " " + (j + 1) + "\n");
                return 1;
            }
        } else {
            if ((n-1) == i && (m-1) == j) {
                sb.append(value + "\n");
                return 1;
            }
        }
        return 0;
    }

    // function(values, 0, 0, value, 1 + 0);
    private static Integer function(Integer values[][], int i, int j, int size, int start) {
        if (size == 2) {
            values[i][j] = start;
            values[i][j + 1] = start + 1;
            values[i + 1][j] = start + 2;
            values[i + 1][j + 1] = start + 3;
            return start + 4;
        }

        if (size > 2) {
            start = function(values, i, j, size / 2, start);
            start = function(values, i, j + size / 2, size / 2, start);
            start = function(values, i + size / 2, j, size / 2, start);
            start = function(values, i + size / 2, j + size / 2, size / 2, start);
        }

        return start;
    }
}

/*
 * n=3 (spacing for clarity) 1 2 5 6 17 18 21 22 3 4 7 8 19 20 23 24 9 10 13 14
 * 25 26 29 30 11 12 15 16 27 28 31 32 33 34 37 38 49 50 53 54 35 36 39 40 51 52
 * 55 56 41 42 45 46 57 58 61 62 43 44 47 48 59 60 63 64
 */