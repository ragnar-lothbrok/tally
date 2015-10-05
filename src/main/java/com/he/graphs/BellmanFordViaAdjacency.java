package com.he.graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BellmanFordViaAdjacency {

    public static void main(String[] args) {

        int mat[][] = { { 0, 4, 0, 0, -1, 0 }, { 0, 0, -1, 0, -2, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, -5, 0, 3 }, { 0, 0, 0, 0, 0, 0 } };
        int mat1[][] = { { 0, 7, 0, 0, 2 }, { 0, 0, 1, 0, 2 }, { 0, 0, 0, 4, 0 }, { 0, 0, 5, 0, 0 }, { 0, 3, 8, 5, 0 } };

        int adjacency[][] = new int[mat1.length + 1][mat1.length + 1];
        initializeMat(mat1, adjacency);
        int source = 1;
        int vertexCount = mat1.length;
        calculateSingleSourceShortestPath(adjacency, source, vertexCount);
        calculateAllPairSourceShortestPath(adjacency, source, vertexCount);
        calculateSingleSourceShortestPathDijkastra(adjacency, source, vertexCount);
    }

    private static void initializeMat(int[][] adMat, int adjacency[][]) {
        for (int i = 1; i < adjacency.length; i++) {
            for (int j = 1; j < adjacency.length; j++) {
                if (i == j)
                    adjacency[i][j] = 0;
                else if (adMat[i - 1][j - 1] == 0)
                    adjacency[i][j] = Integer.MAX_VALUE;
                else
                    adjacency[i][j] = adMat[i - 1][j - 1];

            }
        }
    }

    private static void calculateSingleSourceShortestPath(int[][] mat, int source, int vertexCount) {
        int distance[] = new int[vertexCount + 1];
        for (int i = 1; i < mat.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            for (int src = 1; src <= vertexCount; src++) {
                for (int dest = 1; dest <= vertexCount; dest++) {
                    if (mat[src][dest] != Integer.MAX_VALUE) {
                        if (distance[dest] > distance[src] + mat[src][dest]) {
                            distance[dest] = distance[src] + mat[src][dest];
                        }
                    }
                }
            }
        }

        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            for (int src = 1; src <= vertexCount; src++) {
                for (int dest = 1; dest <= vertexCount; dest++) {
                    if (mat[src][dest] != Integer.MAX_VALUE) {
                        if (distance[dest] > distance[src] + mat[src][dest]) {
                            System.out.println("The Graph contains negative egde cycle");
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("Bellman Ford...");
        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            System.out.println("Distance from " + source + " to " + vertex + " is : " + distance[vertex]);
        }
        System.out.println();
    }

    private static void calculateAllPairSourceShortestPath(int[][] mat, int source, int vertexCount) {
        int distance[][] = new int[vertexCount + 1][vertexCount + 1];

        for (int src = 1; src <= vertexCount; src++) {
            for (int dest = 1; dest <= vertexCount; dest++) {
                distance[src][dest] = mat[src][dest];
            }
        }

        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            for (int src = 1; src <= vertexCount; src++) {
                for (int dest = 1; dest <= vertexCount; dest++) {
                    if (distance[src][vertex] != Integer.MAX_VALUE && distance[vertex][dest] != Integer.MAX_VALUE
                            && distance[src][dest] > distance[src][vertex] + distance[vertex][dest]) {
                        distance[src][dest] = distance[src][vertex] + distance[vertex][dest];
                    }
                }
            }
        }

        for (int src = 1; src <= vertexCount; src++) {
            for (int dest = 1; dest <= vertexCount; dest++) {
                if (src == dest && distance[src][dest] != 0) {
                    System.out.println("The Graph contains negative egde cycle");
                    break;
                }
            }
        }

        System.out.println("Floyd Warshall...");
        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            System.out.println("Distance from " + source + " to " + vertex + " is : " + distance[source][vertex]);
        }
    }

    private static void calculateSingleSourceShortestPathDijkastra(int[][] mat, int source, int vertexCount) {
        int distance[] = new int[vertexCount + 1];
        for (int i = 1; i < mat.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        
        Set<Integer> settled = new HashSet<Integer>();

        while (!queue.isEmpty()) {

            //get node with minimum distance
            Iterator<Integer> iterator = queue.iterator();
            int min = Integer.MAX_VALUE;
            int node = -1;
            while(iterator.hasNext()){
               int tempNode = iterator.next();
                if(distance[tempNode] <= min){
                    min = distance[tempNode];
                    node = tempNode;
                }
            }
            queue.remove(node);
            settled.add(node);
            
            //Calculate neighbors distances
            
            for (int dest = 1; dest <= vertexCount; dest++) {
                if(!settled.contains(dest)){
                    if(mat[node][dest] != Integer.MAX_VALUE){
                        if(distance[node] + mat[node][dest] < distance[dest]){
                            distance[dest] = distance[node] + mat[node][dest];
                        }
                        queue.add(dest);
                    }
                }
            }
        }
        System.out.println("\nDijkastra...");
        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            System.out.println("Distance from " + source + " to " + vertex + " is : " + distance[vertex]);
        }
    }

}
