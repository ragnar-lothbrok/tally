package com.he.idea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        Long num = Long.parseLong(line);
        Set<String> winnerSet = new HashSet<String>();
        Set<String> loserSet = new HashSet<String>();
        num = (long) (Math.pow(2, num) - 1);
        while (num > 0) {
            line = bufferedReader.readLine();
            String str[] = line.split(" ");
            winnerSet.add(str[0]);
            loserSet.add(str[1]);
            num--;
        }
        winnerSet.removeAll(loserSet);
        System.out.println(winnerSet.toArray()[0]);
    }
}
