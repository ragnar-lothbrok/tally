package com.home.codemonk.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChanduandhisGirlfriendReturns {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        try {
            for (int i = 0; i < N; i++) {
                line = br.readLine();
                String firstStr[] = br.readLine().replace("  ", " ").trim().split(" ");
                String secondStr[] = br.readLine().replace("  ", " ").trim().split(" ");
                int[] firstIntArr = new int[firstStr.length];
                for (int j = 0; j < firstStr.length; j++) {
                    firstIntArr[j] = Integer.parseInt(firstStr[j]);
                }
                int[] secondIntArr = new int[secondStr.length];
                for (int j = 0; j < secondStr.length; j++) {
                    secondIntArr[j] = Integer.parseInt(secondStr[j]);
                }
                merge(firstIntArr, secondIntArr);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void merge(int[] a, int[] b) {

        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] > b[j])
                System.out.print(a[i++] + " ");

            else
                System.out.print(b[j++] + " ");
        }

        while (i < a.length)
            System.out.print(a[i++] + " ");

        while (j < b.length)
            System.out.print(b[j++] + " ");

        System.out.println();

    }
}
