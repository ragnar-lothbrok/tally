package com.he.codemania_4aug;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//https://www.hackerearth.com/problem/algorithm/palindrome-count-1/
public class Solution3 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        longestPalindromeSimple(line);
    }

    static int count1 = 0;

    static public String intermediatePalindrome(String s, int left, int right) {
        if (left > right)
            return null;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count1++;
        }
        return s.substring(left + 1, right);
    }

    public static void longestPalindromeSimple(String s) {
        count1 = 0;
        if (s != null) {
            String longest = s.substring(0, 1);
            for (int i = 0; i < s.length(); i++) {
                // odd cases like 121
                String palindrome = intermediatePalindrome(s, i, i);
                if (palindrome.length() > longest.length()) {
                    longest = palindrome;
                }
                // even cases like 1221
                palindrome = intermediatePalindrome(s, i, i + 1);
                if (palindrome.length() > longest.length()) {
                    longest = palindrome;
                }
            }
            System.out.println(count1);
        }
    }
}