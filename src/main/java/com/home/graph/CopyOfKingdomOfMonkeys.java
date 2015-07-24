package com.home.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CopyOfKingdomOfMonkeys {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        long sum=Long.MIN_VALUE ,s=0;
        for (int i = 0; i < N; i++) {
            line = br.readLine().trim();
            String str[] = line.split(" ");
            int totalMonkeys = Integer.parseInt(str[0]);
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
            for (int j = 1; j <= totalMonkeys; j++)
                graph.put(j, new ArrayList<Integer>());
            Integer totalRelations = Integer.parseInt(str[1]);
            for (int j = 0; j < totalRelations; j++) {
                line = br.readLine().trim();
                String arr[] = line.split(" ");
                graph.get(Integer.parseInt(arr[0])).add(Integer.parseInt(arr[1]));
                graph.get(Integer.parseInt(arr[1])).add(Integer.parseInt(arr[0]));
            }
            line = br.readLine();
            str = line.trim().split(" ");
            long[] weights = new long[str.length + 1];
            for (int k = 1; k <= str.length; k++) {
                weights[k] = Long.parseLong(str[k-1]);
            }
            boolean[] visited = new boolean[totalMonkeys + 1];
            for(int j = 1 ; j <= totalMonkeys  ;j++){
                if(!visited[j]){
                    s = DFS(visited, graph, j,  weights);
                    sum = (s>sum ? s:sum);
                    s = 0;
                }
            }
            System.out.println(sum);
            sum = 0;s = 0;
        }
    }
    
    private static long DFS(boolean[] visited,HashMap<Integer,ArrayList<Integer>> map,int mon ,long[] arr){
        long tempSum=0;
        visited[mon]=true;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(mon);
        tempSum += arr[mon];
        while (!stack.isEmpty()) {
            List<Integer> list = map.get(stack.pop());
            for(Integer n:list){
                if(visited[n] == false){
                    visited[n] = true;
                    tempSum += arr[n];
                    stack.push(n);
                }
            }
        }
        return tempSum;
    }

}
