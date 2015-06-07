package com.home.codehunt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StudentsScore {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        try {
            line = br.readLine();
            line =line.replace("  ", " ");
            String[] numberStrs = line.split(" ");
            int[] numbers = new int[numberStrs.length];
            for (int j = 0; j < numberStrs.length; j++) {
                numbers[j] = Integer.parseInt(numberStrs[j]);
            }
            System.out.println(getTotalConsecutiveSum(numbers));
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public static int getTotalConsecutiveSum(int[] arr) {
        int currSum = 0;
        int maxSum = 0;
        for (int count = 0; count < arr.length; count++) {
            currSum += arr[count];
            if (maxSum <= currSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
