package com.he.softwareag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.hackerearth.com/nabler-hiring-challenge/problems/b0206cd603764958a2f03045e2840e2b/
public class PalinPairsProblem {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedreader.readLine();
        int num = Integer.parseInt(line);
        Map<String, Long> strMap = new HashMap<String, Long>();
        for (int i = 0; i < num; i++) {
            line = bufferedreader.readLine();
            if (strMap.containsKey(line)) {
                strMap.put(line, strMap.get(line) + 1);
            } else {
                strMap.put(line, 1l);
            }
        }
        long result = 0;

        for (String str : strMap.keySet()) {
            long count = strMap.get(str);

            if (count != 0) {
                String rev = new StringBuilder(str).reverse().toString();

                if (str.equals(rev)) {
                    result = result + count * (count - 1) / 2;
                } else if (strMap.containsKey(rev)) {
                    result = result + count * strMap.get(rev);
                    strMap.put(rev, 0l);
                }
            }
        }

        System.out.println(result);
    }
}
