package com.home.codemonk.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MaxDiff {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int k = 0; k < testCases; k++) {
            int noOfElements = Integer.parseInt(br.readLine());
            String inputArr1[] = br.readLine().trim().split(" ");
            String inputArr2[] = br.readLine().trim().split(" ");
            long input1[] = new long[noOfElements];
            long input2[] = new long[noOfElements];
            for (int i = 0; i < noOfElements; i++) {
                input1[i] = Long.parseLong(inputArr1[i]);
                input2[i] = Long.parseLong(inputArr2[i]);
            }

            int maxDifference = 0;
            int j = 0;
            for (int i = 0; i < input2.length; i++) {
                j = i;
                // Will iterate till be get the max difference
                while (j < noOfElements && input2[j] >= input1[i]) {
                    j++;
                }
                if (j - 1 - i > maxDifference)
                    maxDifference = j - 1 - i;
            }

            if (maxDifference != 0)
                System.out.println(maxDifference);
            else
                System.out.println(0);
        }

    }
}
