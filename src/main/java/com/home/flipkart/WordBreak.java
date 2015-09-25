package com.home.flipkart;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {

        String dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
                "like", "ice", "cream" };

        Set<String> set = new HashSet<String>();
        for (int i = 0; i < dictionary.length; i++) {
            set.add(dictionary[i]);
        }

        String str[] = {"ilikesamsung","ilikelikeimangoiii","abc"};
        for(String inputString : str){
            if(!findMatching(inputString, set, "")) System.out.println("Not Found!!!");
        }

    }

    public static boolean findMatching(String inputString, Set<String> dictionary, String result) {
        if (inputString.length() == 0) {
            System.out.println(result);
            return true;
        }
        for (int i = 1; i <= inputString.length(); i++) {
            if (dictionary.contains(inputString.substring(0, i))
                    && findMatching(inputString.substring(i, inputString.length()), dictionary,
                            result + inputString.substring(0, i) + " ")) {
                return true;
            }
        }
        return false;
    }

    // dynamic programming
    public static boolean isMatching(String inputString, Set<String> dictionary) {
        boolean[] dp = new boolean[inputString.length() + 1];
        for (int i = 1; i < inputString.length(); i++) {
            if (dp[i] == false && dictionary.contains(inputString.substring(0, i))) {
                dp[i] = true;
            }

            if (dp[i]) {

                if (i == inputString.length()) {
                    return true;
                }

                for (int j = i + 1; j < inputString.length(); j++) {
                    if (dp[j] == false && dictionary.contains(inputString.substring(i, j - i))) {
                        dp[i] = true;
                    }

                    if (dp[i] && i == inputString.length()) {
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
