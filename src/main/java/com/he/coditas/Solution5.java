package com.he.coditas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String line = br.readLine();

        List<String> list = new ArrayList<String>();
        list.add("x");
        list.add("xx");
        list.add("Xx");
        Collections.sort(list, Collections.reverseOrder());
        ;
        System.out.println(list);

        System.out.println(maximumPositiveFrequency(new int[] { 2, 30, 15, 10, 8, 25, 80 }, 7));
        String s1 = "abcdef";
        String s2 = "abcdfG";
        String s3 = "abcdFH";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode()); 
    }

    public static int maximumPositiveFrequency(int[] input1, int input2) {
        int result = 0;
        for (int i = 0; i < input1.length; i++) {
            if (i + 1 < input1.length && input1[i] < input1[i + 1]) {
                result += input1[i + 1] - input1[i];
            }
        }
        return result;
    }
}
