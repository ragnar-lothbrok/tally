package com.he.NITC_Encode;

public class SubArraySum {

    public static void main(String[] args) {

        int arr[] = { 1, 15, 2, 4, 8, 9, 5, 10, 23 };
        subArray(arr, 23);
    }

    private static void subArray(int arr[], int num) {
        int n = arr.length;
        int start = 0, temp = arr[0];

        for (int i = 1; i <= arr.length; i++) {
            while (temp > num && start < i - 1) {
                temp -= arr[start];
                start++;
            }

            if (temp == num) {
                System.out.println(start + " " + (i - 1));
            }
            
            if (i < n) {
                temp += arr[i];
            }

        }
    }
}
