package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TestClass {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        line = br.readLine();
        Map<String, Integer> countMap = new TreeMap<String, Integer>();
        String str[] = line.trim().split(" ");
        for (int i = 0; i < str.length; i++) {
            if (countMap.get(str[i].trim()) == null) {
                countMap.put(str[i].trim(), 1);
            } else {
                countMap.put(str[i].trim(), countMap.get(str[i].trim()) + 1);
            }
        }

        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(countMap.entrySet());
        for (int i = list.size() - 1; i >=0; i--) {
            Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
