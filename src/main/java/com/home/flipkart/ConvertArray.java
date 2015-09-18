package com.home.flipkart;

public class ConvertArray {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

        convertArray(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void convertArray(int[] arr, int length) {
        for (int i = 1; i < arr.length-1; i++) {
            int actual = getIndex(arr.length, i);
            while(actual<i){
                actual = getIndex(arr.length, actual);
            }
            int temp = arr[i];
            arr[i] = arr[actual];
            arr[actual] = temp;
        }

    }
    
    public static int getIndex(int length,int i){
        int rem = (i % (length / 3));
        int pos = i / (length / 3);
        int actual = rem * 3 + pos;
        return actual;
    }
}
