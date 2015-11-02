package com.he.bits_28_Aug;

public class SolutionTest {

    public static void containsVowels(String word) {
        String vowels = "aeiouys";
        if (word == null || word.length() < vowels.length()) {
            System.out.println("Please provide valid input.");
        }
        int arr[] = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                arr[word.charAt(i) - 97]++;
            } else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                arr[word.charAt(i) - 65]++;
            }
        }

        StringBuilder sb = new  StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                while(arr[i] > 0){
                    sb.append(((char)arr[i]+97));
                    arr[i]--;
                }
            }
        }
        
        
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String word = "namemobui";
        containsVowels(word);
    }

}
