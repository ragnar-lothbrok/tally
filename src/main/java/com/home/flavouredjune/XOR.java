package com.home.flavouredjune;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class XOR {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        if (N > 0) {
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                line = br.readLine();
                arr[i] = Integer.parseInt(line);
            }

            Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                result = arr[i];
                countMap.put(result, countMap.get(result) == null ? 1 : countMap.get(result) + 1);
                for (int j = i + 1; j < arr.length; j++) {
                    result = (result ^ arr[j]);
                    countMap.put(result, countMap.get(result) == null ? 1 : countMap.get(result) + 1);
                }
            }

            List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(countMap.entrySet());
            Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
                public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                    if (o1.getValue().compareTo(o2.getValue()) != 0) {
                        return -o1.getValue().compareTo(o2.getValue());
                    } else {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                }
            });

            System.out.println(list.get(0).getKey() + " " + list.get(0).getValue());
        }
    }
}
