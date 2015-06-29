package com.home.codemonk.searching;

public class ThoughtWorks {

    public static void main(String[] args) {

    }

    public static String[] nearest_shoot_point(int[] input1, int[] input2, int[] input3, String[] input4) {
        String result = "";

        int row = input1[0];
        int col = input1[1];
        int[][] matrix = new int[row][col];
        for (String str : input4) {
            String blocks[] = str.trim().split("#");
            matrix[Integer.parseInt(blocks[0].trim()) - 1][Integer.parseInt(blocks[0].trim()) - 1] = -1;
        }

        
        return result.split(";");
    }

}
