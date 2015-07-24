package com.he.disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// https://www.hackerearth.com/code-monk-graph-theory-i/algorithm/monks-birthday-treat/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int numOfFriends = Integer.parseInt(str[0]);
        int numOfDependency = Integer.parseInt(str[1]);
        ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>(numOfFriends);
        for (int i = 0; i <= numOfFriends; i++) {
            list.add(new HashSet<Integer>());
        }
        for (int i = 0; i < numOfDependency; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            list.get(a).add(b);
        }

        boolean visited[] = new boolean[numOfFriends + 1];
        for (int i = 1; i <= numOfFriends; i++) {
            Arrays.fill(visited, false);
        }
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= numOfFriends; i++) {
            Arrays.fill(visited, false);
            int count = dfs(i, 0, visited, list);
            if (count < max)
                max = count;
        }
        System.out.println(max);

    }

    private static int dfs(Integer a, int count, boolean visited[], ArrayList<HashSet<Integer>> list) {
        count++;
        visited[a] = true;
        for (int node : list.get(a)) {
            if (!visited[node]) {
                count = dfs(node, count, visited, list);
            }
        }
        return count;
    }

}
