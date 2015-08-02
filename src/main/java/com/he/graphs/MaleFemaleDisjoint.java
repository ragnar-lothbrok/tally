package com.he.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://www.hackerearth.com/code-monk-minimum-spanning-tree/algorithm/3-types/
public class MaleFemaleDisjoint {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int numOfNodes = Integer.parseInt(str[0]);
        int numOfEdges = Integer.parseInt(str[1]);
        int vertex = -1;
        List<Edge> allEdgeList = new ArrayList<Edge>();
        Set<Integer> mSet = new HashSet<Integer>();
        Set<Integer> wSet = new HashSet<Integer>();
        for (int i = 0; i < numOfEdges; i++) {
            line = br.readLine();
            str = line.split(" ");
            if (vertex == -1)
                vertex = Integer.parseInt(str[0]);
            int source =  Integer.parseInt(str[0]);
            int destination = Integer.parseInt(str[1]);
            int weight =  Integer.parseInt(str[2]);
            Edge edge = new Edge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
            allEdgeList.add(edge);
//            edge = new Edge(Integer.parseInt(str[1]), Integer.parseInt(str[0]), Integer.parseInt(str[2]));
            if(weight ==3 || weight ==1){
                mSet.add(source);
                mSet.add(destination);
            }
            if(weight ==3 || weight ==2){
                wSet.add(source);
                wSet.add(destination);
            }
//            allEdgeList.add(edge);
        }
        
        if(mSet.size() != numOfNodes || wSet.size() != numOfNodes){
            System.out.println(-1);
            return;
        }
        Collections.sort(allEdgeList);

        List<Edge> edgesList = new ArrayList<Edge>();
        int[] menVisited = new int[numOfNodes + 1];
        int[] womenVisited = new int[numOfNodes + 1];

        BFS(allEdgeList, menVisited, womenVisited, vertex, edgesList);

    }

    private static void BFS(List<Edge> allEdgeList, int[] menVisited, int[] womenVisited, int vertex,
            List<Edge> edgesList) {
        int count = 0;
        for (int i = 0; i < menVisited.length; i++) {
            menVisited[i] = womenVisited[i] = i;
        }
        for (int i = 0; i < allEdgeList.size(); i++) {
            Edge edge = allEdgeList.get(i);
            int source = edge.getSource();
            int destination = edge.getDestination();
            int weight = edge.getWeight();
            if (weight == 3) {
                if (Find(source, menVisited) == Find(destination, menVisited)) {
                    count++;
                    continue;
                }
                Union(source, destination, menVisited);
                Union(source, destination, womenVisited);
            } else if (weight == 2) {
                if (Find(source, womenVisited) == Find(destination, womenVisited)) {
                    count++;
                    continue;
                }
                Union(source, destination, womenVisited);
            } else {
                if (Find(source, menVisited) == Find(destination, menVisited)) {
                    count++;
                    continue;
                }
                Union(source, destination, menVisited);
            }
        }
        int temp=0;
        for (int i = 1; i < menVisited.length; i++) {
           if(i!=0 && menVisited[i] == i){
               temp++;
           }
        }
        System.out.println();
        for (int i = 1; i < womenVisited.length; i++) {
            if(i!=0 && womenVisited[i] == i)
                temp++;
        }
        if(temp > 2){
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }

    public static int Find(int node, int[] parent) {
        if (parent[node] == node)
            return node;
        parent[node] = Find(parent[node], parent);
        return parent[node];
    }

    public static void Union(int start, int end, int[] parent) {
        int edgea = Find(start, parent);
        int edgeb = Find(end, parent);
        parent[edgeb] = edgea;
    }

    static class Edge implements Comparable<Edge> {
        private int source;
        private int destination;
        private int weight;

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getDestination() {
            return destination;
        }

        public void setDestination(int destination) {
            this.destination = destination;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return -this.getWeight() + ((Edge) o).getWeight();
        }

        public Edge(int source, int destination, int weight) {
            super();
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge [source=" + source + ", destination=" + destination + ", weight=" + weight + "]";
        }

    }

}
