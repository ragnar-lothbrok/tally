package com.home.tbt;

public class WordMatrix {
    private char[][] board = { { 'a', 'b', 'c', 'd' }, { 'e', 'f', 'g', 'h' }, { 'i', 'j', 'a', 'b' },
            { 'm', 'n', 'c', 'c' }, };

    String word = "abc";

    public void search() {
        // from each cell of the matrix, search for the pattern!
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int traverse[][] = initializeTraverseBoard();
                search(0, i, j, traverse);
            }
        }
    }

    private void search(int depth, int row, int column, int[][] traverse) {
        if (board[row][column] != word.charAt(depth))
            return;

        depth++;
        if (depth == word.length()) { // if the word has been found
            traverse[row][column] = depth;
            printCoordinates(traverse);
            traverse[row][column] = 0;
            System.out.println();
            // System.out.println(word);
            return;
        } else { // if the word has not been found, but a suffix is found, go to
                 // its neighbours which are not discovered yet!
            traverse[row][column] = depth;
            if ((row - 1) >= 0 && (column - 1) >= 0 && traverse[row - 1][column - 1] == 0) {
                search(depth, row - 1, column - 1, traverse);
            }
            if (column - 1 >= 0 && traverse[row][column - 1] == 0) {
                search(depth, row, column - 1, traverse);
            }
            if (row + 1 < traverse.length && column - 1 >= 0 && traverse[row + 1][column - 1] == 0) {
                search(depth, row + 1, column - 1, traverse);
            }
            if (row + 1 < traverse.length && traverse[row + 1][column] == 0) {
                search(depth, row + 1, column, traverse);
            }
            if (row + 1 < traverse.length && column + 1 < traverse.length && traverse[row + 1][column + 1] == 0) {
                search(depth, row + 1, column + 1, traverse);
            }
            if (column + 1 < traverse.length && traverse[row][column + 1] == 0) {
                search(depth, row, column + 1, traverse);
            }
            if (column + 1 < traverse.length && row - 1 >= 0 && traverse[row - 1][column + 1] == 0) {
                search(depth, row - 1, column + 1, traverse);
            }
            if (row - 1 >= 0 && traverse[row - 1][column] == 0) {
                search(depth, row - 1, column, traverse);
            }
            traverse[row][column] = 0;
        }

    }

    private void printCoordinates(int[][] boolBoard) {
        int start = 1;
        int end = word.length() + 1;

        for (int count = start; count < end; count++) {
            for (int i = 0; i < boolBoard.length; i++) {
                boolean isFound = false;
                for (int j = 0; j < boolBoard[i].length; j++) {
                    if (boolBoard[i][j] == count) {
                        System.out.print("(" + i + "," + j + ") ");
                        isFound = true;
                        break;
                    }
                }
                if (isFound)
                    break;
            }
        }
    }

    private int[][] initializeTraverseBoard() {
        int[][] res = new int[board.length][board.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WordMatrix wm = new WordMatrix();
        // wm.word = "aba";
        wm.search();
    }
}
