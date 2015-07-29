package com.test.Shopsense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

///https://www.hackerearth.com/battle-of-algorithmists/algorithm/dinesh-and-his-travelling-cost/
public class ShortestPathUnweightedGraph {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int adajacency[][] = new int[500 + 1][500 + 1];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            adajacency[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = Integer.parseInt(str[2]);
            adajacency[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = Integer.parseInt(str[2]);
        }
        int path[] = new int[501];
        long distance[] = new long[501];
        Integer source = Integer.parseInt(br.readLine());
        for (int i = 0; i < adajacency.length; i++) {
            path[i] = -1;
        }
        unweightedShortestPath(adajacency, path, distance, source);
        N = Integer.parseInt(br.readLine());
        System.out.println();
        for (int i = 0; i < N; i++) {
            int destination = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append(" " + destination);
            while (path[destination] != -1) {
                destination = path[destination];
                sb.append(" " + destination);
            }
            if (destination == source) {
                System.out.println(sb.reverse());
            } else {
                System.out.println("No Path");
            }

        }
    }

    public static void unweightedShortestPath(int adajacency[][], int path[], long distance[], int source) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Integer vertex;
        queue.add(source);

        for (int i = 0; i < adajacency.length; i++) {
            distance[i] = -1;
        }

        distance[source] = 0;

        while (!queue.isEmpty()) {
            vertex = queue.poll();
            if (vertex != null) {
                for (int i = 1; i < adajacency.length; i++) {
                    if (i != vertex && adajacency[vertex][i] != 0 && distance[i] == -1) {
                        distance[i] = distance[vertex] + 1;
                        path[i] = vertex;
                        queue.add(i);
                    }
                }
            }
        }
    }
}
