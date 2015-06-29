package com.home.codemonk.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Potion {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.trim().split(" ");
        long potionValue = Long.parseLong(str[0]);
        long module = Long.parseLong(str[1]);

        String input = br.readLine().trim();
        long sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) =='1') {
                sum += potionValue;
                sum = sum % module;
            }
            potionValue = potionValue * potionValue;
            potionValue = potionValue%module;
        }
        System.out.println(sum%module);
    }
}
