package com.he.graphs;

public class BellmanFordViaAdjacency {

    public static void main(String[] args) {

        int mat[][] = { { 0, 4, 0, 0, -1, 0 }, { 0, 0, -1, 0, -2, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, -5, 0, 3 }, { 0, 0, 0, 0, 0, 0 } };
        int adjacency[][] = new int[mat.length + 1][mat.length + 1];
        initializeMat(mat, adjacency);
        int source = 1;
        int vertexCount = mat.length;
        calculateShortestPath(adjacency, source, vertexCount);
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

    private static void calculateShortestPath(int[][] mat, int source, int vertexCount) {
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

        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            System.out.println("Distance from " + source + " to " + vertex + " is : " + distance[vertex]);
        }
    }

}
