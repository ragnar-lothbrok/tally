package com.home.qualys;

import java.util.HashMap;
import java.util.Map;

public class BoyceMooreAlgorithm {

    public static int matchPattern(String pattern, String text) {
        Map<Character, Integer> tableMap = constructBadCharacterShiftTable(pattern);

        int n = text.length();
        int m = pattern.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = (tableMap.get(text.charAt(i)) == null ? pattern.length()-1:tableMap.get(text.charAt(i)));
                    break;
                }
            }
            if (skip == 0)
                return i;
        }
        return n;
    }

    public static Map<Character, Integer> constructBadCharacterShiftTable(String pattern) {
        Map<Character, Integer> tableMap = new HashMap<Character, Integer>();
        if (pattern != null && pattern.length() > 0) {
            for (int i = 0; i < pattern.length(); i++) {
                if (i == pattern.length() - 1 && tableMap.get(pattern.charAt(i)) == null) {
                    tableMap.put(pattern.charAt(i), pattern.length());
                } else if (!(i == pattern.length() - 1 && tableMap.get(pattern.charAt(i)) != null)) {
                    tableMap.put(pattern.charAt(i), Math.max(1, (pattern.length() - i - 1)));
                }
            }
        }
        return tableMap;
    }

    public static void main(String[] args) {
        String pattern = "GCAGAGAG";
        String inputString = "GCATCGCAGAGAGTATACAGTACG";
        System.out.println(matchPattern(pattern, inputString));
    }

}
