package com.home.codehunt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FreeDrives {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println(getTotalRides(Integer.parseInt(br.readLine())));
        }
    }

    public static Integer getTotalRides(Integer input) {
        if (input <= 1)
            return 0;
        return (input*(input-1))/2;
    }
}
