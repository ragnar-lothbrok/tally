package com.home.codemonk.searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CarNames {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        char currentChar = 0;
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        String result = null;
        int start = 0;
        for (int i = 0; i < N; i++) {
            line = br.readLine().trim();
            hashMap.clear();
            start = 0;
            result = null;
            currentChar = 0;
            StringBuffer sb = new StringBuffer(line);
            for (int j = 0; j < line.trim().length(); j++) {
                if (hashMap.size() > 3) {
                    result = "Not OK";
                    break;
                }
                start = j;
                currentChar = line.charAt(j);
                int index = sb.lastIndexOf(currentChar + "");
                while (j <= index) {
                    if (line.charAt(j) == currentChar) {
                        j++;
                    } else {
                        result = "Not OK";
                        break;
                    }
                }
                if (result == null) {
                    hashMap.put(currentChar, index - start + 1);
                    if (j != line.length()) {
                        j--;
                    }
                }
            }
            if (hashMap.size() == 3) {
                int occur = -1;
                for (Entry<Character, Integer> entry : hashMap.entrySet()) {
                    if (occur == -1) {
                        occur = entry.getValue();
                    } else if (occur != entry.getValue()) {
                        result = "Not OK";
                    }
                }
            } else {
                result = "Not OK";
            }
            if (result == null || result.length() == 0)
                result = "OK";
            System.out.println(result);
            hashMap.clear();
        }
    }
}

// http://a4academics.com/online-test/solutions/18/java-fundamental-programming-puzzles-generics-collections-puzzle-1