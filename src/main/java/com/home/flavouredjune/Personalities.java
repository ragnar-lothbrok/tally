package com.home.flavouredjune;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Personalities {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            long totalCount = Long.parseLong(line);
            if(totalCount > 0){
                line = br.readLine();
                Set<Integer> uniqueSet = new HashSet<Integer>();
                String str[] = line.trim().split(" ");
                for (long j = 0; j < str.length; j++) {
                    uniqueSet.add(Integer.parseInt(str[(int) j]));
                }
                System.out.println(uniqueSet.size());
            }
        }
    }
}
