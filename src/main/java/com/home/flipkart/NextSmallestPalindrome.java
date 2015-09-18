package com.home.flipkart;

public class NextSmallestPalindrome {

    public static void main(String[] args) {
        findPalindrome(new StringBuffer("250"));
        findPalindrome(new StringBuffer("123"));
        findPalindrome(new StringBuffer("393"));
        findPalindrome(new StringBuffer("4512"));
        findPalindrome(new StringBuffer("1234"));
        findPalindrome(new StringBuffer("1997"));
        findPalindrome(new StringBuffer("1897"));
    }

    public static void findPalindrome(StringBuffer str) {
        StringBuffer result = new StringBuffer(str);
        if (str.length() % 2 == 0) {
            for (int i = 0; i < result.length() / 2; i++) {
                char ch = result.charAt(i);
                result.setCharAt(result.length() - i - 1, ch);
            }
            if (Integer.parseInt(str.toString()) < Integer.parseInt(result.toString())) {
                System.out.println(str+" :>>> "+result);
            }else{
                if (result.charAt(result.length() / 2) < '9' && result.charAt(result.length() / 2-1) < '9') {
                    result.setCharAt(result.length() / 2, ((char) (result.charAt(result.length() / 2) + 1)));
                    result.setCharAt((result.length() / 2)-1, ((char) (result.charAt((result.length() / 2)-1) + 1)));
                    System.out.println(str+" :>>> "+result);
                }else{
                    result = roundUp(str);
                    for (int i = 0; i < result.length() / 2; i++) {
                        char ch = result.charAt(i);
                        result.setCharAt(result.length() - i - 1, ch);
                    }
                    System.out.println(str+" :>>> "+result);
                }
            }
            
        } else {
            for (int i = 0; i < result.length() / 2; i++) {
                char ch = result.charAt(i);
                result.setCharAt(result.length() - i - 1, ch);
            }
            if (Integer.parseInt(str.toString()) < Integer.parseInt(result.toString())) {
                System.out.println(str+" :>>> "+result);
            } else {
                if (result.charAt(result.length() / 2) < '9') {
                    result.setCharAt(result.length() / 2, ((char) (result.charAt(result.length() / 2) + 1)));
                    System.out.println(str+" :>>> "+result);
                } else {
                    result = roundUp(str);
                    for (int i = 0; i < result.length() / 2; i++) {
                        char ch = result.charAt(i);
                        result.setCharAt(result.length() - i - 1, ch);
                    }
                    System.out.println(str+" :>>> "+result);
                }
            }
        }
    }

    public static StringBuffer roundUp(StringBuffer str) {
        int increment = (int) Math.pow(10, str.length() / 2);
        return new StringBuffer(((Integer.parseInt(str.toString()) / increment) + 1) * increment + "");
    }

}
