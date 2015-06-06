package com.home.misc;

public class PrintSpiral {

    public static void main(String[] args) {
        int count = 0;
        int[][] dummyArr = new int[8][8];
        for (int i = 0; i < dummyArr[0].length; i++) {
            for (int j = 0; j < dummyArr.length; j++) {
                dummyArr[i][j] = (count++);
            }
        }
        displayPrint(dummyArr);
        printSpiral(dummyArr);
    }

    public static void displayPrint(int[][] dummyArr) {
        for (int i = 0; i < dummyArr[0].length; i++) {
            for (int j = 0; j < dummyArr.length; j++) {
                System.out.print(dummyArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printSpiral(int[][] dummyArr) {
        int rowMax = dummyArr.length;
        int colMax = dummyArr.length;
        int rowMin = 0;
        int colMin = 0;
        for (int i = rowMin; i < rowMax; i++) {

            for (int j = colMin; j < colMax; j++) {
                System.out.print(dummyArr[i][j] + " ");
            }
            rowMin++;

            for (int k = rowMin; k < rowMax; k++) {
                System.out.print(dummyArr[k][colMax - 1] + " ");
            }
            colMax--;

            for (int l = colMax - 1; l >= colMin; l--) {
                System.out.print(dummyArr[rowMax - 1][l] + " ");
            }
            rowMax--;

            for (int m = rowMax; m > rowMin; m--) {
                System.out.print(dummyArr[m - 1][colMin] + " ");
            }
            colMin++;
        }
    }

}
