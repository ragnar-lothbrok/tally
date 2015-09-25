package com.home.flipkart;

import java.util.LinkedList;
import java.util.Queue;

public class RegionFinder {

    public static void main(String[] args) {

        int arr[][] = { { 2, 1, 2, 2, 1, 1 }, { 2, 2, 1, 2, 1, 1 }, { 2, 1, 3, 2, 1, 1 }, { 2, 2, 2, 1, 3, 3 },
                { 2, 2, 1, 1, 3, 3 }, { 2, 2, 1, 1, 3, 3 } };

        boolean visited[][] = new boolean[arr.length][arr[0].length];
        int x[] = { 1, -1, 1, -1, 1, -1 };
        int y[] = { 1, 1, -1, -1, 0, 0 };
        int regionCount = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if (!visited[i][j]) {
                    regionCount++;
                    visited[i][j] = true;
                    System.out.println(i + " " + j);
                    countRegion(arr, new Cell(i, j, arr[i][j]), visited, x, y);
                }
            }
        }
        System.out.println("Region Count : " + regionCount);

    }

    public static int countRegion(int arr[][], Cell cell, boolean visited[][], int x[], int y[]) {
        Queue<Cell> queue = new LinkedList<Cell>();
        queue.add(cell);
        while (!queue.isEmpty()) {
            Cell tempCell = queue.remove();
            for (int i = 0; i < x.length; i++) {
                int Xco = tempCell.getX() + x[i];
                int Yco = tempCell.getY() + y[i];
                if (isSafe(Xco, Yco, arr) && arr[Xco][Yco] == cell.getValue() && !visited[Xco][Yco]) {
                    queue.add(new Cell(Xco, Yco, cell.getValue()));
                    visited[Xco][Yco] = true;
                }
            }
        }
        return 1;
    }

    public static boolean isSafe(int x, int y, int arr[][]) {
        if (x >= 0 && x < arr[0].length && y >= 0 && y < arr.length) {
            return true;
        }
        return false;
    }

    static class Cell {
        private int x;
        private int y;
        private int value;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Cell(int x, int y, int value) {
            super();
            this.x = x;
            this.y = y;
            this.value = value;
        }

    }
}
