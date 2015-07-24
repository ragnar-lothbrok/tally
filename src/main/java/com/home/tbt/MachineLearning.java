package com.home.tbt;

public class MachineLearning {

    public static void main(String[] args) {

        MachineLearning.word_count(2, new String[] { "A#S", "S#T" }, "AS");

        MachineLearning.word_count(5, new String[] { "E#D#E#E#E", "D#I#S#K#E", "E#S#E#E#E", "E#C#E#E#E", "E#E#E#E#E" },
                "DISK");

        MachineLearning.word_count(3, new String[] { "A#A#K", "A#S#K", "A#K#K" }, "ASK");

        MachineLearning.word_count(5, new String[] { "E#D#E#E#E", "D#I#S#K#K", "E#S#E#S#E", "E#C#I#E#E", "E#D#I#S#K" },
                "DISK");

    }

    public static int word_count(int input1, String[] input2, String input3) {
        wordCount = 0;
        char[][] board = new char[input1][input1];
        for (int i = 0; i < input2.length; i++) {
            String str[] = input2[i].trim().split("#");
            for (int j = 0; j < input1; j++) {
                board[i][j] = str[j].trim().charAt(0);
            }
        }
        search(board, input3);
        return wordCount;
    }

    private static int wordCount = 0;

    public static void search(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int traverse[][] = initializeTraverseBoard(board);
                searchTopToBottom(0, i, j, traverse, board, word);
            }
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                int traverse[][] = initializeTraverseBoard(board);
                searchBottomToTop(0, i, j, traverse, board, word);
            }
        }
    }

    private static void searchBottomToTop(int depth, int row, int column, int[][] traverse, char[][] board, String word) {
        if (board[row][column] != word.charAt(depth))
            return;
        depth++;
        if (depth == word.length()) { // if the word has been found
            traverse[row][column] = depth;
            wordCount++;
            traverse[row][column] = 0;
            return;
        } else {
            traverse[row][column] = depth;
            if (depth >= 2) {

                if (row + 1 < traverse.length && column - 1 >= 0
                        && traverse[row][column] == traverse[row + 1][column - 1] + 1) {
                    if (row - 1 >= 0 && column + 1 < traverse.length && traverse[row - 1][column + 1] == 0) {
                        searchTopToBottom(depth, row - 1, column + 1, traverse, board, word);
                    }
                } else if (row + 1 < traverse.length && traverse[row][column] == traverse[row + 1][column] + 1) {
                    if (row - 1 >= 0 && traverse[row - 1][column] == 0) {
                        searchTopToBottom(depth, row - 1, column, traverse, board, word);
                    }
                }
                traverse[row][column] = 0;
            } else {
                if (row - 1 >= 0 && column + 1 < traverse.length && traverse[row - 1][column + 1] == 0) {
                    searchBottomToTop(depth, row - 1, column + 1, traverse, board, word);
                }
                if (row - 1 >= 0 && traverse[row - 1][column] == 0) {
                    searchBottomToTop(depth, row - 1, column, traverse, board, word);
                }
                traverse[row][column] = 0;
            }
        }
    }

    private static void searchTopToBottom(int depth, int row, int column, int[][] traverse, char[][] board, String word) {
        if (board[row][column] != word.charAt(depth))
            return;
        depth++;
        if (depth == word.length()) { // if the word has been found
            traverse[row][column] = depth;
            wordCount++;
            traverse[row][column] = 0;
            return;
        } else {
            traverse[row][column] = depth;
            if (depth >= 2) {
                if (traverse[row][column] == traverse[row - 1][column - 1] + 1) {
                    if (row + 1 < traverse.length && column + 1 < traverse.length && traverse[row + 1][column + 1] == 0) {
                        searchTopToBottom(depth, row + 1, column + 1, traverse, board, word);
                    }
                } else if (row - 1 >= 0 && traverse[row][column] == traverse[row - 1][column] + 1) {
                    if (row + 1 < traverse.length && traverse[row + 1][column] == 0) {
                        searchTopToBottom(depth, row + 1, column, traverse, board, word);
                    }
                } else if (column - 1 >= 0 && traverse[row][column] == traverse[row][column - 1] + 1) {
                    if (column + 1 < traverse.length && traverse[row][column + 1] == 0) {
                        searchTopToBottom(depth, row, column + 1, traverse, board, word);
                    }
                } else if (row - 1 >= 0 && column + 1 < traverse.length
                        && traverse[row][column] == traverse[row - 1][column + 1] + 1) {
                    if (column + 1 < traverse.length && row - 1 >= 0 && traverse[row - 1][column + 1] == 0) {
                        searchTopToBottom(depth, row - 1, column + 1, traverse, board, word);
                    }
                }
                traverse[row][column] = 0;
            } else {
                if (row + 1 < traverse.length && column + 1 < traverse.length && traverse[row + 1][column + 1] == 0) {
                    searchTopToBottom(depth, row + 1, column + 1, traverse, board, word);
                }
                if (row + 1 < traverse.length && traverse[row + 1][column] == 0) {
                    searchTopToBottom(depth, row + 1, column, traverse, board, word);
                }
                if (column + 1 < traverse.length && traverse[row][column + 1] == 0) {
                    searchTopToBottom(depth, row, column + 1, traverse, board, word);
                }
                if (column + 1 < traverse.length && row - 1 >= 0 && traverse[row - 1][column + 1] == 0) {
                    searchTopToBottom(depth, row - 1, column + 1, traverse, board, word);
                }
                traverse[row][column] = 0;
            }
        }
    }

    private static int[][] initializeTraverseBoard(char[][] board) {
        int[][] res = new int[board.length][board.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = 0;
            }
        }
        return res;
    }

}
