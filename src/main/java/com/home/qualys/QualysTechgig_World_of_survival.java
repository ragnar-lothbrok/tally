package com.home.qualys;

import java.util.Arrays;

public class QualysTechgig_World_of_survival {

    public int[] survivalcells(int[] input1, int[] input2) {
        int[] tempInput2 = new int[input2.length];
        if (input1 == null || input2 == null || input1.length > 7 || (input1[0] * input1[1] != input2.length))
            return input2;
        int rowCount = input1[0];
        int colCount = input1[1];

        int totalNeighbour = 0;
        for (int i = 0; i < input1[6]; i++) {
            for (int j = 0; j < input2.length; j++) {
                totalNeighbour = 0;
                int up = ((j - colCount < 0 ? -1 : (j - colCount)));
                int down = ((j + colCount >= ((rowCount * colCount)) ? -1 : (j + colCount)));
                int right = (j % colCount == 0 ? -1 : j - 1);
                int left = (j % colCount == (colCount - 1) ? -1 : j + 1);

                int upright = (right == -1 ? -1 : up - 1);
                int downright = (right == -1 ? -1 : down - 1);
                int upLeft = (left == -1 ? -1 : up + 1);
                int downLeft = (left == -1 ? -1 : down + 1);
                ;

                if (up >= 0 && input2[up] == 1)
                    totalNeighbour += 1;
                if (down >= 0 && input2[down] == 1)
                    totalNeighbour += 1;
                if (right >= 0 && input2[right] == 1)
                    totalNeighbour += 1;
                if (left >= 0 && input2[left] == 1)
                    totalNeighbour += 1;
                if (upLeft >= 0 && input2[upLeft] == 1)
                    totalNeighbour += 1;
                if (downLeft >= 0 && input2[downLeft] == 1)
                    totalNeighbour += 1;
                if (upright >= 0 && input2[upright] == 1)
                    totalNeighbour += 1;
                if (downright >= 0 && input2[downright] == 1)
                    totalNeighbour += 1;

                if (input2[j] == 1) {
                    if (input1[2] <= totalNeighbour && input1[3] >= totalNeighbour) {
                        tempInput2[j] = 1;
                    } else {
                        tempInput2[j] = 0;
                    }
                } else {
                    if (input1[4] <= totalNeighbour && input1[5] >= totalNeighbour) {
                        tempInput2[j] = 1;
                    } else {
                        tempInput2[j] = 0;
                    }
                }
            }
            input2 = Arrays.copyOf(tempInput2, tempInput2.length);
            Arrays.fill(tempInput2, 0);
        }
        return input2;
    }

    public void display(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new QualysTechgig_World_of_survival().survivalcells(new int[] { 6, 6, 2, 3, 3, 3, 2 }, new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
                0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 });
        new QualysTechgig_World_of_survival().survivalcells(new int[] { 3, 4, 2, 3, 3, 3, 3 }, new int[] { 0, 1, 0, 0, 0, 1, 1, 0, 1, 0,
                1, 0 });
        new QualysTechgig_World_of_survival().survivalcells(new int[] { 3, 4, 2, 3, 3, 3, 4 }, new int[] { 0, 1, 0, 0, 0, 1, 1, 0, 1, 0,
                1, 0 });
    }
}
