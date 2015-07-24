package com.he.disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Fireman {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int adjacencyMat[][] = new int[N + 1][N + 1];
        line = br.readLine().trim();
        String str[] = line.split(" ");
        int[] weight = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            weight[i] = Integer.parseInt(str[i - 1]);
        }
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            str = line.split(" ");
            adjacencyMat[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            adjacencyMat[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
        }
        boolean[] visited = new boolean[adjacencyMat.length + 1];

        long min = 1;
        for (int i = 1; i < adjacencyMat.length; i++) {
            if (!visited[i]) {
                int temp = BFS(adjacencyMat, visited, i, weight);
                min = (min%1000000007) * temp;
            }
        }
        System.out.println(min%1000000007);
    }

    private static int BFS(int adjacencyMat[][], boolean[] visited, int i, int[] weight) {
        int arr[] = new int[adjacencyMat.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[i] = true;
        queue.add(i);
        arr[i] = weight[i];
        while (!queue.isEmpty()) {
            Integer curr = queue.remove();
            for (int j = 1; j < adjacencyMat.length; j++) {
                if ((adjacencyMat[curr][j] == 1 || adjacencyMat[j][curr] == 1) && !visited[j]) {
                    arr[j] = weight[j];
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
        Arrays.sort(arr);
        int length = 0;
        int count = 1;
        int temp = -1;
        while (length < arr.length && arr.length > 1) {
            if (arr[length] == 0) {
                length++;
                continue;
            } else if (temp != -1 && temp == arr[length]) {
                count++;
            } else if(temp == -1){
                temp = arr[length];
            }else{
                break;
            }
            length++;
        }
        return count;
    }
}
