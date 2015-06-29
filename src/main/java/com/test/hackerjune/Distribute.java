package com.test.hackerjune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Distribute {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.trim().split(" ");
        long N = Long.parseLong(str[0]);
        long k = Long.parseLong(str[1]);
        line = br.readLine().trim();
        str = line.split(" ");
        long arr[] = new long[(int) N];
        long totalSum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(str[i]);
            totalSum += arr[i];
        }
        Arrays.sort(arr);
        long sum =0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
    }
}
