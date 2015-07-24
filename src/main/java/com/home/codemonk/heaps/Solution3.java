package com.home.codemonk.heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
///https://www.hackerearth.com/code-monk-heaps-and-priority-queues/algorithm/monk-and-champions-league/
public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int noOfPeople = Integer.parseInt(str[1]);
        line = br.readLine();
        str = line.split(" ");
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < str.length; i++) {
            int temp = Integer.parseInt(str[i]);
            if (map.get(temp) != null) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        long cost = 0;
        if (map.size() > 0) {
            while (noOfPeople > 0) {
                int temp = map.get(map.lastKey());
                cost += map.lastKey();
                if (temp > 1) {
                    map.put(map.lastKey(), temp - 1);
                    if (map.get(map.lastKey() - 1) != null && map.get(map.lastKey() - 1) > 0) {
                        map.put(map.lastKey() - 1, map.get(map.lastKey() - 1) + 1);
                    } else {
                        map.put(map.lastKey() - 1, 1);
                    }
                } else {
                    if (map.get(map.lastKey() - 1) != null && map.get(map.lastKey() - 1) > 0) {
                        map.put(map.lastKey() - 1, map.get(map.lastKey() - 1) + 1);
                        map.remove(map.lastKey());
                    } else {
                        map.put(map.lastKey() - 1, 1);
                        map.remove(map.lastKey());
                    }
                }
                noOfPeople--;
            }
        }
        System.out.println(cost);
    }

}
