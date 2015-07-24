package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[7];
        String line ="";
        double sum = 0;
        for (int i = 0; i < 7; i++) {
            int count = 0;
            line = br.readLine().trim();
            for (int k = 0; k < line.length(); k++) {
                if (line.charAt(k) == '1') {
                    count++;
                }
            }
            arr[i] = count;
            sum += count;
        }
        double mean = sum/7.0;
        sum =0.0;
        for (int k = 0; k < arr.length; k++) {
            sum += (Math.pow(Math.abs(mean-arr[k]), 2));
        }
        System.out.printf(String.format("%.4f", Math.sqrt(sum/7)));
    }
}
