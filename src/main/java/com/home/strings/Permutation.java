package com.home.strings;

public class Permutation {

    private static String inputString = "aaa";

    public static void main(String[] args) {
        findPermutation(inputString, "");
    }

    private static void findPermutation(String inpuString, String outputString) {
        if (outputString.length() == 3) {
            System.out.println(outputString);
        }
        for (int i = 0; i < inpuString.length(); i++) {
            findPermutation(inpuString.substring(i), inpuString.substring(i + 1, inpuString.length()));
        }
    }

}
