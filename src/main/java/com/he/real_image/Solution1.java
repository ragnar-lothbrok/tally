package com.he.real_image;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int numOfDays = Integer.parseInt(line);
        line = br.readLine();
        String str[] = line.split(" ");
        int num = Integer.parseInt(str[0]);
        int arr[][] = new int[num][num];
        int power = Integer.parseInt(str[1]);
        Arrays.fill(arr, power);
        int queries = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfDays; i++) {
            for (int j = 0; j < queries; j++) {
                line = br.readLine();
            }
        }
    }

}
