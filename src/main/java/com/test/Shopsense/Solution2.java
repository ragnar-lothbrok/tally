package com.test.Shopsense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String[] strArr = new String[N];
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine().trim();
            if (map.get(strArr[i]) == null) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(strArr[i], list);
            } else {
                map.get(strArr[i]).add(i);
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            String reversed = new StringBuilder(strArr[i]).reverse().toString();
            List<Integer> list = map.get(reversed);
            if (list != null && list.size() > 0) {
                for (int k = 0; k < list.size(); k++) {
                    if (i < list.get(k)) {
                        count += (list.size() - k);
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static String reverse(String orig) {
        char[] s = orig.toCharArray();
        int n = s.length;
        int halfLength = n / 2;
        for (int i = 0; i < halfLength; i++) {
            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
        return new String(s);
    }

}
