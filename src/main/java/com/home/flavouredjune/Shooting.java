package com.home.flavouredjune;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Shooting {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String points[] = line.trim().split(" ");
            int x1 = Integer.parseInt(points[0]);
            int y1 = Integer.parseInt(points[1]);

            int x2 = Integer.parseInt(points[2]);
            int y2 = Integer.parseInt(points[3]);

            int x = Integer.parseInt(points[4]);
            int y = Integer.parseInt(points[5]);

            float tangent1 = x2 - x1 != 0 ? ((y2 - y1) / (x2 - x1) * 1.0f) : Integer.MAX_VALUE;
            float tangent2 = x != 0 ? y / x * 1.0f : Integer.MAX_VALUE;

            if (tangent1 == tangent2) {
                if ((x < x1 && x < x2 && y < y1 && y < y2) || (y1 == 0 && y2 == 0 && x < x1 && x < x2)
                        || (x1 == 0 && x2 == 0 && y < y1 && y < y2)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                tangent1 = y1 != 0 ? y1 / x1 * 1.0f : Integer.MAX_VALUE;
                tangent2 = y2 != 0 ? y2 / x2 * 1.0f : Integer.MAX_VALUE;
                float result1 = 0;
                float result2 = 0;
                if (tangent1 == Integer.MAX_VALUE) {
                    result1 = -(x - x1);
                } else {
                    result1 = (y - y1 - ((tangent1) * (x - x1)));
                }

                if (tangent2 == Integer.MAX_VALUE) {
                    result1 = -(x - x2);
                } else {
                    result2 = (y - y2 - ((tangent2) * (x - x2)));
                }

                if ((result1 > 0 && result2 > 0) || (result1 < 0 && result2 < 0)) {
                    System.out.println("YES");
                } else {
                    if ((y - y1 - (((1.0f * y2) - y1 / x2 - x1) * (x - x1))) < 0)
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                }
            }
        }
    }
}
