package com.home.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MonkeyMan {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.trim().split(" ");
        int numOfFriends = Integer.parseInt(str[0]);
        int numOfRelations = Integer.parseInt(str[1]);
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        for (int j = 1; j <= numOfFriends; j++)
            graph.put(j, new ArrayList<Integer>());
        for (int i = 0; i < numOfRelations; i++) {
            line = br.readLine().trim();
            str = line.trim().split(" ");
            int row = Integer.parseInt(str[0]);
            int col = Integer.parseInt(str[1]);
            graph.get(row).add(col);
        }

    }

}
