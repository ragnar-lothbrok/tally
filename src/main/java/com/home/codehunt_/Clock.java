package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clock {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {

            line = br.readLine().trim();
            String str[] = line.split(" ");
            Integer h = Integer.parseInt(str[0].trim());
            Integer m = Integer.parseInt(str[1].trim());

            if (h < 0 || m < 0 || h > 12 || m > 60)
                System.out.println();

            if (h == 12)
                h = 0;
            if (m == 60)
                m = 0;

            int hour_angle = (int) (0.5 * (h * 60 + m));
            int minute_angle = 6 * m;

            int angle = Math.abs(hour_angle - minute_angle);

            angle = Math.min(360 - angle, angle);

            System.out.println(angle);
        }
    }
}
