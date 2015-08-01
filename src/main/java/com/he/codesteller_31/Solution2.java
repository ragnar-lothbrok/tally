package com.he.codesteller_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/codestellar-5/algorithm/connections/
public class Solution2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int numOfEdge = Integer.parseInt(br.readLine());
        int[] disjoint = new int[N + 1];
        for (int k = 0; k < disjoint.length; k++) {
            disjoint[k] = k;
        }
        for (int k = 0; k < numOfEdge; k++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int s1 = Integer.parseInt(str[0]);
            int d1 = Integer.parseInt(str[1]);
            union(s1, d1, disjoint);
        }

        int numOfQueries = Integer.parseInt(br.readLine());
        for (int k = 0; k < numOfQueries; k++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int s1 = Integer.parseInt(str[0]);
            int d1 = Integer.parseInt(str[1]);
            if (disjoint[s1] == d1) {
                System.out.println("Direct Connection");
            } else if (root(s1, disjoint) == root(d1, disjoint)) {
                System.out.println("Indirect Connection");
            } else {
                System.out.println("No Connection");
            }
        }
    }

    private static int root(int x, int disjoint[]) {
        while (disjoint[x] != x) {
            disjoint[x] = disjoint[disjoint[x]];
            x = disjoint[x];
        }
        return x;
    }

    private static void union(int source, int destination, int disjoint[]) {
        int p = root(source, disjoint);
        int q = root(destination, disjoint);
        disjoint[p] = disjoint[q];
    }

}
