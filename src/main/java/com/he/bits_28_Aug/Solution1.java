package com.he.bits_28_Aug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
//https://www.hackerearth.com/code-monk-bit-manipulation/algorithm/monks-choice-of-numbers-1/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int sum = 0;
            line = br.readLine();
            String str[] = line.split(" ");
            int k = Integer.parseInt(str[1]);
            line = br.readLine();
            str = line.split(" ");
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k + 1, Collections.reverseOrder());
            for (int j = 0; j < str.length; j++) {
                pq.add(getSetBits(Integer.parseInt(str[j])));
            }
            for (int j = 0; j < k; j++) {
                sum += pq.poll();
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb.toString());
    }

    public static int getSetBits(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 != 0)
                count++;
            num = num / 2;
        }
        return count;
    }

}
