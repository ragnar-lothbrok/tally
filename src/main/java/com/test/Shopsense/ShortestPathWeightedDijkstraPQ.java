package com.test.Shopsense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;

// /https://www.hackerearth.com/battle-of-algorithmists/algorithm/dinesh-and-his-travelling-cost/
public class ShortestPathWeightedDijkstraPQ {

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
        weightedShortestPath(adajacency, path, distance, source);
        N = Integer.parseInt(br.readLine());
        System.out.println();
        for (int i = 0; i < N; i++) {
            int destination = Integer.parseInt(br.readLine());
            if (distance[destination] == Integer.MAX_VALUE) {
                System.out.println("NO PATH");
            } else {
                System.out.println(distance[destination]);
            }

        }
    }

    public static void weightedShortestPath(int adajacency[][], int path[], long distance[], int source) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(source, 0l));
        for (int i = 0; i < adajacency.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        while (!pq.isEmpty()) {
            Node heapNode = pq.remove();
            Integer vertex = (Integer) heapNode.getNode();
            if (heapNode.getNode() != null) {
                for (int i = 0; i < adajacency.length; i++) {
                    if (i != vertex && adajacency[vertex][i] != 0) {
                        long dist = distance[vertex] + adajacency[vertex][i];
                        if (distance[i] == Integer.MAX_VALUE) {
                            distance[i] = dist;
                            path[i] = vertex;
                            pq.add(new Node(i, dist));
                        }
                        if (distance[i] > dist) {
                            distance[i] = dist;
                            Iterator<Node> iterator = pq.iterator();
                            while (iterator.hasNext()) {
                                Node node = iterator.next();
                                if (node.getNode().equals(i)) {
                                    iterator.remove();
                                    break;
                                }
                            }
                            pq.add(new Node(i, dist));
                            path[i] = vertex;
                        }
                    }
                }
            }
        }
    }
}
class Node implements Comparable {

    private Object node;
    private Long weight;

    public Node(Object node, Long weight) {
        super();
        this.node = node;
        this.weight = weight;
    }

    public Object getNode() {
        return node;
    }

    public void setNode(Object node) {
        this.node = node;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HeapNode [node=" + node + ", weight=" + weight + "]";
    }

    public int compareTo(Object o) {
        return this.weight.compareTo(((Node) o).weight);
    }

}