package com.home.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Valentine {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.trim().split(" ");
            long numOfProduct = Long.parseLong(str[0]);
            long numOfShops = Long.parseLong(str[1]);
            for (int j = 0; j < numOfProduct; j++) {
                int index = 0;
                double value = Double.MIN_VALUE;
                for (int k = 0; k < numOfShops; k++) {
                    line = br.readLine().trim();
                    str = line.trim().split(" ");
                    double dics1 = Double.parseDouble(str[0]) / 100;
                    if (dics1 >= 1)
                        dics1 = 100;
                    else if (dics1 <= 0) {
                        dics1 = 1.0d;
                    }
                    double dics2 = Double.parseDouble(str[1]) / 100;
                    if (dics2 >= 1)
                        dics2 = 100;
                    else if (dics2 <= 0 || dics1 == 100) {
                        dics2 = 1.0d;
                    }
                    double dics3 = Double.parseDouble(str[2]) / 100;
                    if (dics3 >= 1)
                        dics3 = 100;
                    else if (dics3 <= 0 || dics2 == 100 || dics1 == 100) {
                        dics3 = 1.0d;
                    }
                    double temp = (dics1 == 0 ? 1.0d : dics1) * (dics2 == 0 ? 1.0d : dics2)
                            * (dics3 == 0 ? 1.0d : dics3);
                    if (value < temp) {
                        value = temp;
                        index = k + 1;
                    }
                }
                System.out.print(index + " ");
            }
            System.out.println();
        }

    }
}
