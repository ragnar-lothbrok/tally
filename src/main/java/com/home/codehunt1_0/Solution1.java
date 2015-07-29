package com.home.codehunt1_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int arr[] = new int[256];
        for (int i = 0; i < line.length(); i++) {
            arr[line.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            int temp = arr[i] / 2;
            while (temp > 0) {
                sb.append((char) i);
                temp--;
            }
        }
        System.out.println(sb.toString());
    }

}
