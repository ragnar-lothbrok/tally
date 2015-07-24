package com.home.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class KingdomOfMonkeys {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine().trim();
            String str[] = line.split(" ");
            int totalMonkeys = Integer.parseInt(str[0]);
            Integer totalRelations = Integer.parseInt(str[1]);
            int[][] adjacencyMat = new int[totalMonkeys][totalMonkeys];
            for (int j = 0; j < totalRelations; j++) {
                line = br.readLine().trim();
                String arr[] = line.split(" ");
                setAdjacencyMat(Integer.parseInt(arr[0]) - 1, Integer.parseInt(arr[1]) - 1, adjacencyMat);
            }
            line=br.readLine();
            str = line.trim().split(" ");
            int[] weights = new int[str.length];
            for (int k = 0; k < str.length; k++) {
                weights[k] = Integer.parseInt(str[k]);
            }

            boolean[] visited = new boolean[totalMonkeys];
            long maximum = Long.MIN_VALUE;
            for (int j = 0; j < totalMonkeys; j++) {
                if(visited[j]){
                    continue;
                }
                Stack<Integer> stack = new Stack<Integer>();
                Set<Integer> uniqueSet = new HashSet<Integer>();
                stack.push(j);
                visited[j] = true;
                while (!stack.isEmpty()) {
                    int temp = getUnvisitedAdjacentVertex(adjacencyMat, stack.peek(), visited);
                    if (temp == -1) {
                        uniqueSet.add(stack.pop());
                    } else {
                        visited[temp] = true;
                        stack.push(temp);
                    }
                }
                Iterator<Integer> iterator = uniqueSet.iterator();
                long sum =0;
                while(iterator.hasNext()){
                    Integer bucket = iterator.next();
                    sum += weights[bucket];
                }
                if(maximum < sum){
                    maximum= sum;
                }
                uniqueSet.clear();
            }
            System.out.println(maximum);
        }
    }

    public static int getUnvisitedAdjacentVertex(int[][] adjacencyMat, int index, boolean[] visited) {
        for (int j = 0; j < visited.length; j++) {
            if (visited[j]) {
                continue;
            } else {
                if (adjacencyMat[index][j] > 0) {
                    return j;
                }
            }
        }
        return -1;
    }

    private static void setAdjacencyMat(int row, int col, int[][] adjacencyMat) {
        adjacencyMat[row][col] = 1;
        adjacencyMat[col][row] = 1;
    }

}
