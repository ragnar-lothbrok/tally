package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Rectangle_SquareCount {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine().trim();
            Integer r = Integer.parseInt(line);
            if(r >= 0){
                System.out.println((r*(r+1)*(2*r+1))/6);
               System.out.println(String.format("%.0f",((double)(r*(r+1)*1.0)*(r*(r+1)*1.0)/4*1.0)));
            }
        }
    }
}
