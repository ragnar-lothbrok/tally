package com.home.codemonk.heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

// https://www.hackerearth.com/code-monk-heaps-and-priority-queues/algorithm/monk-and-some-queries/
public class Solution2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        boolean isModified = false;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String str[] = line.split(" ");
            if (str[0].charAt(0) == '1') {
                int temp = Integer.parseInt(str[1]);
                if (treeMap.get(temp) != null && treeMap.get(temp) > 0) {
                    treeMap.put(temp, treeMap.get(temp) + 1);
                } else {
                    treeMap.put(temp, 1);
                }
                if(max != Integer.MIN_VALUE && max < temp){
                    max= temp;
                }else{
                    isModified = true;
                }
            } else if (str[0].charAt(0) == '2') {
                int temp = Integer.parseInt(str[1]);
                if (treeMap.get(temp) != null && treeMap.get(temp) > 1) {
                    treeMap.put(temp, treeMap.get(temp) - 1);
                    if(max != Integer.MAX_VALUE && min > temp){
                        min= temp;
                    }else{
                        isModified = true;
                    }
                } else {
                    Integer result = treeMap.remove(temp);
                    if (result == null || result <= 0)
                        System.out.println(-1);
                    isModified = true;
                }
            } else if (str[0].charAt(0) == '3') {
                if (isModified || min == Integer.MIN_VALUE) {
                    if (treeMap.size() > 0) {
                        max = treeMap.lastKey();
                        System.out.println(max);
                    } else {
                        System.out.println(-1);
                    }
                } else {
                    System.out.println(max);
                }
            } else if (str[0].charAt(0) == '4') {
                if (isModified || min == Integer.MAX_VALUE) {
                    if (treeMap.size() > 0) {
                        min = treeMap.firstKey();
                        System.out.println(min);
                    } else {
                        System.out.println(-1);
                    }
                } else {
                    System.out.println(min);
                }
            }
        }
    }

}
