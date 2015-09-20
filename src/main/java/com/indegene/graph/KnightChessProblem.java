package com.indegene.graph;

public class KnightChessProblem {
    private static boolean isSafe(int x, int y, int soln[][]) {
        if (x >= 0 && x < soln.length && y >= 0 && y < soln.length && soln[x][y] == -1)
            return true;
        return false;
    }

    private static void printSolution(int soln[][]) {
        for (int x = 0; x < soln.length; x++) {
            for (int y = 0; y < soln.length; y++) {
                System.out.print("  " + soln[x][y]);
            }
            System.out.println();
        }
    }

    private static boolean solveKTUtil(int soln[][], int x, int y, int count, int xMove[], int yMove[]) {
        int k, next_x, next_y;
        if (count == soln.length * soln.length)
            return true;
        for (k = 0; k < soln.length; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, soln)) {
                soln[next_x][next_y] = count;
                if (solveKTUtil(soln, next_x, next_y, count + 1, xMove, yMove))
                    return true;
                else
                    soln[next_x][next_y] = -1;
            }
        }
        return false;
    }

    public static boolean solveKnightTour(int soln[][]) {
        for (int x = 0; x < soln.length; x++) {
            for (int y = 0; y < soln.length; y++) {
                soln[x][y] = -1;
            }
        }
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        soln[0][0] = 0;
        if (!solveKTUtil(soln, 0, 0, 1, xMove, yMove)) {
            System.out.println("the solution does not exist");
            return false;
        } else {
            printSolution(soln);
        }
        return true;
    }

    public static void main(String... arg)

    {
        int soln[][] = new int[8][8];
        solveKnightTour(soln);
    }

}