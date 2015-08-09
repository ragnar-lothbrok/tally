package com.he.coditas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        
        final Long VALUE = 33l;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        long arr[] = new long[N];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            long temp1 = Long.parseLong(str[0]);
            long temp2 = Long.parseLong(str[1]);
            if (temp2 == 0) {
                arr[i] = VALUE;
            } else {
                arr[i] = (-1 * temp1 / temp2);
            }
        }
        line = br.readLine();
        int ques = Integer.parseInt(line);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ques; i++) {
            int num = Integer.parseInt(br.readLine()) - 1;
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != VALUE && arr[num] != VALUE) {
                    if (arr[j] * arr[num] == -1) {
                        count++;
                    }
                } else {
                    if ((arr[num] == VALUE && arr[j] == 0) || (arr[j] == VALUE && arr[num] == 0)) {
                        count++;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb.toString());
    }

}
