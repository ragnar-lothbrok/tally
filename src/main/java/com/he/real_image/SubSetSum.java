package com.he.real_image;

public class SubSetSum {

    // Only returns true or false
    public static boolean hasSum(int[] array, int start, int sum) {
        if (sum == 0) // found the sum?
            return true;

        if (start > array.length - 1)// reached end of the array?
            return false;

        return hasSum(array, start + 1, sum) || hasSum(array, start + 1, sum - array[start]);

    }

    // Recursive Programming
    public static void find(int[] A, int currSum, int index, int sum, int[] solution) {
        if (currSum == sum) {
            System.out.print("\nSum found");
            for (int i = 0; i < solution.length; i++) {
                if (solution[i] == 1) {
                    System.out.print("  " + A[i]);
                }
            }
        } else if (index == A.length) {
            return;
        } else {
            solution[index] = 1;// select the element
            currSum += A[index];
            find(A, currSum, index + 1, sum, solution);

            solution[index] = 0;// do not select the element
            currSum -= A[index];
            find(A, currSum, index + 1, sum, solution);
        }
        return;
    }

    // Find if Sum exists using Dynamic Programming
    public static boolean subSetDP(int[] A, int sum) {
        boolean[][] solution = new boolean[A.length + 1][sum + 1];
        // if sum is not zero and subset is 0, we can't make it
        for (int i = 1; i <= sum; i++) {
            solution[0][i] = false;
        }
        // if sum is 0 the we can make the empty subset to make sum 0
        for (int i = 0; i <= A.length; i++) {
            solution[i][0] = true;
        }
        //
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= sum; j++) {
                // first copy the data from the top
                solution[i][j] = solution[i - 1][j];

                // If solution[i][j]==false check if can be made
                if (solution[i][j] == false && j >= A[i - 1])
                    solution[i][j] = solution[i][j] || solution[i - 1][j - A[i - 1]];
            }
        }
        return solution[A.length][sum];
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6 };
        find(arr, 0, 0, 8, new int[8]);
        System.out.println();
        // System.out.println(hasSum(arr, 0, 8));

        System.out.println(subSetDP(arr, 8));
    }
}
