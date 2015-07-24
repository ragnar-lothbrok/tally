package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Grid {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        byte[][] byteArr = new byte[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            line = br.readLine().trim();
            String str[] = line.split(" ");
            for (int j = 0; j < N; j++) {
                byteArr[i][j] = Byte.parseByte(str[j]);
            }
        }
        visited[0][0] = true;
        System.out.println(totalPossiblePath(byteArr, visited, 0, 0));
    }

    private static long totalPossiblePath(byte[][] byteArr, boolean[][] visited, int i, int j) {
        long count = 0;
        if (byteArr[i][j] == 1) {
            visited[i][j] = false;
            return 0;
        }
        if (i == byteArr.length - 1 && j == byteArr.length - 1) {
            visited[i][j] = false;
            return 1;
        }
        if (j != byteArr.length - 1 && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            count += totalPossiblePath(byteArr, visited, i, j + 1);
        }
        if (j != 0 && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            count += totalPossiblePath(byteArr, visited, i, j - 1);
        }
        if (i != byteArr.length - 1 && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            count += totalPossiblePath(byteArr, visited, i + 1, j);
        }
        if (i != 0 && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            count += totalPossiblePath(byteArr, visited, i - 1, j);
        }
        visited[i][j] = false;
        return count;
    }
}
