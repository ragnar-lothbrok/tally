package com.home.codehunt1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line.trim());
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            long start = Long.parseLong(str[0]);
            long end = Long.parseLong(str[1]);
            long and = -1;
            for (long j = start; j <= end; j++) {
                if(and == -1){
                    and = j;
                }else{
                    and = and&j;
                }
            }
            System.out.println(and);
        }
    }
}
