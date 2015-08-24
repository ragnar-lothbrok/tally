package com.he.july;

import java.util.Random;

public class Shuffle {

    public static void main(String[] args) {
        int arr[] = new int[52];
        int shuffled[] = new int[52];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            shuffled[i] = i;
        }

        for (int i = shuffled.length - 1; i >= 0; i--) {
                int rand = (int) ((Math.abs(new Random().nextInt()))%(i+1));
                int temp = shuffled[rand];
                shuffled[rand]=shuffled[i];
                shuffled[i] = temp;
        }
        
        printArray(shuffled);
    }
    
    static void printArray (int arr[])
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
