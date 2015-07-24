package com.he.julyclash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Upgrade {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int numOfVertices = Integer.parseInt(str[0]);
        int queries = Integer.parseInt(str[1]);
        boolean[][] adjacentMat = new boolean[numOfVertices + 1][numOfVertices + 1];
        int[] weight = new int[numOfVertices + 1];
        str = br.readLine().trim().split(" ");
        for (int i = 1; i < numOfVertices + 1; i++) {
            weight[i] = Integer.parseInt(str[i - 1]);
        }
        boolean[] visited = new boolean[numOfVertices + 1];
        for (int i = 1; i < numOfVertices; i++) {
            str = br.readLine().trim().split(" ");
            adjacentMat[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = true;
            adjacentMat[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = true;
        }

        for (int i = 0; i < queries; i++) {
            str = br.readLine().trim().split(" ");
            if (str[0].charAt(0) == 'S') {
                Arrays.fill(visited, false);
                Set<Point> path = findShortest(adjacentMat, visited, Integer.parseInt(str[1]), Integer.parseInt(str[2]));
                int sum = 0;
                if (path != null && path.size() > 0) {
                    Iterator<Point> pointIterator = path.iterator();
                    while (pointIterator.hasNext()) {
                        Point tempPoint = pointIterator.next();
                        sum += weight[tempPoint.getVertex()];
                    }
                }
                System.out.println(sum);
            } else if (str[0].charAt(0) == 'R') {
                Arrays.fill(visited, false);
                Set<Point> path = findShortest(adjacentMat, visited, Integer.parseInt(str[1]), Integer.parseInt(str[2]));
                List<Point> list = new ArrayList<Point>(path);
                for (int j = 0; j < list.size() / 2; j++) {
                    int start = list.get(j).getVertex();
                    int end = list.get(list.size() - j - 1).getVertex();
                    for (int k = 1; k < adjacentMat.length; k++) {
                        boolean temp = adjacentMat[start][k];
                        adjacentMat[start][k] = adjacentMat[end][k];
                        adjacentMat[end][k] = temp;

                        temp = adjacentMat[k][start];
                        adjacentMat[k][start] = adjacentMat[k][end];
                        adjacentMat[k][end] = temp;
                    }
                }
            }
        }
    }

    private static Set<Point> findShortest(boolean[][] adjacentMat, boolean[] visited, int startVertex, int endVertex) {
        Queue<Point> queue = new LinkedList<Point>();
        Point startPoint = new Point(startVertex);
        queue.add(startPoint);
        startPoint.getNeighbourList().add(startPoint);
        Point endPoint = new Point(endVertex);
        visited[startVertex] = true;
        if (startPoint.equals(endPoint)) {
            return startPoint.getNeighbourList();
        } else {
            while (!queue.isEmpty()) {
                Point temp = queue.remove();
                if (temp != null && temp.equals(endPoint)) {
                    temp.getNeighbourList().add(temp);
                    return temp.getNeighbourList();
                } else {
                    for (int j = 1; j < adjacentMat.length; j++) {
                        if (adjacentMat[temp.getVertex()][j] == true && !visited[j]) {
                            visited[j] = true;
                            Point point = new Point(j);
                            Set<Point> tempSet = new LinkedHashSet<Point>(temp.getNeighbourList());
                            if (temp.getNeighbourList().size() > 0) {
                                tempSet.add(point);
                            }
                            point.setNeighbourList(tempSet);
                            queue.add(point);
                        }
                    }
                }
            }
        }
        return null;
    }
}

class Point {
    private int vertex;
    Set<Point> neighbourList = new LinkedHashSet<Point>();

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public Set<Point> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(Set<Point> neighbourList) {
        this.neighbourList = neighbourList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + vertex;
        return result;
    }

    public Point(int vertex) {
        super();
        this.vertex = vertex;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (vertex != other.vertex)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Point [vertex=" + vertex +"]";
    }

}