package com.he.newshunt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.hackerearth.com/newshunt-test-1/problems/20dba4e238e4a83b7ed3f9b3f9c3f4c1/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] arr = new int[26];
        if (line.length() > 0) {
            for (int i = 0; i < line.length(); i++) {
                if ((line.charAt(i) >= 'a' && line.charAt(i) <= 'z')) {

                    arr[line.charAt(i) - 97]++;
                } else if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                    arr[line.charAt(i) - 65]++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
