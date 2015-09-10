package com.he.seagate;

public class Solution2 {
    // Driver method to test below methods
    public static long count =0;
    public static void main(String[] args) {
        System.out.println("First Test");
        char set1[] = { 'a', 'b' ,'c'};
        int k = 3;
        printAllKLength(set1, k);
    }

    // The method that prints all possible strings of length k. It is
    // mainly a wrapper over recursive function printAllKLengthRec()
    static void printAllKLength(char set[], int k) {
        count =0;
        int n = set.length;
        printAllKLengthRec(set, "", n, k);
        System.out.println(count);
    }

    // The main recursive method to print all possible strings of length k
    static void printAllKLengthRec(char set[], String prefix, int n, int k) {

        // Base case: k is 0, print prefix
        if (k == 0) {
//            System.out.println(prefix);
           count++;
            return;
        }

        // One by one add all characters from set and recursively
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {

            // Next character of input added
            String newPrefix = prefix + set[i];

            // k is decreased, because we have added a new character
            printAllKLengthRec(set, newPrefix, n, k - 1);
        }
    }
}
