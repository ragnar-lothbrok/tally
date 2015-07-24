package com.home.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RealEstate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        Set<Integer> uniqueNodes = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            int numOfLines = Integer.parseInt(br.readLine());
            for (int j = 0; j < numOfLines; j++) {
                line = br.readLine();
                String str[] = line.trim().split(" ");
                uniqueNodes.add(Integer.parseInt(str[0]));
                uniqueNodes.add(Integer.parseInt(str[1]));
            }
            System.out.println(uniqueNodes.size());
            uniqueNodes.clear();
        }
    }
}
