package com.he.NITC_Encode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int teams = Integer.parseInt(line);
        int arr[][] = new int[teams][2];
        int result[][] = new int[teams][2];
        for (int i = 0; i < teams; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        for (int i = 0; i < teams; i++) {
            for (int j = 0; j < teams; j++) {
                if (j != i) {
                    if (arr[i][0] != arr[j][1]) {
                        result[i][0]++;
                        result[j][1]++;
                    } else if (arr[i][0] == arr[j][1] && arr[i][0] != arr[j][0]) {
                        result[i][0]++;
                        result[j][0]++;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < teams; i++) {
            sb.append(result[i][0] + " " + result[i][1] + "\n");
        }
        System.out.println(sb.toString());
    }

}
