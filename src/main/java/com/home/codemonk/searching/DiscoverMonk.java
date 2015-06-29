package com.home.codemonk.searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class DiscoverMonk {

    public static void main(String args[]) throws Exception {

        StringBuffer output = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in1[] = br.readLine().split(" ");
        int q = Integer.parseInt(in1[1]);
        String str[] = br.readLine().split(" ");
        Set<String> numSet = new TreeSet<String>(Arrays.asList(str));
        for (int i = 0; i < q; i++) {
            if (numSet.contains(br.readLine())) {
                output.append("YES");
                output.append("\n");
            } else {
                output.append("NO");
                output.append("\n");
            }
        }
        System.out.println(output);

    }
}
