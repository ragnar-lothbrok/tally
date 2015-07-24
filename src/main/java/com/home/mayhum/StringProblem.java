//https://www.hackerearth.com/july-clash/algorithm/string/
package com.home.mayhum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringProblem {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(br.readLine());
        findString(line, N);

    }

    private static void findString(String s, int k) {
        int min_i;
        int buffer[] = new int[256];
        int maxValue = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); ++i)
            ++buffer[s.charAt(i)];
        for (int i = 97; i < 123; ++i)
            if (buffer[i] == 0)
                buffer[i] = maxValue;
        
        while (true) {
            min_i = 97;
            for (int i = 97; i < 123; ++i)
                if (buffer[i] < buffer[min_i])
                    min_i = i;
            if (buffer[min_i] <= k) {
                k -= buffer[min_i];
                buffer[min_i] = maxValue;
            } else
                break;
        }
        int i = 0;
        for (i = 97, k = 0; i < 123; ++i)
            if (buffer[i] != maxValue)
                ++k;
        System.out.println(k);
        for (i = 97; i < 123; ++i)
            if (buffer[i] != maxValue)
                for (k = 0; k < buffer[i]; ++k)
                    System.out.print((char)i);
        System.out.println();
    }

}
