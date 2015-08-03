package com.he.aug_easy_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.hackerearth.com/august-easy-15/algorithm/shil-and-crazy-operation/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        long numOfTestCase = Long.parseLong(str[1]);
        Integer numOfElements = Integer.parseInt(str[0]);
        int A[] = new int[numOfElements];
        int B[] = new int[numOfElements];
        int P[] = new int[numOfElements];

        str = br.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            A[i] = Integer.parseInt(str[i]);
        }
        str = br.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            P[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < numOfTestCase; i++) {

            for (int j = 0; j < A.length; j++) {
                B[j] = A[j];
            }

            for (int j = 0; j < A.length; j++) {
                A[j] = B[P[j] - 1];
            }

        }

        for (int j = 0; j < A.length; j++) {
            System.out.print(A[j] + " ");
        }

    }

}
