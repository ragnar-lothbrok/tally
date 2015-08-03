package com.he.codathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/codathon-2/algorithm/shekhar-loves-to-travel/
public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {
            br.readLine();
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }

            int start = arr[0];
            int count = 0;
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int k = 1; k < str.length; k++) {
                if (str.length - 1 - maxIndex <= start) {
                    System.out.println(count);
                    break;
                }
                for (int l = k; l < k + start && l< str.length ; l++) {
                    if (max < arr[l]) {
                        max=arr[l];
                        maxIndex=l;
                        k=l-1;
                    }
                }
                if(max != start){
                    start = max;
                    count++;
                }
            }
        }
    }
}
