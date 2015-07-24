package com.home.codemonk.heaps;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

// https://www.hackerearth.com/code-monk-heaps-and-priority-queues/algorithm/monk-and-multiplication/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp >= firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = temp;
            } else if (temp >= secondMax) {
                thirdMax = secondMax;
                secondMax = temp;
            } else if (temp >= thirdMax) {
                thirdMax = temp;
            }

            if (i >= 2) {
                System.out.println(firstMax * secondMax * (long) thirdMax);
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
        pw.close();
    }

}
