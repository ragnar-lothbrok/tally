package com.he.coditas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int l = 0; l < N; l++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int gp = Integer.parseInt(str[0]);
            int gs = Integer.parseInt(str[1]);
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < gp; i++) {
                line = br.readLine();
                str = line.split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                map.put(a, b);
            }
            HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
            for (int i = 0; i < gs; i++) {
                line = br.readLine();
                str = line.split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                map2.put(a, b);
            }
            line = br.readLine();
            str = line.split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            for (int key : map2.keySet()) {
                if (map.containsKey(key)) {
                    a--;
                    if (map.get(key) == map2.get(key))
                        b--;
                }
            }

            if (a <= 0) {
                System.out.println("Great");
            } else if (b <= 0) {
                System.out.println("Good");
            } else {
                System.out.println(":(");
            }
        }
    }

}
