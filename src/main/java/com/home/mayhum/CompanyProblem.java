// https://www.hackerearth.com/july-clash/algorithm/company-party/
package com.home.mayhum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompanyProblem {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }
        int groupCount = 0;
        for (int i = 0; i < N; i++) {
            int j = i;
            int temp = 0;
            while (j != -2) {
                j = arr[j];
                temp++;
            }
            if (temp > groupCount)
                groupCount = temp;
        }
        System.out.println(groupCount);

    }
}
